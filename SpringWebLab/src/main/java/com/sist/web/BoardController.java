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
		int block=5;
		int fromPage=((curPage-1)/block*block)+1;
		int toPage=((curPage-1)/block*block)+block;
		
		if(toPage>totalPage)toPage=totalPage;
		
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("block", block);
		model.addAttribute("today", today);
		model.addAttribute("fromPage", fromPage);
		model.addAttribute("toPage", toPage);
		model.addAttribute("list", list);
		
		return "list";
	}
}
