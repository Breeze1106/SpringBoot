package com.djs.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.djs.entity.UserEntity;

public interface UserJPA extends JpaRepository<UserEntity, Long>,JpaSpecificationExecutor<UserEntity>,Serializable{
	
}
