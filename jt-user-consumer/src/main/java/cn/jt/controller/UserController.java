package cn.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jt.feign.UserFeign;
import cn.jt.pojo.User;

@RestController
public class UserController {

	@Autowired
	private UserFeign userFeign;

	@RequestMapping("/user/findAll")
	public List<User> findAll() {
		return userFeign.findAll();
	}

	@RequestMapping("/user/find/{name}")
	public List<User> find(@PathVariable String name) {
		return userFeign.find(name);
	}

	@RequestMapping("/user/add/{name}/{birthday}/{address}")
	public String add(@PathVariable String name, @PathVariable String birthday, @PathVariable String address) {

		return userFeign.add(name, birthday, address);
		
	}

	@RequestMapping("/user/update/{name}/{birthday}/{address}/{id}")
	public String update(@PathVariable String name, @PathVariable String birthday, @PathVariable String address,
			@PathVariable Long id) {

		return userFeign.update(name, birthday, address, id);

	}

	@RequestMapping("/user/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		return userFeign.delete(id);
	}

}
