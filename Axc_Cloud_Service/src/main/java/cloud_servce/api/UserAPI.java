package cloud_servce.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import cloud_servce.service.UserService;

@RestController
@RequestMapping("user/")
@Api("用户相关接口")
public class UserAPI {
	@Autowired
	private UserService userService;
	
	@ApiOperation("用户登录")
	@PostMapping("login")
	public Object login(String phone, String password){
		return userService.login(phone, password);
	}

}
