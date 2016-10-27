package com.sist.mutifileupload;
/*
 * jsp ==> 행위 (.do) ==> DispatcherServlet ==> 필요한 데이터  
 * 
 * ==> @Controller 		==> 메소드안에서 DAO 연동하고  결과 값을  	
 * 	   @RequestMapping
 *       
 * ==> Model에  실어서 전송 
 * 	   ---------------
 * 		forward => return "jsp명"
 *      sendRedirect ==> return "redirect" 
 */

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;

@Controller
public class DataBoardController {
	@Autowired
	private DataBoardDAO dao;
	
	@RequestMapping("databoard/list.do")
	public String databoard_list(String page, Model model){
		if(page==null){
			page="1";
		}
		
		int curPage=Integer.parseInt(page);
		
		Map map=new HashMap();
		int rowSize=10;
		int start=(rowSize*curPage)-(rowSize-1);
		int end=rowSize*curPage;
		map.put("start", start);
		map.put("end", end);
		
		List<DataBoardVO> list=dao.dataBoardListData(map);
		int totalPage=dao.dataBoardTotalPage();
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		int block=5;
		int fromPage=(block*curPage)-(block-1);
		int toPage=totalPage-((block*curPage)-totalPage);
		
		model.addAttribute("list", list);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("curPage", curPage);
		model.addAttribute("today", today);
		model.addAttribute("block", block);
		model.addAttribute("fromPage", fromPage);
		model.addAttribute("toPage", toPage);
		return "databoard/list";
	}
	
	@RequestMapping("databoard/insert.do")
	public String databoard_insert(){
		return "databoard/insert";
	}
}
