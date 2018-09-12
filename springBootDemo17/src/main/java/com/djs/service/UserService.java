package com.djs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.djs.entity.UserEntity;
import com.djs.jpa.UserJPA;

public class UserService implements UserDetailsService{

	@Autowired
	private UserJPA userJPA;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userJPA.findByUsername(username);
		System.out.println(username+user);
		if(user == null) {
			throw new UsernameNotFoundException("未查询到用户："+username+" 信息！");
		}
		return user;
	}

}
