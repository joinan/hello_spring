package com.javalec.spring_project_controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_project_command.BoardCommand;
import com.javalec.spring_project_command.BoardContentCommand;
import com.javalec.spring_project_command.BoardDeleteCommand;
import com.javalec.spring_project_command.BoardListCommand;
import com.javalec.spring_project_command.BoardModifyCommand;
import com.javalec.spring_project_command.BoardReplyCommand;
import com.javalec.spring_project_command.BoardReplyViewCommand;
import com.javalec.spring_project_command.BoardWriteCommand;

@Controller
public class BoardController {
	
	BoardCommand command;
	
	@RequestMapping("/list")
	public String list(Model model){
		System.out.println("list()");
		command = new BoardListCommand();
		command.execute(model);
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String writeView(Model model){
		System.out.println("writeView()");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model){
		System.out.println("write()");
		model.addAttribute("request",request);
		command = new BoardWriteCommand();
		command.execute(model);
		
		return "redirect:list"; // 리다이렉트
	}
	
	@RequestMapping("/content_view")
	public String contentView(HttpServletRequest request, Model model){
		System.out.println("contentView()");
		model.addAttribute("request",request);
		command = new BoardContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/modify")
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modify()");
		model.addAttribute("request", request);
		command = new BoardModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String replyView(HttpServletRequest request, Model model){
		System.out.println("replyView()");
		model.addAttribute("request",request);
		command = new BoardReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model){
		System.out.println("reply()");
		model.addAttribute("request",request);
		command = new BoardReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		System.out.println("delete()");
		model.addAttribute("request",request);
		command = new BoardDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}
