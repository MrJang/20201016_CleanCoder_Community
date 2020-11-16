package com.board.cleancoder.dao;

import org.apache.ibatis.annotations.Mapper;

import com.board.cleancoder.dto.Member;

@Mapper
public interface MemberDao {

	public int getUserIdDupCount(String id);

	public void join(Member member);
	
	public Member getMatchedOne(String id, String pw);
	
	public Member get(long uno);
}
