package com.djs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.djs.entity.UserEntity;
import com.djs.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping("/list")
	public List<UserEntity> list(){
		return service.list();
	}
}
