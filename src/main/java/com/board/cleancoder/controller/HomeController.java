package com.board.cleancoder.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@RequestMapping("/home/main")
    public String showMain(Model mModel) {
		return "home/main";
	}
	@RequestMapping("/")
	public String showMain2() {
		
		return "redirect:/home/main";
	
	}
}
