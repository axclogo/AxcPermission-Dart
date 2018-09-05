package cloud_servce.service;

import java.math.BigDecimal;

import javax.persistence.Transient;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.hazelcast.util.JsonUtil;
//import com.hazelcast.util.MD5Util;

import cloud_servce.conf.ConstantConfig;
import cloud_servce.dao.IUserDao;
import cloud_servce.entity.User;
import cloud_servce.result.FailureResult;
import cloud_servce.result.ResultBody;
import cloud_servce.result.SuccessResult;
import cloud_servce.util.UpdateUtil;
import cloud_servce.util.MD5Util;

@Service
public class UserService {
	@Autowired
	private IUserDao userDao;

	public UserService() {
		// TODO 自动生成的构造函数存根
	}

	public User getByPhone(String phone){
		return userDao.findByUserPhone(phone);
	}

	public User getById(Integer userId){
		return userDao.findOne(userId);
	}

	public User save(User user){
		return userDao.save(user);
	}


	public Object login(String phone, String password){
		ResultBody result;
		if (phone == null) {
			result = new FailureResult(ConstantConfig.EMPTY_PHONE_PROMPT);
			return result;
		}
		User user = userDao.findByUserPhoneAndUserPassword(phone, password);
		if (user == null) {
			user = userDao.findByUserPhone(phone);
			if (user==null) {
				result = new FailureResult("401","手机号未注册");
			}else{
				result = new FailureResult("手机号或密码错误");
			}
		}else{
			result = new SuccessResult("登录成功", user);
		}
		return result;
	}

	@Transactional
	public Object register(String phone, String password){
		ResultBody result;
		if (phone == null) {
			result = new FailureResult(ConstantConfig.EMPTY_PHONE_PROMPT);
			return result;
		}
		if (password == null) {
			result = new FailureResult("密码不能为空！");
			return result;
		}
		if (password.length() < 6) {
			result = new FailureResult("密码长度至少为6");
			return result;
		}
		User existUser = userDao.findByUserPhone(phone);
		if (existUser!=null) {
			result = new FailureResult("手机号已注册");
		}else{
			User user = new User();
			user.setUserPhone(phone);
			user.setUserPassword(password);
			user.setUserName(String.format("AxcCloud-%s", phone));
			user.setUserCover(ConstantConfig.AVATAR);
			user.setUserDescribe("这家伙很懒，什么都没留下");
			user.setUserLevel(0);
			user.setIsAdmin(0);
			userDao.save(user);

			result = new SuccessResult("注册成功", user);
		}
		return result;
	}

	@Transactional
	public Object getInfo(Integer userId){
		User source_user = userDao.findByUserId(userId);
		ResultBody result;
		if (source_user == null) {
			result = new FailureResult("用户不存在");
		}else {
			result = new SuccessResult("获取用户信息成功", source_user);
		}
		return result;
	}

	@Transactional
	public Object updateInfo(User user){
		User source_user = userDao.findByUserId(user.getUserId());
		ResultBody result;
		if (source_user == null) {
			result = new FailureResult("用户不存在");
		}else {
			UpdateUtil.copyNonNullProperties(user, source_user);
			user = userDao.save(source_user);
			result = new SuccessResult("更新用户信息成功", source_user);
		}
		return result;
	}

	@Transactional
	public Object resetPassword(Integer userId , String newPassword, String token){
		ResultBody result;
		token = token.toLowerCase();
		String checkToken = MD5Util.encrypt(String.format("%d-%s-AXCCLOUD", userId,newPassword)).toLowerCase();
		if (checkToken.equals(token)) {
			User source_user = userDao.findByUserId(userId);
			if (source_user == null) {
				result = new FailureResult("用户不存在");
			}else {
				source_user.setUserPassword(newPassword);
				userDao.save(source_user);
				result = new SuccessResult("更新用户密码成功", source_user);
			}
		}else {
			result = new FailureResult("校验失败！无法修改密码");
		}
		return result;
	}

}
