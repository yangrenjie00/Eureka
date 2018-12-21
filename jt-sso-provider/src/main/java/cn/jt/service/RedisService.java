package cn.jt.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	@Autowired	//SpringBoot集成Redis，Spring提供模板对象
	private RedisTemplate<String,String> redisTemplate;
	
	//常用方法：get/set/expire
	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	
	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}
	
	public void expire(String key, long timeout ) {
		redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
	}
	
	//设置kv和过期时间
	public void set(String key, String value, long timeout) {
		redisTemplate.opsForValue().set(key, value);
		redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
	}
}







