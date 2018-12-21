package cn.jt.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jt.pojo.User;

@FeignClient("jt-user-provider")
public interface UserFeign {

	
	@RequestMapping("/user/findAll")
	public List<User> findAll();
	
	
	@RequestMapping("/user/find/{name}")
	public List<User> find(@PathVariable("name") String name);
	
	@RequestMapping("/user/add/{name}/{birthday}/{address}")
	public String add(@PathVariable("name") String name,
			@PathVariable("birthday") String birthday,
			@PathVariable("address") String address);
	
	@RequestMapping("/user/update/{name}/{birthday}/{address}/{id}")
	public String update(@PathVariable("name") String name,
			@PathVariable("birthday") String birthday,
			@PathVariable("address") String address,
			@PathVariable("id") Long id);
	
	@RequestMapping("/user/delete/{id}")
	public String delete(@PathVariable("id")Long id);
	
}
