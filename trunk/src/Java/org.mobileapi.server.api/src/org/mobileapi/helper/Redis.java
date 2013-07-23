package org.mobileapi.helper;

import javax.ejb.Singleton;
import javax.inject.Named;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Redis {

	private static String _host = "localhost";
	private static int _port = 6379;
	
	private static JedisPool pool;
	
	public void configure(String host, int port) {
		_host = host;
		_port = port;
	    pool = new JedisPool(_host,_port);
	}
	
	public void startup() {
		pool = new JedisPool(_host,_port);
	}
	
	public void shutdown() {
		pool.destroy();
	}
	
	private Object sem = new Object();
	
	public void set(String key, String val)
	{
		 Jedis jedis = pool.getResource();
		 jedis.set(key, val);
		 pool.returnResource(jedis);
	}
	
	public String get(String key)
	{
		 Jedis jedis = pool.getResource();
		 String val = jedis.get(key);
		 pool.returnResource(jedis);
		 return val;
	}
}

