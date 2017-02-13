package com.javalec.spring_mvc_project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("/view")
	public String view() {
		
		return "view";
	}
	
	@RequestMapping("/content/contentView")
	public String contentView(Model model){
		
		model.addAttribute("id","abcd");
		
		return "content/contentView";
	}
	
	@RequestMapping("/model/modelEx")
	public String modelEx(Model model){
		model.addAttribute("data", "abcdefgahseifjasie");
		
		return "model/modelEx";
	}
	
	@RequestMapping("/model/ModelAndView")
	public ModelAndView modelAndView(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", "asjiejfiejfie");
		mv.setViewName("/model/ModelAndView");
		return mv;
		
	}
}
