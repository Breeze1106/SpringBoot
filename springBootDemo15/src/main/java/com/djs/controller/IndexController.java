package com.djs.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.djs.entity.DemoEntity;

@RestController
public class IndexController {
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = "/validator")
	public String validator(@Valid DemoEntity entity,BindingResult result) {
		
		if(result.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			//获取错误字段集合
			List<FieldError> fieldErrors = result.getFieldErrors();
			//获取本地local,zh_CN
			Locale currentLocale = LocaleContextHolder.getLocale();
			//遍历错误字段获取错误信息
			for (FieldError fieldError : fieldErrors) {
				//获取错误信息
				String message = messageSource.getMessage(fieldError,currentLocale);
				//添加到错误消息集合内
				msg.append(fieldError.getField()+"："+message+"，");
				
			}
			return msg.toString();
		}
		return "验证通过，" + "名称：" + entity.getName()+ "年龄：" + entity.getAge() + "邮箱地址："+entity.getMail();
	}
}
