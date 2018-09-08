package com.djs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	//logback
	private final static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	/**
	 * 访问首页
	 */
	@RequestMapping(value = "/test")
	public String index() {
		logger.debug("记录debug日志");
		logger.info("访问了index方法");
		logger.error("记录error错误日志");
		return "index";
	}
}
