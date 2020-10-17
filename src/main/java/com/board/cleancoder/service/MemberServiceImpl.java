package com.board.cleancoder.service;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.cleancoder.dao.MemberDao;
import com.board.cleancoder.dto.Member;
import com.board.cleancoder.util.CUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public Map<String, Object> checkUserIdDup(String userId) {
		int count = memberDao.getUserIdDupCount(userId);
		
		String resultCode = "";
		String msg = "";
		
		if(count == 0) {
			resultCode = "S-1";
			msg = "사용 가능한 ID 입니다.";
		}else {
			resultCode = "F-1";
			msg = "이미 사용중인 ID 입니다.";
		}
	
		Map<String, Object> rs = new HashMap<String, Object>();
		rs.put("resultCode", resultCode);
		rs.put("msg", msg);
		
		return rs;
	}

	@Override
	public Map<String, Object> join(Map<String, Object> param) {
		
		memberDao.join(param);
		
		long newId = CUtil.getAsLong(param.get("id"));
		
		String resultCode = "";
		String msg = "";
		
		if(newId == 0) {
			resultCode = "F-1";
			msg = "회원가입에  실패했습니다.";
		}else {
			resultCode = "S-1";
			msg = "회원가입에 성공헀니다.";
		}
		
		Map<String, Object> rs = new HashMap<String, Object>();
		rs.put("resultCode", resultCode);
		rs.put("msg", msg);
		rs.put("newId", newId);
		
		return rs;
	}

	@Override
	public Member getMatchedOne(String userId, String userPw) {
		
		return memberDao.getMatchedOne(userId, userPw);
	}

	@Override
	public Member get(long uno) {
		return memberDao.get(uno);
	}

}
