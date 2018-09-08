package com.djs.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.djs.entity.GoodEntity;

public interface GoodJPA extends JpaRepository<GoodEntity, Long>,QueryDslPredicateExecutor<GoodEntity>{

}
