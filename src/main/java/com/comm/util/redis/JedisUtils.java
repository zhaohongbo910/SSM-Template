package com.comm.util.redis;

import java.util.List;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtils {
	private static JedisPool jedisPool;

	/**
	 * 获取资源
	 * @return
	 */
	public static Jedis getResource() {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
		} catch (Exception e) {
			if (jedis != null) {
				jedis.close();
			}
			throw e;
		}
		return jedis;
	}

	public static String set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String result = jedis.set(key, value);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 正确释放资源
			jedis.close();// 销毁本次调用
		}
		return null;
	}

	public static String get(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String result = jedis.get(key);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 正确释放资源
			jedis.close();// 销毁本次调用
		}
		return null;
	}

	public static Boolean exists(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Boolean result = jedis.exists(key);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 正确释放资源
			jedis.close();// 销毁本次调用
		}
		return null;
	}

	public static Long expire(String key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Long result = jedis.expire(key, seconds);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 正确释放资源
			jedis.close();// 销毁本次调用
		}
		return null;
	}

	public static Long ttl(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Long result = jedis.ttl(key);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 正确释放资源
			jedis.close();// 销毁本次调用
		}
		return 0L;
	}

	public static Long incr(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Long result = jedis.incr(key);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 正确释放资源
			jedis.close();// 销毁本次调用
		}
		return 0L;
	}

	public static Long hset(String key, String field, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Long result = jedis.hset(key, field, value);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 正确释放资源
			jedis.close();// 销毁本次调用
		}
		return 0L;
	}

	public static String hget(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String result = jedis.hget(key, field);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 正确释放资源
			jedis.close();// 销毁本次调用
		}
		return null;
	}

	public static Long hdel(String key, String... field) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Long result = jedis.hdel(key, field);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 正确释放资源
			jedis.close();// 销毁本次调用
		}
		return 0L;
	}

	public static Boolean hexists(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Boolean result = jedis.hexists(key, field);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 正确释放资源
			jedis.close();// 销毁本次调用
		}
		return Boolean.FALSE;
	}

	public static List<String> hvals(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			List<String> result = jedis.hvals(key);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 正确释放资源
			jedis.close();// 销毁本次调用
		}
		return null;
	}

	public static Long del(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Long result = jedis.del(key);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 正确释放资源
			jedis.close();// 销毁本次调用
		}
		return 0L;
	}

	public static long lpush(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			long result = jedis.lpush(key, value);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 正确释放资源
			jedis.close();// 销毁本次调用
		}
		return 0L;
	}

	public static List<String> lrange(String key, long start, long end) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			List<String> result = jedis.lrange(key, start, end);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 正确释放资源
			jedis.close();// 销毁本次调用
		}
		return null;
	}
}
