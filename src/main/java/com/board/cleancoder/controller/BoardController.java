package com.board.cleancoder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.cleancoder.dto.Board;
import com.board.cleancoder.dto.Criteria;
import com.board.cleancoder.service.BoardService;
import com.board.cleancoder.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/board/detail/{bno}")
	public String detail(Model bModel, @PathVariable("bno") long bno) {
		Board board = boardService.get(bno);
		
		boardService.hitUp(bno);
		
		bModel.addAttribute("board", board);
		
		return "/board/detail";
	}
	
	@RequestMapping("/board/modify/{bno}")
	public String modify(Model bModel, @PathVariable("bno") long bno) {
		Board board = boardService.get(bno);
		
		bModel.addAttribute("board", board);
		
		return "board/modify";
	}
	
	@GetMapping("/board/list")
	public void list(Criteria cri, Model bModel) {
		
		List<Board> list = boardService.getList(cri);

		int totalCount = boardService.getTotalCount(cri);
		
		bModel.addAttribute("Criteria", cri);
		bModel.addAttribute("list", list);
		bModel.addAttribute("totalCount", totalCount);
	}
	
	@GetMapping("/board/add")
	public void add() {}
	
	@PostMapping("/board/doAdd")
	public String doAdd(Board board) {
		 long newBno= boardService.add(board);
		 
		 return "redirect:/board/detail/"+ newBno;
	}
	@PostMapping("/board/doModify")
	public String doModify(Board board) {
		boardService.modify(board);
		long bno = board.getBno();
		 
		return "redirect:/board/detail/"+ bno;
	}
	
	@GetMapping("/board/doDelete/{bno}")
	public String doDelete(@PathVariable("bno") long bno) {
		System.out.println(bno);
		
		 boardService.delete(bno);
		 
		 return "redirect:/board/list";
	}
}
