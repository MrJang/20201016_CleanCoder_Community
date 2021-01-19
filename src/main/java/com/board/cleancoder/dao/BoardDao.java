package com.board.cleancoder.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.board.cleancoder.dto.Board;
import com.board.cleancoder.dto.Criteria;

@Mapper
public interface BoardDao {
	
	public List<Board> getListWithSearch(Criteria cri);

	public void add(Board board);
	
	public int getTotalCount(Criteria cri);

	public Board get(long bno);

	public void delete(long bno);

	public void modify(Board  board);

	public void hitUp(long bno);
	
}
