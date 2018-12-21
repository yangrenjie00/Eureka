package cn.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.jt.common.vo.SysResult;
import cn.jt.pojo.User;
import cn.jt.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@RequestMapping("/user/check/{param}/{type}")
	public SysResult check(@PathVariable("type") Integer type,
			@PathVariable("param")String param) {
		int i=userService.check(type, param);
		if(i==1) {
			return SysResult.ok("true");
		}else{
			return SysResult.build(201, "OK", "false");
		}
	}
	
	@RequestMapping("/user/register")
	public SysResult register(User user) {
		return SysResult.ok(userService.register(user));
	}
	
	@RequestMapping("/user/login")
	public SysResult login(@RequestParam("u") String username,@RequestParam("p")String password) {
		String ticket = userService.login(username, password);
		return SysResult.ok(ticket);
	}
	
	@RequestMapping("/user/query/{ticket}")
	public SysResult query(@PathVariable String ticket) {
		String userJSON = userService.query(ticket);
		return SysResult.ok(userJSON);
	}
}
