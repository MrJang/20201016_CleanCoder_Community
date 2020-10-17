package com.board.cleancoder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.cleancoder.dto.Member;
import com.board.cleancoder.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/home/main")
    public String showMain(HttpSession session, Model mModel) {
		long uno = 0;
		
		if(session.getAttribute("uno") != null) {
			uno = (long) session.getAttribute("uno");
		}
		
		Member loginedMember = memberService.get(uno);
		
		mModel.addAttribute("loginedMember", loginedMember);
		
		return "home/main";
	}
	@RequestMapping("/")
	public String showMain2() {
		
		return "redirect:/home/main";
	
	}
}
