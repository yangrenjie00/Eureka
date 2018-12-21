package cn.jt.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.jt.mapper.UserMapper;
import cn.jt.pojo.User;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RedisService redisService;
	
	private static final ObjectMapper MAPPER=new ObjectMapper();
	
	private static final Map<Integer,String> TYPE_MAP =new HashMap<Integer,String>();
	
	static {
		TYPE_MAP.put(1, "username");
		TYPE_MAP.put(2, "phone");
		TYPE_MAP.put(3, "email");
	}
	public Integer check(Integer type,String param) {
		return userMapper.check(TYPE_MAP.get(type), param);
	}
	
	public String register(User user) {
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		userMapper.insert(user);
		return user.getUsername();
	}
	
	public String login(String username,String password) {
		String ticket=null;
		User u=new User();
		u.setUsername(username);
		User user = userMapper.selectOne(u);
		if(user!=null) {
		if(user.getPassword().equals(DigestUtils.md5Hex(password))) {
			try {
			//判断是否是系统用户
			ticket=DigestUtils.md5Hex("JT_TICKET_"+System.currentTimeMillis()+username);
			user.setPassword(null);
				String userJSON = MAPPER.writeValueAsString(user);
				redisService.set(ticket, userJSON, 60*60*24*7);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		}
		return ticket;
	}
	
	
	public String query(String ticket) {
		String userJson = redisService.get(ticket);
		return userJson;
	}
}




