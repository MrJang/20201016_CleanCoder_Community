package com.board.cleancoder.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.cleancoder.dto.Member;
import com.board.cleancoder.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/member/join")
	public void join() {}
	
	@PostMapping("/member/doJoin")
	public String doJoin(Member member, Model mModel) {
		
		 Map<String, Object> checkUserIdDupRs= memberService.checkUserIdDup((String) member.getId());
		 
		 if(((String)checkUserIdDupRs.get("resultCode")).startsWith("F-")){
			 mModel.addAttribute("alertMsg", checkUserIdDupRs.get("msg"));
			 mModel.addAttribute("historyBack", true);
			 
			 return "common/redirect";
		 }
		 
		 Map<String, Object> joinRs = memberService.join(member);
		 
		 if(((String)joinRs.get("resultCode")).startsWith("F-")){
			 	mModel.addAttribute("alertMsg", joinRs.get("msg"));
			 	mModel.addAttribute("historyBack", true);
			 	
			 	return "common/redirect";
		 }
		 
		 mModel.addAttribute("alertMsg", joinRs.get("msg"));
		 mModel.addAttribute("redirectUrl", "/member/login");
		 return "common/redirect";
	}
	
	@GetMapping("/member/login")
	public void login() {}
	
	@PostMapping("/member/doLogin")
	public String doLogin(Member member, Model mModel, HttpSession session) {
		Member matchedMember = memberService.getMatchedOne(member.getId(), member.getPw());
		
		if(matchedMember == null) {
			mModel.addAttribute("alertMsg", "일치하는 회원이 없거나, 아이디/패스워드가 바르지 못합니다.");
			mModel.addAttribute("historyBack", true);
			
			return "common/redirect";
		}
		session.setAttribute("uno", matchedMember.getUno());
		session.setAttribute("name", matchedMember.getName());
		
		mModel.addAttribute("alertMsg", "로그인 되었습니다.");
		mModel.addAttribute("redirectUrl", "/");
		
		return "common/redirect";
	}
	
	@RequestMapping("/member/doLogout")
	public String doLogout(HttpSession session) {
		session.removeAttribute("uno");
		
		return "redirect:/";
	}
}
