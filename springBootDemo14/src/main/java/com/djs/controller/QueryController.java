package com.djs.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.djs.entity.GoodEntity;
import com.djs.entity.QGoodEntity;
import com.djs.jpa.GoodJPA;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;

@RestController
public class QueryController {

	@Autowired
	private GoodJPA goodJPA;
	
	//注入EntityManager
	@PersistenceContext
	private EntityManager entityManager;
	
	@RequestMapping(value = "/query",method = RequestMethod.GET)
	public List<GoodEntity> list() {
		//querydsl查询实体
        QGoodEntity _good = QGoodEntity.goodEntity;
        //构建JPA查询对象
        JPAQuery<GoodEntity> jpaQuery = new JPAQuery<>(entityManager);
        //返回查询接口
        return jpaQuery
                //查询字段
                .select(_good)
                //查询表
                .from(_good)
                //查询条件
                .where(_good.type.id.eq(Long.valueOf("1")))
                //返回结果
                .fetch();
	}
	
	/**
	 * spring data jpa 整合querydsl完美查询
	 * @return
	 */
	public List<GoodEntity> join(){
		//querydsl查询实体
		QGoodEntity _good = QGoodEntity.goodEntity;
		//查询条件 
		BooleanExpression expression = _good.type.id.eq(Long.valueOf("1"));
		//执行查询
		Iterator<GoodEntity> iterator = goodJPA.findAll(expression).iterator();
		List<GoodEntity > goods = new ArrayList<>();
		//转成list
		while(iterator.hasNext()) {
			goods.add(iterator.next());
		}
		return goods;
	}
}
