package com.sist.web2;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao2.BoardDAO;
import com.sist.dao2.BoardVO;

// /SpringWebLab/board/list.do

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("board/list.do")
	public String board_list(Model model, String page) {
		if (page == null) {
			page = "1"; // list.jsp
		}
		int curpage = Integer.parseInt(page);
		int rowSize = 10;
		int start = (curpage * rowSize) - (rowSize - 1);
		int end = curpage * rowSize;

		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<BoardVO> list = dao.boardListData(map);

		int totalpage = dao.boardTotalPage();
		
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("list", list);

		return "list";
	}
	
	@RequestMapping("board/insert.do")
	public String board_insert() {
		return "insert";
	}
	
	@RequestMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo) {
		dao.boardInsert(vo);
		return "redirect:/board/list.do";
	}
}
