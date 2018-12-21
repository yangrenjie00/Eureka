package cn.jt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import cn.jt.mapper.UserMapper;
import cn.jt.pojo.User;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper usermapper;
	public List<User> findAll(){
		return usermapper.selectList(null);
	}
	public List<User> find(User user){
		EntityWrapper wrapper=new EntityWrapper<>();
		wrapper.where("name like {0}", "%"+user.getName()+"%");
		return usermapper.selectList(wrapper);
	}
	public void add(User user) {
		usermapper.insert(user);
	}
	public void update(User user) {
		EntityWrapper wrapper =new EntityWrapper();
		wrapper.where("id={0}", user.getId());
		usermapper.update(user, wrapper);
	}
	public void delete(Long id) {
		usermapper.deleteById(id);
	}
}
