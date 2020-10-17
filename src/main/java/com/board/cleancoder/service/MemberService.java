package com.board.cleancoder.service;

import java.util.Map;

import com.board.cleancoder.dto.Member;

public interface MemberService {

	Map<String, Object> checkUserIdDup(String userId);
	
	public Map<String, Object> join(Map<String, Object> param);
	
	public Member getMatchedOne(String userId, String userPw);
	
	public Member get(long uno);
}
