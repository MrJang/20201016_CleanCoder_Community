package com.board.cleancoder.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.board.cleancoder.dto.Member;
import com.board.cleancoder.service.MemberService;

@Component("beforeActionInterceptor")
public class BeforeActionInterceptor implements HandlerInterceptor{
	
	@Autowired
	MemberService memberService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		boolean isLogined = false;
		long uno = 0;
		Member loginedMember = null;
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("uno") != null) {
			isLogined = true;
			
			uno = (long) session.getAttribute("uno");
			loginedMember = memberService.get(uno);
		}
		
		request.setAttribute("isLogined", isLogined);
		request.setAttribute("uno", uno);
		request.setAttribute("loginedMember", loginedMember);
		
		return HandlerInterceptor. super. preHandle(request, response, handler);
	}
}
