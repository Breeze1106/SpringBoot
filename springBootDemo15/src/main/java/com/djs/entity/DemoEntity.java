package com.djs.entity;

import java.io.Serializable;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.djs.validator.FlagValidator;

public class DemoEntity implements Serializable{
	
	@Length(min=2, max=10)
	@NotBlank
	private String name;
	
	@Min(value=1)
	private int age;
	
	@Email
	@NotBlank
	private String mail;
	
	@FlagValidator(values="1,2,3")
	private String flag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
