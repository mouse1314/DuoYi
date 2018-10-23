package com.duoyi.web.Interceptor;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.duoyi.model.po.UserGenerator;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取请求的后缀名
		String basePath = request.getContextPath();
		String path = request.getRequestURI();
		path = path.substring(basePath.length());
		
		//配置不需要拦截的路径
		Set<String> set = new HashSet();
		set.add("/login");
		set.add("/logout");
		set.add("/login.html");
		set.add("/register");
		set.add("/register.html");
		
		if(set.contains(path)){
			return true;
		}
		
		UserGenerator user = (UserGenerator) request.getSession().getAttribute("user");
		if(user==null || user.getId() == 0){
			//未登录是跳转到登陆界面
			//response.sendRedirect("/login.html");
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
