package com.djs.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.djs.entity.UserEntity;

public interface UserJPA extends JpaRepository<UserEntity, Long>{
	
	@Query(value="select * from t_user where t_age > ?",nativeQuery = true)
	public List<UserEntity> nativeQuery(int age);
	
	@Transactional
	@Modifying
	@Query(value = "delete from t_user where t_name=? and t_pwd = ?",nativeQuery = true)
	public void deleQuery(String name,String pwd);
}
