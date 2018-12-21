package cn.jt.service;

import cn.jt.pojo.User;

public interface UserService {

	public Integer check(Integer type,String param);
	public String register(User user);
	public String login(String username,String password);
	public String query(String ticket);
}
