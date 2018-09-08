package com.djs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "good_types")
public class GoodTypeEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "tgt_id")
	private Long id;
	
	@Column(name = "tgt_name")
	private String name;
	
	@Column(name = "tgt_is_show")
	private String isShow;
	
	@Column(name = "tgt_order")
	private int order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}