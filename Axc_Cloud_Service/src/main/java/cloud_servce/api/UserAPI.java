package cloud_servce.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import cloud_servce.entity.User;
import cloud_servce.service.UserService;

@RestController
@RequestMapping("user/")
@Api(tags = {"0_user"})
public class UserApi {
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "用户登录", notes = "手机号密码登录", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PostMapping("login")
	public Object login(String userPhone, String userPassword){
		return userService.login(userPhone, userPassword);
	}
	
	@ApiOperation(value = "用户注册", notes = "手机号密码注册", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PostMapping("register")
	public Object register(String userPhone, String userPassword){
		return userService.register(userPhone, userPassword);
	}
	
	@ApiOperation(value = "获取用户信息", notes = "获取某个用户信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PostMapping("getInfo")
	public Object getInfo( Integer userId ){
		return userService.getInfo(userId);
	}
	
	@ApiOperation(value = "更新用户信息", notes = "更新单个或多个用户信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PostMapping("updateInfo")
	public Object updateInfo(
			Integer userId,
			String userName,
			String userCover,
			String userDescribe,
			String userPhone){
		
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserCover(userCover);
		user.setUserDescribe(userDescribe);
		user.setUserPhone(userPhone);
		
		return userService.updateInfo(user);
	}
	
	@ApiOperation(value = "更新用户密码", notes = "校验TOKEN更新用户密码", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PostMapping("resetPassword")
	public Object resetPassword(Integer userId , String newPassword, String token){
		return userService.resetPassword(userId, newPassword, token);
	}
	
	
}
