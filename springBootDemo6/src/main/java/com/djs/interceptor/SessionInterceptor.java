package com.djs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println(request.getRequestURI());
		//登录不做拦截
		if(request.getRequestURI().equals("/user/login") || request.getRequestURI().equals("/user/login_view")) {
			return true;
		}
		
		//验证session是否存在
		Object obj = request.getSession().getAttribute("session_user");
		System.out.println(obj);
		if(null == obj) {
			response.sendRedirect("/user/login_view");
			return false;
		}
		
		return true;
	}

}
