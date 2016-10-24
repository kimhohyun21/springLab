package com.sist.web;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;
/*
 * /dao/board/list.do
 * 
 */
@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("board/list.do")
	public String board_list(Model model, String page){
		if(page==null){page="1"; }
		int curPage=Integer.parseInt(page);
		int rowSize=10;
		int start=(curPage*rowSize)-(rowSize-1);
		int end=curPage*rowSize;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		
		List<BoardVO> list=dao.boardListData(map);
		int totalPage=dao.boardTotalPage();
		
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		
		return "list";
	}
}
