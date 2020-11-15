package com.board.cleancoder.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.board.cleancoder.dto.Board;

@Mapper
public interface BoardDao {
	public List<Board> getList();

	public void add(Board board);

	public int getTotalCount();

	public Board get(long bno);

	public void delete(long bno);

	public void modify(Board  board);

	public void hitUp(long bno);
	
}
