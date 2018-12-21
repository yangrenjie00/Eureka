package cn.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jt.pojo.User;
import cn.jt.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	//不拆，给Feign，不支持分拆
	@RequestMapping("/user/findAll")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@RequestMapping("/user/find/{name}")
	public List<User> find(@PathVariable String name){
		User user=new User();
		user.setName(name);
		return userService.find(user);
	}
	@RequestMapping("/user/add/{name}/{birthday}/{address}")
	public String add(User user) {
		try {
			userService.add(user);
			return "add ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "add error";
		}
	}
	@RequestMapping("/user/update/{name}/{birthday}/{address}/{id}")
	public String update(User user) {
		try {
			userService.update(user);
			return "udpate ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "udpate error";
		}
	}
	@RequestMapping("/user/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		try {
			userService.delete(id);
			return "delete OK";
		} catch (Exception e) {
			e.printStackTrace();
			return "delete error";
		}
	}
}





