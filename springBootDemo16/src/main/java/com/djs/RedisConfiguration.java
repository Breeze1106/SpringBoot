package com.djs;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @EnableCaching注解来开启我们的项目支持缓存
 * 配置类内添加了方法cacheManager()，方法的返回值则是使用了我们的Redis缓存的管理器，
 * SpringBoot项目启动时就会去找自定义配置的CacheManager对象并且自动应用到项目中
 * @author ASUS
 *
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport{
	
	/**
	 * 自定义生成key的规则
	 */
	@Override
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			
			@Override
			public Object generate(Object target, Method method, Object... params) {
				//格式化缓存key字符串
				StringBuffer sb = new StringBuffer();
				//追加类名
				sb.append(target.getClass().getName());
				//追加方法名
				sb.append(method.getName());
				//遍历参数并且追加
				for (Object object : params) {
					sb.append(object.toString());
				}
				System.out.println("调用Redis缓存key："+sb);
				return sb;
			}
		};
	}
	
	/**
	 * 
	 * 采用RedisCacheManager作为缓存管理器
	 * @param redisTemplate
	 * @return
	 */
	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {
		return new RedisCacheManager(redisTemplate);
	}
}
