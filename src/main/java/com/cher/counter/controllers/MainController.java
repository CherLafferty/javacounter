package com.cher.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/home")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
		session.setAttribute("count", 0);
		} else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount ++;
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/home/counter")
	public String showCount(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			Integer currentCount = (Integer) session.getAttribute("count");
			model.addAttribute("countToshow", currentCount);
		}
		
		return "counter.jsp";
	}

}
