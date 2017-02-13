package com.javalec.spring_project_command;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import com.javalec.spring_project_dao.BoardDao;
import com.javalec.spring_project_dto.BoardDto;

public class BoardContentCommand implements BoardCommand{

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap(); // Model객체를 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		
		BoardDao dao = new BoardDao();
		BoardDto dto = dao.contentView(bId);
		
		model.addAttribute("content_view",dto);
	}

}
