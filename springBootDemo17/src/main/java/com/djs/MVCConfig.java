package com.djs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/main").setViewName("main");
		/**
		 * registry.addViewController("/login").setViewName("login");
		 * 作用：减少类似代码的书写
		 * 类似于：
		 * @RequestMapping("/toview")
			 public String view(){
			    return "view";
			 }
		 */
	}

	
}
