package redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestRedis {

	
	@Test
	public void redis() {
		Jedis jedis=new Jedis("192.168.138.99", 7005);
		String a=jedis.get("name");
		System.out.println(a);
	}
}
