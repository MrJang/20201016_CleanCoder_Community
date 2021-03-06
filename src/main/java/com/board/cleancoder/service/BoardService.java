package com.board.cleancoder.service;

import java.util.List;

import com.board.cleancoder.dto.Board;
import com.board.cleancoder.dto.Criteria;

public interface BoardService {
	
	public List<Board> getList(Criteria cri);

	public long add(Board board);

	public int getTotalCount(Criteria cri);

	public Board get(long bno);

	public void delete(long bno);

	public void modify(Board board);

	public void hitUp(long bno);

}
