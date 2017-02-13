package com.javalec.spring_project_command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_project_dao.BoardDao;
import com.javalec.spring_project_dto.BoardDto;

public class BoardListCommand implements BoardCommand{

	@Override
	public void execute(Model model) {
	
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> dtos = dao.list();
		
		model.addAttribute("list",dtos);
	}

}
