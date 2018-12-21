package cn.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.jt.common.vo.SysResult;
import cn.jt.pojo.User;
import cn.jt.sso.feign.UserFeign;

@RestController
public class UserController {

	@Autowired
	private UserFeign userFeign;
	@RequestMapping("/user/check/{param}/{type}")
	public SysResult check(@PathVariable("type") Integer type,@PathVariable("param") String param) {
		return userFeign.check(type, param);
	}
	
	
	@RequestMapping("/user/register")
	public SysResult register(@RequestBody User user) {
		return userFeign.register(user);
	}
	
	@RequestMapping("/user/login")
	public SysResult login(@RequestParam("u") String username,@RequestParam("p")String password) {
		return userFeign.login(username, password);
	}
	
	@RequestMapping("/user/query/{ticket}")
	public SysResult query(@PathVariable String ticket) {
		return userFeign.query(ticket);
	}
}
