package com.djs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.djs.entity.UserEntity;
import com.djs.jpa.UserJPA;

@RestController
public class UserController {
	
	@Autowired
	private UserJPA userJPA;
	
	@RequestMapping(value = "/list")
	public List<UserEntity> list(){
		return userJPA.findAll();
	}
	
	@RequestMapping(value = "/add")
	public String add() {
		UserEntity entity = new UserEntity();
		entity.setName("test1016");
		entity.setAddress("test");
		entity.setAge(21);
		userJPA.save(entity);
		return "用户信息添加成功";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(Long userId) {
		userJPA.delete(userId);
		return "用户信息删除成功";
	}
	
	@RequestMapping(value = "/age")
	public List<UserEntity> age(Integer age){
		return userJPA.nativeQuery(age);
	}
	
	@RequestMapping(value = "/deleteWhere")
	public String deleteWhere(String name ,String pwd) {
		userJPA.deleQuery(name, pwd);
		return "自定义SQL删除数据成功";
	}
	
	/**
	 * 分页查询测试
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/cutpage")
	public List<UserEntity> cutPage(@RequestParam(required=true,defaultValue="1")int page){
		UserEntity user = new UserEntity();
		user.setSize(2);
		user.setSord("desc");
		user.setPage(page);
		
		//获取排序对象
		Sort.Direction sort_direction = Sort.Direction.ASC.toString().equalsIgnoreCase(user.getSord()) ? Sort.Direction.ASC: Sort.Direction.DESC;
		//设置排序对象参数
		Sort sort = new Sort(sort_direction,user.getSidx());
		//创建分页对象
		PageRequest pageObj = new PageRequest(user.getPage() -1, user.getSize(),sort);
		return userJPA.findAll(pageObj).getContent();
	}
	
}
