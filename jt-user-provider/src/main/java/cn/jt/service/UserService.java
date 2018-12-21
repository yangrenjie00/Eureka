package cn.jt.service;

import java.util.List;

import cn.jt.pojo.User;

public interface UserService {
	public List<User> findAll();
	public List<User> find(User user);
	public void add(User user) ;
	public void update(User user);
	public void delete(Long id) ;

}
