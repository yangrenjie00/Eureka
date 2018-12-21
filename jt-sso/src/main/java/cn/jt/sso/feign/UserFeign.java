package cn.jt.sso.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.jt.common.vo.SysResult;
import cn.jt.pojo.User;

@FeignClient("jt-sso-provider")
public interface UserFeign {

	@RequestMapping("/user/check/{param}/{type}")
	public SysResult check(@PathVariable("type") Integer type,@PathVariable("param")String param);
	
	@RequestMapping("/user/register")
	public SysResult register(User user);
	
	@RequestMapping("/user/login")
	public SysResult login(@RequestParam("u") String username,@RequestParam("p")String password);
	
	@RequestMapping("/user/query/{ticket}")
	public SysResult query(@PathVariable String ticket);
	
}
