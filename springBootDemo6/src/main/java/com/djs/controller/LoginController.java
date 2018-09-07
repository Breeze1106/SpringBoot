package com.djs.controller;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.djs.entity.UserEntity;
import com.djs.jpa.UserJPA;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private UserJPA userJPA;
	
	@RequestMapping("/login")
	public String login(UserEntity user, HttpServletRequest request) {
		String result = "登陆成功";
		UserEntity findOne = userJPA.findOne(new Specification<UserEntity>() {
			
			@Override
			public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				criteriaQuery.where(criteriaBuilder.equal(root.get("name"), user.getName()));
				return null;
			}
		});
		
		if(null == findOne) {
			//用户不存在
			result = "用户不存在，登录失败";
		}else if(!findOne.getPwd().equals(user.getPwd())){
			result = "用户密码不相符，登录失败";
		}
		
		//登陆成功
		if(result.equals("登陆成功")){
			//将用户写入session
			request.getSession().setAttribute("session_user", findOne);
		}
		return result;
	}
}
