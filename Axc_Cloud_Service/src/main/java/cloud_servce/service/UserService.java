package cloud_servce.service;

import java.math.BigDecimal;

import javax.persistence.Transient;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.hazelcast.util.JsonUtil;
import com.hazelcast.util.MD5Util;

import cloud_servce.dao.IUserDao;
import cloud_servce.entity.User;
import cloud_servce.result.FailureResult;
import cloud_servce.result.ResultBody;
import cloud_servce.result.SuccessResult;


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
		User user = userDao.findByUserPhoneAndUserPassword(phone, password);
		ResultBody result;
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
		Gson gson = new Gson();
		String json = gson.toJson(result);
		return json;
	}
	
//	@Transactional
//	public Object register(String phone, String password){
//		User existUser = userDao.findByPhone(phone);
//		ResultBody result;
//		if (existUser!=null) {
//			result = new FailureResult("手机号已注册");
//		}else{
//			//用户注册同时注册环信账户
//			User user = new User(0, new BigDecimal(0), MD5Util.encrypt(password), phone, ConstantConfig.AVATAR, "", "");
//			userDao.save(user);
//			String token = easemobService.getAccessToken();
//			String username = "user_" + user.getUserId();
//			EasemobUtil.register(token, username, "123456");
//			result = new SuccessResult("注册成功", user);
//		}
//		return JsonUtil.resultFilter(result);
//	}
}
