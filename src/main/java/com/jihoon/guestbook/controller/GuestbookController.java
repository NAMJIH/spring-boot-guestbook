package com.jihoon.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jihoon.guestbook.dao.GuestbookDao;
import com.jihoon.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	@Autowired
	private GuestbookDao gd;
	
	@RequestMapping("/main")
	public String list(Model model) {
		List<GuestbookVo> list = gd.getList();
		model.addAttribute("list",list);		
		return "list";
	}
	@RequestMapping("/deleteform")
	public String deleteform(@RequestParam("no") long no, Model model) {
		model.addAttribute("no", no);
		return "deleteform";
	}
	@RequestMapping("/delete")
	public String delete(@ModelAttribute GuestbookVo gv) {
		
		gd.delete(gv);
		return "redirect:/main";
	}
	@RequestMapping("/add")
	public String add(@ModelAttribute GuestbookVo gv) {

		gd.insert(gv);
		return "redirect:/main";
	}
}
