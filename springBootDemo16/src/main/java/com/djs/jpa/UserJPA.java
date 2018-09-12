package com.djs.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djs.entity.UserEntity;

public interface UserJPA extends JpaRepository<UserEntity, Long>{
	
}
