package com.board.cleancoder.service;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.cleancoder.dao.BoardDao;
import com.board.cleancoder.dto.Board;
import com.board.cleancoder.util.CUtil;

import jline.internal.Log;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<Board> getList(){
		return boardDao.getList();
	}

	@Override
	public long add(Map<String, Object> param) {
		boardDao.add(param);
		
		
		return CUtil.getAsLong(param.get("bno"));
	}

	@Override
	public int getTotalCount() {

		return boardDao.getTotalCount();
	}

	@Override
	public Board get(long bno) {

		return boardDao.get(bno);
	}

	@Override
	public void delete(long bno) {
		boardDao.delete(bno);
	}

	@Override
	public void modify(Map<String, Object> param) {
		boardDao.modify(param);
	}

	@Override
	public void hitUp(long bno) {
		boardDao.hitUp(bno);
	}
}
