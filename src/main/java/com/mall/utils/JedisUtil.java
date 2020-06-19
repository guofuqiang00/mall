package com.mall.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;
import redis.clients.jedis.exceptions.JedisException;

import java.util.*;

@Component
public class JedisUtil {
	private static final JedisUtil redis = new JedisUtil();
	private static Logger log = Logger.getLogger(JedisUtil.class);


	private static JedisPool jedisPool;

	@Autowired
	public void setJedisPool(JedisPool jedisPool){
		JedisUtil.jedisPool = jedisPool;
	}

	private static ShardedJedisPool shardedJedisPool = null;

	/**
	 * 缓存生存时间
	 */
	private final int expire = 60000;



	public JedisPool getPool() {
		return jedisPool;
	}

	public ShardedJedisPool getShardedJedisPool() {
		return shardedJedisPool;
	}

	/**
	 * 从jedis连接池中获取获取jedis对象
	 * 
	 * @return
	 */
	public static Jedis getJedis() {
		return jedisPool.getResource();
	}

	/**
	 * 获取JedisUtil实例
	 * 
	 * @return
	 */
	public static JedisUtil getInstance() {
		return redis;
	}

	/**
	 * 回收jedis
	 * 
	 * @param jedis
	 */
	public static void returnJedis(Jedis jedis) {
		try {
			jedis.close();
        } catch (Exception e) {
        } /*finally{
        	 if (jedis != null && jedis.isConnected()) {
        		 jedisPool.returnResource(jedis);
             }
        }*/
	}

	/**
	 * 处理直接调用获取redis
	 * 
	 */
 	public static void delByKey(String key){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.del(key);
		} catch (JedisException e) {
			log.error(e.getMessage());
			if (jedis != null) {
				returnJedis(jedis);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
	}
	public static Long incrByKey(String key){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.incr(key);
		} catch (JedisException e) {
			log.error(e.getMessage());
			if (jedis != null) {
				returnJedis(jedis);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}





    public static Long decrByKey(String key, int db){
        Jedis jedis = null;
        Long incr = 0L;
        try {
            jedis = getJedis();
            Transaction tx = jedis.multi();
            tx.select(db);
            tx.decr(key);
            tx.exec();
            incr = Long.parseLong(jedis.get(key));
        } catch (JedisException e) {
            log.error(e.getMessage());
            if (jedis != null) {
                returnJedis(jedis);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            returnJedis(jedis);
        }
        return incr;
    }
	
	public static Long incrByKeyLong(String key){
		Jedis jedis = null;
		Long incr = 0L;
		try {
			jedis = getJedis();
		  return	jedis.incr(key);
		} catch (JedisException e) {
			log.error(e.getMessage());
			if (jedis != null) {
				returnJedis(jedis);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return incr;
	}


    public static Long incrByKey(String key, int db){
        Jedis jedis = null;
        Long incr = 0L;
        try {
            jedis = getJedis();
            Transaction tx = jedis.multi();
            tx.select(db);
            tx.incr(key);
            tx.exec();
            incr = Long.parseLong(jedis.get(key));
        } catch (JedisException e) {
            log.error(e.getMessage());
            if (jedis != null) {
                returnJedis(jedis);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            returnJedis(jedis);
        }
        return incr;
    }



	
	public static Long incrByKey(String key, int db, int seconds){
		Jedis jedis = null;
		Long incr = 0L;
		try {
			jedis = getJedis();
			String current = jedis.get(key);
			Transaction tx = jedis.multi();
			tx.select(db);
			if(StringUtils.isNotBlank(current)){
				tx.incr(key);
			}else{
				tx.incr(key);
				tx.expire(key, seconds);
			}
			tx.exec();
			incr = Long.parseLong(jedis.get(key));
		} catch (JedisException e) {
			log.error(e.getMessage());
			if (jedis != null) {
				returnJedis(jedis);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return incr;
	}
	
	public static Long setnx(String key, String value){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.setnx(key,value);
		} catch (JedisException e) {
			log.error(e.getMessage());
			if (jedis != null) {
				returnJedis(jedis);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}



	public static Long setnx(String key, String value, int db){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.setnx(key,value);
		} catch (JedisException e) {
			log.error(e.getMessage());
			if (jedis != null) {
				returnJedis(jedis);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}
	public static Long setnx(String key, String value, int seconds, int db){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			Long result = jedis.setnx(key,value);
			jedis.expire(key, seconds);
			return result;
		} catch (JedisException e) {
			log.error(e.getMessage());
			if (jedis != null) {
				returnJedis(jedis);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}
	/**
	 * 存缓存
	 * @param key
	 * @param value
	 * @return
	 */
	public static void set(String key, String value){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set(key,value);
		} catch (JedisException e) {
			log.error(e.getMessage());
			if (jedis != null) {
				returnJedis(jedis);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
	}
	/**
	 * 通过key获取缓存
	 * @param key
	 * @return
	 */
	public static String get(String key){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.get(key);
		} catch (JedisException e) {
			log.error(e.getMessage());
			if (jedis != null) {
				returnJedis(jedis);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}
	
	/**
	 * 设置过期时间
	 * 
	 * @param key
	 * @param seconds
	 */
	public static void expire(String key, int seconds) {
		if (seconds <= 0) {
			return;
		}
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.expire(key, seconds);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
	}

	/**
	 * 设置默认过期时间
	 * 
	 * @param key
	 */
	public void expire(String key) {
		expire(key, expire);
	}

	public static String getset(String key, String value, int db) {
		if (value == null || value.equals("")) {
			log.info("key: " + key + " 对应的value为空");
			return null;
		}
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.getSet(key, value);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}

	public static <T> T getset(String key, Object obj, int db) {
		if (obj == null || obj.equals("")) {
			log.info("key: " + key + " 对应的value为空");
			return null;
		}
		Jedis jedis = null;
		byte[] value = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			value = jedis.getSet(key.getBytes(), SerializeUtil.encodeObject(obj));
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		if (value != null && value.length > 0) {
			return SerializeUtil.decodeObject(value);
		}
		return null;
	}

	public static void set(String key, String value, int seconds, int db) {
		if (value == null || value.equals("")) {
			log.info("key: " + key + " 对应的value为空");
			return;
		}
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			jedis.setex(key, seconds, value);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
	}

	public static void set(String key, Object obj, int seconds, int db) {
		if (obj == null) {
			log.info("key: " + key + " 对应的value为空");
			return;
		}
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			jedis.setex(key.getBytes(), seconds, SerializeUtil.encodeObject(obj));
		} catch (Exception e) {
			log.error(key + "  " + e.getMessage());
			// log.error(obj + " " + e.getMessage());
		} finally {
			returnJedis(jedis);
		}
	}

	/**
	 * 设置主键
	 * @param key
	 * @param obj 存储对象
	 * @param timestamp 到期时间-时间戳 2018/12/20 11:03:00 --> 1545274980
	 * @param db 库
	 */
	public static void set(String key, Object obj, long timestamp, int db) {
		if (obj == null) {
			log.info("key: " + key + " 对应的value为空");
			return;
		}
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			jedis.set(key.getBytes(), SerializeUtil.encodeObject(obj));
			jedis.expireAt(key,timestamp);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
	}

	/**
	 * 设置缓存
	 * 
	 * 可选参数 从 Redis 2.6.12 版本开始， SET 命令的行为可以通过一系列参数来修改：
	 * 
	 * EX second ：设置键的过期时间为 second 秒。 SET key value EX second 效果等同于 SETEX key
	 * second value 。 PX millisecond ：设置键的过期时间为 millisecond 毫秒。 SET key value PX
	 * millisecond 效果等同于 PSETEX key millisecond value 。 NX ：只在键不存在时，才对键进行设置操作。
	 * SET key value NX 效果等同于 SETNX key value 。 XX ：只在键已经存在时，才对键进行设置操作。
	 * 
	 * @param key
	 * @param value
	 * @param nxxx
	 * @param expx
	 * @param time
	 * @param db
	 * 
	 */
	public static String set(String key, String value, String nxxx, String expx, long time, int db) {
		if (value == null || value.equals("")) {
			log.info("key: " + key + " 对应的value为空");
			return null;
		}
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.set(key, value, nxxx, expx, time);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}

	/**
	 * 设置缓存
	 * 
	 * 可选参数 从 Redis 2.6.12 版本开始， SET 命令的行为可以通过一系列参数来修改：
	 * 
	 * EX second ：设置键的过期时间为 second 秒。 SET key value EX second 效果等同于 SETEX key
	 * second value 。 PX millisecond ：设置键的过期时间为 millisecond 毫秒。 SET key value PX
	 * millisecond 效果等同于 PSETEX key millisecond value 。 NX ：只在键不存在时，才对键进行设置操作。
	 * SET key value NX 效果等同于 SETNX key value 。 XX ：只在键已经存在时，才对键进行设置操作。
	 * 
	 * @param key
	 * @param nxxx
	 * @param expx
	 * @param time
	 * @param db
	 * 
	 */
	public static void set(String key, Object obj, String nxxx, String expx, long time, int db) {
		if (obj == null) {
			log.info("key: " + key + " 对应的value为空");
			return;
		}
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			jedis.set(key.getBytes(), SerializeUtil.encodeObject(obj), nxxx.getBytes(), expx.getBytes(), time);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
	}

	/**
	 * 获取缓存
	 * 
	 * @param key
	 * @param db
	 */
	public static String get(String key, int db) {
		String value = null;
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			value = jedis.get(key);
		} catch (JedisException e) {
			log.error("redis key:" + key + " | db:" + db);
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return value;
	}

	/**
	 * 获取缓存
	 * 
	 * @param key
	 * @param db
	 */
	public static <T> T getObject(String key, int db) {

		byte[] value = null;
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			value = jedis.get(key.getBytes());
		}catch (Exception e) {
			log.error("getObject出错：key["+key+"],db["+db+"]",e);
		} finally {
			returnJedis(jedis);
		}

		if (value != null && value.length > 0) {
			return SerializeUtil.decodeObject(value);
		}
		return null;
	}

	/**
	 * 根据key删除缓存
	 * 
	 * @param key
	 * @param db
	 */
	public static void delByKey(String key, int db) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			jedis.del(key);
		} catch (JedisException e) {
			log.error(e.getMessage());
			if (jedis != null) {
				returnJedis(jedis);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}

	}

	/**
	 * 根据前缀删除缓存
	 * @param likeKey
	 * @param db
	 */
	public static void delByPrefix(String likeKey, int db) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			Set<String> keys = jedis.keys(likeKey + "*");
			if (keys.size() > 0) {
				String[] delKeys = new String[keys.size()];
				int i = 0;
				for (String delKey : keys) {
					delKeys[i] = delKey;
					i++;
				}
				jedis.del(delKeys);
			}
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}

	}

	/**
	 * 根据前缀获取所有keys
	 * 
	 * @param likeKey
	 * @param db
	 */
	public static Set<String> getByPrefix(String likeKey, int db) {
		Jedis jedis = null;
		Set<String> keys = new HashSet<String>();
		try {
			jedis = getJedis();
			jedis.select(db);
			keys = jedis.keys(likeKey + "*");
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return keys;

	}

	/**
	 * 根据前缀获取所有value
	 * 
	 * @param likeKey
	 * @param db
	 */
	public static Set<String> getValueSetByPrefix(String likeKey, int db) {
		Jedis jedis = null;
		Set<String> keys = new HashSet<String>();
		Set<String> values = new HashSet<String>();
		try {
			jedis = getJedis();
			jedis.select(db);
			keys = jedis.keys(likeKey + "*");

			Iterator<String> it = keys.iterator();
			while (it.hasNext()) {
				String key = it.next();
				String value = jedis.get(key);
				values.add(value);
			}
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return values;

	}

	/**
	 * 清空所有数据库
	 */
	public static String flushAll() {
		String state = null;
		Jedis jedis = null;

		try {
			jedis = getJedis();
			state = jedis.flushAll();
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		if ("OK".equals(state)) {
			log.warn("清空redis所有缓存成功!");
		} else {
			log.warn("清空redis所有缓存失败!");
		}
		return state;
	}

	/**
	 * 清空单个数据库
	 */
	public static String flushDB(int db) {

		String state = null;
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			state = jedis.flushDB();
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		if ("OK".equals(state)) {
			log.warn("清空redis所有缓存成功!");
		} else {
			log.warn("清空redis所有缓存失败!");
		}
		return state;

	}

	/**
	 *  获取Value Map 的值
	 * @param key
	 * @param mapKey
	 * @param db
	 * @return
	 */
	@SuppressWarnings("unused")
	public static Object getObject(String key, String mapKey, int db) {
		byte[] val = null;
		Jedis jedis = getJedis();
		try {
			if (db > 0) {
				jedis.select(db);
			}
			val = jedis.hget(key.getBytes(), mapKey.getBytes());
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		if (val != null && val.length > 0) {
			return SerializeUtil.decodeObject(val);
		}
		return null;
	}

	/**
	 * 更新或新增缓存信息
	 * @param key
	 * @param map
	 * @param db
	 * @return
	 */
	public static String setObject(String key, Map<byte[], byte[]> map, int db) {
		Jedis jedis = getJedis();
		try {
			if (db > 0){
				jedis.select(db);
			}
			// 如果存在则插入覆盖，如果不存在则初始化
			return jedis.hmset(key.getBytes(), map);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}



	/**
	 * 去除缓存过期时间（永不过期）
	 * 
	 * @param key
	 * @return
	 */
	public static Long setPersist(String key, int db) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.persist(key);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return 0L;
	}

	/**
	 * 添加set集合
	 * @param db
	 * @param key
	 * @param value
	 * @return
	 */
	public static Long sadd(int db, String key , String... value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.sadd(key,value);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return 0L;
	}

	/**
	 * 在SET中查询一个value
	 * 查询Set集合中是否包含value值
	 * @param db
	 * @param key
	 * @param value set集合中的value
	 * @return
	 */
	public static Boolean sismember(int db, String key , String value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.sismember(key,value);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return false;
	}

	/**
	 * 查询Set集合
	 * @param db
	 * @param key
	 * @return
	 */
	public static Set<String> smembers(int db, String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.smembers(key);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}

	/**
	 * 删除一个或多个Set集合的value
	 * @param db
	 * @param key
	 * @param smember
	 * @return
	 */
	public static Long srem(int db, String key, String... smember) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);

			return jedis.srem(key,smember);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}


	public static void main(String[] args) {

		// JedisUtil.set("kiso", "123456", -1, RedisConstants.SMS_MESSAGE);
		//JedisUtil.set("kiso", 111, -1, RedisConstants.SMS_MESSAGE);
		//System.out.println(JedisUtil.get("kiso", RedisConstants.SMS_MESSAGE));
		// JedisUtil.flushAll(8);
		//Long result = JedisUtil.sadd(1,"userId" ,"supplierId1","supplierId2","supplierId3","supplierId4");
		//System.out.println("addSetCollection------"+result);
		//Boolean flag1 = JedisUtil.sismember(1,"userId","supplierId1");
		//System.out.println("queryOneSetCollection：supplierId1------"+flag1);


//		JedisUtil.sadd(RedisConstants.USER,RedisConstants.KEY_ORDER_SUPPLIERIDSET_USERID+"11517398492217","15238400660001");
//		Boolean flag2 =JedisUtil.sismember(RedisConstants.USER,RedisConstants.KEY_ORDER_SUPPLIERIDSET_USERID+"11517398492217","11516437858171");
//		System.out.println("queryOneSetCollection：supplierId5------"+flag2);
//		Set<String> set = JedisUtil.smembers(RedisConstants.USER,RedisConstants.KEY_ORDER_SUPPLIERIDSET_USERID+"11517398492217");
//		System.out.println("querySetCollection-----"+set);

//		double maxScore = 9999999999d;
//		Long s = BigDecimal.valueOf(maxScore).subtract(BigDecimal.valueOf(System.currentTimeMillis() / 1000)).longValue();
//		Long expireSeconds = DateUtil.getExpireSecondsOfToday();
//		double score = new BigDecimal("1." + s).doubleValue();
//		String key = "honour:1112312:";
//		String member = "123";
//		System.out.println(score + "," + System.currentTimeMillis() / 1000 );
//		zincrByScoreWithExpire(key, score,member, expireSeconds.intValue(),1);
//		System.out.println(ttl(key, 1));
//
//		System.out.println(zscore(key, "1231231", 1));

		System.out.println(zincrByScoreWithExpire("te", 1.1111111, "m", 1200, 0));
	}


	public static String setBean(String key, Object object, Integer seconds) {

		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.setex(key.getBytes(), seconds, SerializeUtil.beanSerialize(object));
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}
	public static String setBean(String key, Object object) {

		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.set(key.getBytes(),SerializeUtil.beanSerialize(object));
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}
		      /**get Object*/
	 public static Object getBeanByString(String key){
		 Jedis jedis = null;
		 try {
			 jedis = getJedis();
			 byte[] value = jedis.get(key.getBytes());
			 return SerializeUtil.beanUnserialize(value);
		 } catch (JedisException e) {
			 log.error(e.getMessage());
		 } catch (Exception e) {
			 log.error(e.getMessage());
		 } finally {
			 returnJedis(jedis);
		 }
		 return null;
	}
	public static Object getBeanBybyte(byte[] bytes){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			byte[] value = jedis.get(bytes);
			return SerializeUtil.beanUnserialize(value);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}
		      /**delete a key**/
	public static boolean del(String key){

		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.del(key.getBytes())>0;
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return Boolean.TRUE;
	}
	public static boolean del(byte[] bytes){

		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.del(bytes)>0;
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return Boolean.TRUE;
	}

	/**
	 * 根据前缀获取所有keys
	 *
	 * @param likeKey
	 * @param db
	 */
	public static Set<byte[]> getBytesByPrefix(String likeKey, int db) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			Set<byte[]> keys = jedis.keys((likeKey + "*").getBytes());
			return keys;
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;

	}


	/**
	 * 设置过期时间
	 *
	 * @param key
	 * @param seconds
	 */
	public static void expire(String key, int seconds, int db) {
		if (seconds <= 0) {
			return;
		}
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			jedis.expire(key, seconds);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
	}
	
	public static Long ttl(String key, int db){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.ttl(key);
		} catch (JedisException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return -1L;
	}


	public static void zaddWithExpire(String key, double score, String member, int expireSeconds, int db){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			jedis.zadd(key, score, member);
			jedis.expire(key, expireSeconds);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
	}

	public static Long zadd(String key, double score, String member, int db){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			jedis.zadd(key, score, member);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return -1L;
	}

	public static double zscore(String key, String member, int db){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.zscore(key, member);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return 0.0;
	}

	public static Long zrevrank(String key, String member, int db){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.zrevrank(key, member);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}


	private static final String ZINCR_LUA_SCRIPT =
			"redis.call('select', ARGV[4]);\n" +
			"local score = redis.call('zscore', KEYS[1], ARGV[1]);\n" +
			"if type(score) == 'boolean' then\n" +
			"local result = redis.call('zadd', KEYS[1], ARGV[2], ARGV[1]);\n" +
			"redis.call('expire', KEYS[1], ARGV[3]);\n" +
			"return 1;\n" +
			"else\n" +
			"local v = score - score % 1 + ARGV[2];\n" +
			"return redis.call('zadd', KEYS[1], v, ARGV[1]);\n" +
			"end;";

	public static Long zincrByScoreWithExpire(String key, double score, String member, int expireSeconds, int db){
		Jedis jedis = null;
		try {
			jedis = getJedis();
//			jedis.select(db);
//			Double originScore = jedis.zscore(key, member);
//			if (originScore == null) {
//			 	Long result = jedis.zadd(key, score, member);
//			 	jedis.expire(key, expireSeconds);
//			 	return result;
//			}else {
//				//增量值取小数点前的值
//				return jedis.zadd(key, BigDecimal.valueOf(originScore).setScale(0, RoundingMode.FLOOR).add(BigDecimal.valueOf(score)).doubleValue()
//						, member);
//			}
			//加载脚本，获取sha索引
			String shakey = jedis.scriptLoad(ZINCR_LUA_SCRIPT);
			//要获取的key值
			List<String> keys = new ArrayList<>();
			keys.add(key);
			//传入的参数
			List<String> args = new ArrayList<>();
			args.add(member);
			args.add(String.valueOf(score));
			args.add(String.valueOf(expireSeconds));
			args.add(String.valueOf(db));
			Object r = jedis.evalsha(shakey, keys, args);
			return (Long)r;
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return -1L;
	}

	public static Set<String> zrange(String key, long start, long end, int db){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.zrange(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}

	public static Set<Tuple> zrangeWithScore(String key, long start, long end, int db){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.zrangeWithScores(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}

	public static Set<Tuple> zrevrangeWithScore(String key, long start, long end, int db){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.zrevrangeWithScores(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}

	public static Set<String> zrevrange(String key, long start, long end, int db){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.zrevrange(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return null;
	}

	public static Long zrem(String key, String member, int db){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.select(db);
			return jedis.zrem(key, member);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			returnJedis(jedis);
		}
		return -1L;
	}

}
