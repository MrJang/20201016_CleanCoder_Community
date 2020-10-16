package com.board.cleancoder.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.cleancoder.dto.Board;
import com.board.cleancoder.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/board/detail")
	public String showList(Model bModel, long bno) {
		Board board = boardService.get(bno);
		
		boardService.hitUp(bno);
		
		bModel.addAttribute("board", board);
		return "board/detail";
	}
	
	@RequestMapping("/board/modify")
	public String showModify(Model bModel, long bno) {
		Board board = boardService.get(bno);
		
		bModel.addAttribute("board", board);
		return "board/modify";
	}
	
	@RequestMapping("/board/list")
	public String showList(Model bModel) {
		List<Board> list = boardService.getList();
		int totalCount = boardService.getTotalCount();
		
		bModel.addAttribute("list", list);
		bModel.addAttribute("totalCount", totalCount);
		return "board/list";
	}
	
	@RequestMapping("/board/add")
	public String showAdd() {
		return "board/add";
	}
	
	@RequestMapping("/board/doAdd")
	@ResponseBody
	public String doAdd(@RequestParam Map<String, Object> param) {
		 long newBno= boardService.add(param);
		 
		 String msg =  newBno+"번 게시물이 추가되었습니다.";
		 StringBuilder sb = new StringBuilder();
		 
		 sb.append("alert('" + msg + "');");
		 sb.append("location.replace('./detail?bno=" + newBno +"');");
		
		 sb.insert(0, "<script>");
		 sb.append("</script>");
		 return sb.toString();
	}
	@RequestMapping("/board/doModify")
	@ResponseBody
	public String doModify(@RequestParam Map<String, Object> param, long bno) {
		boardService.modify(param);
		 
		 String msg =  bno +"번 게시물이 수정되었습니다.";
		 StringBuilder sb = new StringBuilder();
		 
		 sb.append("alert('" + msg + "');");
		 sb.append("location.replace('./detail?bno=" + bno +"');");
		
		 sb.insert(0, "<script>");
		 sb.append("</script>");
		 return sb.toString();
	}
	
	@RequestMapping("/board/doDelete")
	@ResponseBody
	public String doDelete(long bno) {
		 boardService.delete(bno);
		 
		 String msg =  bno+"번 게시물이 삭제되었습니다.";
		 StringBuilder sb = new StringBuilder();
		 
		 sb.append("alert('" + msg + "');");
		 sb.append("location.replace('./list');");
		
		 sb.insert(0, "<script>");
		 sb.append("</script>");
		 return sb.toString();
	}
}
