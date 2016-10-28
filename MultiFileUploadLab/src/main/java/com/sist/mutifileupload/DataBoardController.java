package com.sist.mutifileupload;
/*
 * jsp ==> ���� (.do) ==> DispatcherServlet ==> �ʿ��� ������  
 * 
 * ==> @Controller 		==> �޼ҵ�ȿ��� DAO �����ϰ�  ��� ����  	
 * 	   @RequestMapping
 *       
 * ==> Model��  �Ǿ ���� 
 * 	   ---------------
 * 		forward => return "jsp��"
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
	
	@RequestMapping("list.do")
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
		int fromPage=(block*((curPage/5)+1))-(block-1);
		int toPage=totalPage-(block*((curPage/5)+1));
		if(toPage<totalPage)toPage=totalPage;
		System.out.println(fromPage);
		System.out.println(toPage);
		model.addAttribute("list", list);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("curPage", curPage);
		model.addAttribute("today", today);
		model.addAttribute("block", block);
		model.addAttribute("fromPage", fromPage);
		model.addAttribute("toPage", toPage);
		return "databoard/list";
	}
	
	@RequestMapping("insert.do")
	public String databoard_insert(){
		return "databoard/insert";
	}
	
	@RequestMapping("insert_ok.do")
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
		return "redirect:/list.do";
	}
	
	@RequestMapping("content.do")
	public String databoard_content(int no, String page, Model model){
		DataBoardVO vo=dao.dataBoardContentData(no);
		
		if(vo.getFilecount()!=0){
			StringTokenizer file=new StringTokenizer(vo.getFilename(), ",");
			List<String> nameList=new ArrayList<String>();
			while(file.hasMoreTokens()){
				nameList.add(file.nextToken());
			}
			vo.setNameList(nameList);	
		}
		
		model.addAttribute("page", page);
		model.addAttribute("vo", vo);
		return "databoard/content";
	}
	
}
