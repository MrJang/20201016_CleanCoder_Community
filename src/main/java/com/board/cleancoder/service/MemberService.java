package com.board.cleancoder.service;

import java.util.Map;

import com.board.cleancoder.dto.Member;

public interface MemberService {

	Map<String, Object> checkUserIdDup(String id);
	
	public Map<String, Object> join(Member member);
	
	public Member getMatchedOne(String id, String pw);
	
	public Member get(long uno);
}
