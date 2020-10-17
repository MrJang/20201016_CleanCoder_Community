package com.board.cleancoder.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.board.cleancoder.dto.Member;

@Mapper
public interface MemberDao {

	public int getUserIdDupCount(String userId);

	public void join(Map<String, Object> param);
	
	public Member getMatchedOne(String userId, String userPw);
	
	public Member get(long uno);
}
