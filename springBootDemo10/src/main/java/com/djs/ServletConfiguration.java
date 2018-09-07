package com.djs;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ServletComponentScan
public class ServletConfiguration {
	
	/*@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new TestServlet(),"/test");
	}*/
}
