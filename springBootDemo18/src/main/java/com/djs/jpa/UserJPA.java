package com.djs.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.djs.entity.User;

public interface UserJPA extends JpaRepository<User, String>{

	/**
	 * 根据用户名不区分大小写进行查询
	 * @param username
	 * @return
	 */
	@Query("select u from user u where lower(u.username) = lower(:username)")
	User findByUsernameCaseInsensitive(@Param("username") String username);
}
