package com.board.cleancoder.service;

import java.util.List;

import com.board.cleancoder.dto.Board;

public interface BoardService {
	public List<Board> getList();

	public long add(Board board);

	public int getTotalCount();

	public Board get(long bno);

	public void delete(long bno);

	public void modify(Board board);

	public void hitUp(long bno);

}
