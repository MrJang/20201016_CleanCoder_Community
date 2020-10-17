package com.board.cleancoder.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.cleancoder.dto.Member;
import com.board.cleancoder.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/member/join")
	public String showJoin() {
		return "member/join";
	}
	
	@RequestMapping("/member/doJoin")
	public String doJoin(@RequestParam Map<String, Object> param, Model mModel) {
		
		 Map<String, Object> checkUserIdDupRs= memberService.checkUserIdDup((String) param.get("userId"));
		 
		 if(((String)checkUserIdDupRs.get("resultCode")).startsWith("F-")){
			 mModel.addAttribute("alertMsg", checkUserIdDupRs.get("msg"));
			 mModel.addAttribute("historyBack", true);
			 
			 return "common/redirect";
		 }
		 
		 Map<String, Object> joinRs = memberService.join(param);
		 
		 if(((String)joinRs.get("resultCode")).startsWith("F-")){
			 	mModel.addAttribute("alertMsg", joinRs.get("msg"));
			 	mModel.addAttribute("historyBack", true);
			 	
			 	return "common/redirect";
		 }
		 
		 mModel.addAttribute("alertMsg", joinRs.get("msg"));
		 mModel.addAttribute("redirectUrl", "/member/login");
		 return "common/redirect";
	}
	
	@RequestMapping("/member/login")
	public String showLogin() {
		return "member/login";
	}
	
	@RequestMapping("/member/doLogin")
	public String doLogin(@RequestParam Map<String, Object> param, Model mModel, HttpSession session) {
		Member matchedMember = memberService.getMatchedOne((String) param.get("userId"), (String) param.get("userPw"));
		
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
}
