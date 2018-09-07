package com.djs.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djs.entity.LoggerEntity;

public interface LoggerJPA extends JpaRepository<LoggerEntity, Long>{

}
