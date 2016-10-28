package com.sist.multiboard;
import java.io.File;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sist.dao.*;
/*
 * jsp => 행위(.do) => DispatcherServlet
 * => 필요한 데이터 => @Controller
 * 					   @RequestMapping
 * => 메소드 안에서 DAO 연동하고 
 * 	  결과값을 => Model에 실어서(addAttribute) 전송
 * 				 ===================================
 * 					forward = return "jsp%"
 * 					sendRedirect = return "redirect"
 */

@Controller
public class DataBoardController {
	@Autowired
	private DataBoardDAO dao;
	
	@RequestMapping("databoard/list.do")
	public String databoard_list(String page,Model model){
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		int rowSize=10;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		
		map.put("start", start);
		map.put("end", end);
		
		List<DataBoardVO> list=dao.databoardListData(map);
		int totalPage=dao.databoardTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalPage);
		
		return "databoard/list";
	}
	
	@RequestMapping("databoard/insert.do")
	public String databoard_insert(){
		return "databoard/insert";
	}
	
	@RequestMapping("databoard/insert_ok.do")
	public String databoard_insert_ok(DataBoardVO uploadForm) throws Exception{
		List<MultipartFile> list=uploadForm.getFiles();
		String temp="";
		String temp1="";
		
		if(list !=null && list.size()>0){
			for(MultipartFile mf:list){
				String fn=mf.getOriginalFilename();
				String ext=fn.substring(fn.lastIndexOf('.')+1);	//a.jpg에서 jpg 확장자만 저장.
				String save=fn.substring(0, fn.lastIndexOf('.'))+System.currentTimeMillis()+"."+ext;
				
				File file=new File("c:\\download\\"+save);
				mf.transferTo(file);
				
				temp+=save+",";	//a12342323.jpg, b55634531.jpg
				temp1+=file.length()+",";	//25(파일크기)
			}
			uploadForm.setFilename(temp.substring(0, temp.lastIndexOf(',')));
			uploadForm.setFilesize(temp1.substring(0, temp1.lastIndexOf(',')));
			uploadForm.setFilecount(list.size());
		}else{
			uploadForm.setFilename("");
			uploadForm.setFilesize("");
			uploadForm.setFilecount(0);
		}
		dao.databoardInsert(uploadForm);
		return "redirect:/databoard/list.do";
	}
}



































