package com.djs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.djs.entity.UserEntity;
import com.djs.jpa.UserJPA;

@Service
@CacheConfig(cacheNames = "user")
public class UserService {
	
	/**
	 * @CacheConfig：该注解是用来开启声明的类参与缓存,如果方法内的@Cacheable注解没有添加key值，那么会自动使用cahceNames配置参数并且追加方法名。
	 * @Cacheable：配置方法的缓存参数，可自定义缓存的key以及value。
	 */
	
	@Autowired
	private UserJPA userJPA;
	
	@Cacheable
	public List<UserEntity> list(){
		return userJPA.findAll();
	}
}
