package com.djs;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class FastJsonConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//调用父类
		super.configureMessageConverters(converters);
		//创建fastJson消息转换器
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		//创建配置类
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		//修改配置返回内容的过滤
		/* setSerializerFeatures方法可以配置多个过滤方式：
		 * WriteNullListAsEmpty  ：List字段如果为null,输出为[],而非null
		 * WriteNullStringAsEmpty ： 字符类型字段如果为null,输出为"",而非null
		 * DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
		 * WriteNullBooleanAsFalse：Boolean字段如果为null,输出为false,而非null
		 * WriteMapNullValue：是否输出值为null的字段,默认为false。
		 * */
		fastJsonConfig.setSerializerFeatures(
			SerializerFeature.DisableCircularReferenceDetect,
			SerializerFeature.WriteMapNullValue,
			SerializerFeature.WriteNullStringAsEmpty
		);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		//将fastJson添加到视图消息转换器列表内
		converters.add(fastConverter);
	}
}
