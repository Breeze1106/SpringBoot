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
	@Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
	User findByUsernameCaseInsensitive(@Param("username") String username);
}
