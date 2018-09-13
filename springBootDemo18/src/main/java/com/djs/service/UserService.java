package com.djs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.djs.entity.Authority;
import com.djs.entity.User;
import com.djs.jpa.UserJPA;

/**
1、@controller 控制器（注入服务）
 * 
 * 用于标注控制层，相当于struts中的action层
 * 2、@service 服务（注入dao）
 * 
 * 用于标注服务层，主要用来进行业务的逻辑处理
 * 3、@repository（实现dao访问）
 * 
 * 用于标注数据访问层，也可以说用于标注数据访问组件，即DAO组件.
 * 4、@component （把普通pojo实例化到spring容器中，相当于配置文件中的 
 * <bean id="" class=""/>）
 * 
 * 泛指各种组件，就是说当我们的类不属于各种归类的时候（不属于@Controller、@Services等的时候），我们就可以使用@Component来标注这个类。
 * @author ASUS
 *
 */
@Component("userDetailsService")
public class UserService implements UserDetailsService{

	@Autowired
	private UserJPA userJPA;
	
	/**
	 * 自定义UserDetailsService用来从数据库中根据用户名查询用户信息
	 * 以及角色信息并返回给SpringSecurity存放到内存中
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		String lowercaseLogin = login.toLowerCase();
		
		User userFromDatabase = userJPA.findByUsernameCaseInsensitive(lowercaseLogin);
		
		if(null == userFromDatabase) {
			throw new UsernameNotFoundException("User "+lowercaseLogin + " was not found in the database");
		}
		//获取用户的所有权限并且SpringSecurity需要的集合
		ArrayList<GrantedAuthority> grantedAuthoritys = new ArrayList<GrantedAuthority>();
		for (Authority authority : userFromDatabase.getAuthorities()) {
			SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
			grantedAuthoritys.add(grantedAuthority);
		}
		return new org.springframework.security.core.userdetails.User(
				userFromDatabase.getUsername(),
				userFromDatabase.getPassword(),
				grantedAuthoritys);
	}

}
