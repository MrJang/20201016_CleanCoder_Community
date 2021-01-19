package com.board.cleancoder.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.cleancoder.dao.BoardDao;
import com.board.cleancoder.dto.Board;
import com.board.cleancoder.dto.Criteria;
import com.board.cleancoder.util.CUtil;


@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDao boardDao;

	@Override
	public long add(Board board) {
		boardDao.add(board);
			
		return CUtil.getAsLong(board.getBno());
	}

	@Override
	public int getTotalCount(Criteria cri) {

		return boardDao.getTotalCount(cri);
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
	public void modify(Board board) {
		boardDao.modify(board);
	}

	@Override
	public void hitUp(long bno) {
		boardDao.hitUp(bno);
	}

	@Override
	public List<Board> getList(Criteria cri) {
		return boardDao.getListWithSearch(cri);
	}
}
