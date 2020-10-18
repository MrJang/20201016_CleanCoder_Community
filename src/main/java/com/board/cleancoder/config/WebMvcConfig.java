package com.board.cleancoder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Autowired
	@Qualifier("beforeActionInterceptor")
	HandlerInterceptor beforeActionInterceptor;
	
	@Autowired
	@Qualifier("needToLoginInterceptor")
	HandlerInterceptor needToLoginInterceptor;
	
	@Autowired
	@Qualifier("needToLogoutInterceptor")
	HandlerInterceptor needToLogoutInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**").excludePathPatterns("/resource/**");
	
		registry.addInterceptor(needToLoginInterceptor).addPathPatterns("/**").excludePathPatterns("/resource/**")
								.excludePathPatterns("/").excludePathPatterns("/member/login").excludePathPatterns("/member/doLogin")
								.excludePathPatterns("/member/join").excludePathPatterns("/member/doJoin")
								.excludePathPatterns("/board/list").excludePathPatterns("/board/detail");
		
		registry.addInterceptor(needToLogoutInterceptor).addPathPatterns("/member/login")
								.addPathPatterns("/member/doLogin").addPathPatterns("/member/join").addPathPatterns("/member/doJoin");
	
	}
}
