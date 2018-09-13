package com.djs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class OAuth2Configuration {

	/**
	 * 完成资源服务器的配置
	 * @EnableResourceServer注解来开启资源服务器
	 * @author ASUS
	 *
	 */
	@Configuration
	@EnableResourceServer
	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
		@Autowired
        private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
		
		@Autowired
		private CustomLogoutSuccessHandler customLogoutSuccessHandler;

		@Override
		public void configure(HttpSecurity http) throws Exception {
			http
				.exceptionHandling()
				.authenticationEntryPoint(customAuthenticationEntryPoint)
				.and()
				.logout()
				.logoutSuccessHandler(customLogoutSuccessHandler)
				.and()
				.authorizeRequests()
				.antMatchers("/hello").permitAll()
				.antMatchers("/secure/**").authenticated();
		}
	}
	
	/**
	 * @EnableAuthorizationServer注解开启了验证服务器
	 * @author ASUS
	 *
	 */
	@Configuration
	@EnableResourceServer
	protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter implements EnvironmentAware{
		private static final String ENV_OAUTH = "authentication.oauth.";
        private static final String PROP_CLIENTID = "clientid";
        private static final String PROP_SECRET = "secret";
        private static final String PROP_TOKEN_VALIDITY_SECONDS = "tokenValidityInSeconds";
        
        //private RelaxedPropertyResolver propertyResolver;

		@Override
		public void setEnvironment(Environment arg0) {
			
		}
		
	}
}
