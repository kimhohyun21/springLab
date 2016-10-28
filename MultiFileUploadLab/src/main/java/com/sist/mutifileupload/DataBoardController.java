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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
		int toPage=totalPage-(block*curPage);
		if(toPage<totalPage)toPage=totalPage;
		
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
	
	@RequestMapping("databoard/insert_ok.do")
	public String databoard_insert_ok(DataBoardVO uploadForm)throws Exception{
		List<MultipartFile> list=uploadForm.getFiles();
		String temp="";
		String temp1="";
	/*	List<String> nameList=new ArrayList<String>();
		List<Integer> sizeList=new ArrayList<Integer>();*/
		if(list !=null && list.size()>0){
			for(MultipartFile mf : list){
				String fn=mf.getOriginalFilename();// a.jpg
				String ext=fn.substring(fn.lastIndexOf(".")+1);// jpg
				String save=fn.substring(0, fn.lastIndexOf("."))+System.currentTimeMillis()+"."+ext; // a20160723.jpg
				
				File file=new File("c:\\download\\"+save);
				mf.transferTo(file);
				
				temp+=save+","; // a20160723.jpg, b2016073.jpg,
				temp1+=file.length()+",";
								
				/*nameList.add(save);
				sizeList.add((int) file.length());*/
			}
			/*uploadForm.setNameList(nameList);
			uploadForm.setSizeList(sizeList);*/
			uploadForm.setFilename(temp.substring(0, temp.lastIndexOf(",")));
			uploadForm.setFilesize(temp1.substring(0, temp1.lastIndexOf(",")));
			uploadForm.setFilecount(list.size());
		}else{
			uploadForm.setFilename("");
			uploadForm.setFilesize("");
			uploadForm.setFilecount(0);
		}
		System.out.println(uploadForm.getSubject());
		dao.dataBoardInsert(uploadForm);
		return "redirect:/databoard/list.do";
	}
	
}
