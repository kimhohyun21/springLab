package com.sist.tiles;
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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

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
		System.out.println(start);
		System.out.println(end);
		map.put("start", start);
		map.put("end", end);
		
		List<DataBoardVO> list=dao.dataBoardListData(map);
		System.out.println(list.size());
		int totalPage=dao.dataBoardTotalPage();
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		int block=5;
		int fromPage=(block*((curPage/5)+1))-(block-1);
		int toPage=totalPage-(block*((curPage/5)+1));
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
	
	@RequestMapping("insert.do")
	public String databoard_insert(){
		return "databoard/insert";
	}
	
	@RequestMapping("insert_ok.do")
	public String databoard_insert_ok(DataBoardVO uploadForm)throws Exception{
		List<MultipartFile> list=uploadForm.getFiles();
		String temp="";
		String temp1="";
		if(list !=null && list.size()>0){
			for(MultipartFile mf : list){
				String fn=mf.getOriginalFilename();// a.jpg
				String ext=fn.substring(fn.lastIndexOf(".")+1);// jpg
				String save=fn.substring(0, fn.lastIndexOf("."))+System.currentTimeMillis()+"."+ext; // a20160723.jpg
				
				File file=new File("c:\\download\\"+save);
				mf.transferTo(file);
				
				temp+=save+","; // a20160723.jpg, b2016073.jpg,
				temp1+=file.length()+",";
		
			}
			uploadForm.setFilename(temp.substring(0, temp.lastIndexOf(",")));
			uploadForm.setFilesize(temp1.substring(0, temp1.lastIndexOf(",")));
			uploadForm.setFilecount(list.size());
		}else{
			uploadForm.setFilename("");
			uploadForm.setFilesize("");
			uploadForm.setFilecount(0);
		}
		
		dao.dataBoardInsert(uploadForm);
		return "redirect:/list.do";
	}
	
	@RequestMapping("content.do")
	public String databoard_content(int no, String page, Model model){
		DataBoardVO vo=dao.dataBoardContentData(no);
		System.out.println(no);
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

	@RequestMapping("download.do")
	public void databoard_download(String fn, HttpServletResponse response){
		try{
			//한글 깨짐 방지 설정
			response.setHeader("content-Disposition", "attachment;filename="+URLEncoder.encode(fn, "UTF-8"));;
			
			//읽어올 파일 설정(경로 설정)
			File file=new File("c:\\download\\"+fn);
			
			// 파일 크기 만큼 다 다운 받을 수 있도록 크기 설정
			response.setContentLength((int)file.length()); 
			
			//파일을 읽고 쓰기 위한 input, output 스트림 생성
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
			
			//바이트 단위로 파일 읽어 들이기
			int i=0;
			byte[] buffer=new byte[1024];
			
			while((i=bis.read(buffer,0,1024))!=-1){
				bos.write(buffer,0,i);
			}
			
			bos.close();
			bis.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("update.do")
	public String databoard_update(int no, String page, Model model){
		DataBoardVO vo=dao.dataBoardUpdateData(no);
		
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		return "databoard/update";
	}
	
	@RequestMapping("update_ok.do")
	public String databoard_update_ok(DataBoardVO uploadForm, String page, Model model) throws Exception{
		//비밀번호를 비교하기 위해 DB에서 받아오기
		String dbpwd=dao.dataBoardGetPwd(uploadForm.getNo());
		
		//새로운 파일을 업로드 하였을 경우, 수정 및 삭제를 위해 첨부 파일 정보 불러오기
		DataBoardVO vo=dao.dataBoardGetDeleteFile(uploadForm.getNo());
		boolean bCheck=false;
		if(dbpwd.equals(uploadForm.getPwd())){
			List<MultipartFile> list=uploadForm.getFiles();
			String temp="";
			String temp1="";
			if(list !=null && list.size()>0){
				//새로 첨부한 파일이 있는 경우 ==> 기존 파일 삭제
				if(vo.getFilecount()!=0){
					temp=vo.getFilename();
					StringTokenizer st=new StringTokenizer(temp, ",");
					while(st.hasMoreTokens()){
						File file=new File("c:\\download\\"+st.nextToken());
						file.delete();
					}
					temp="";
				}
				
				//새로 첨부한 파일 Set
				for(MultipartFile mf : list){
					String fn=mf.getOriginalFilename();// a.jpg
					String ext=fn.substring(fn.lastIndexOf(".")+1);// jpg
					String save=fn.substring(0, fn.lastIndexOf("."))+System.currentTimeMillis()+"."+ext; // a20160723.jpg
					
					File file=new File("c:\\download\\"+save);
					mf.transferTo(file);
					
					temp+=save+","; // a20160723.jpg, b2016073.jpg,
					temp1+=file.length()+",";
			
				}
				uploadForm.setFilename(temp.substring(0, temp.lastIndexOf(",")));
				uploadForm.setFilesize(temp1.substring(0, temp1.lastIndexOf(",")));
				uploadForm.setFilecount(list.size());
			}else{
				//새로 첨부한 파일이 없는 경우
				uploadForm.setFilename(vo.getFilename());
				uploadForm.setFilesize(vo.getFilesize());
				uploadForm.setFilecount(vo.getFilecount());
			}
			bCheck=true;
			dao.dataBoardUpdate(uploadForm);
		}		
		
		model.addAttribute("bCheck", bCheck);
		model.addAttribute("page", page);
		return "databoard/update_ok";	
	}
	
	@RequestMapping("delete.do")
	public String databoard_delete(int no, String page, Model model){
		model.addAttribute("no", no);
		model.addAttribute("page", page);
		return "databoard/delete";
	}
	
	@RequestMapping("delete_ok.do")
	public String databoard_delete_ok(int no, String pwd, String page, Model model){
		String dbpwd=dao.dataBoardGetPwd(no);
		DataBoardVO vo=dao.dataBoardGetDeleteFile(no);
		
		boolean bCheck=false;
		if(pwd.equals(dbpwd)){
			//저장된 파일 삭제
			if(vo.getFilecount()!=0){
				String temp=vo.getFilename();
				StringTokenizer st=new StringTokenizer(temp, ",");
				while(st.hasMoreTokens()){
					File file=new File("c:\\download\\"+st.nextToken());
					file.delete();
				}
			}
			bCheck=true;		
			dao.dataBoardDelete(no);
		}
		
		model.addAttribute("bCheck", bCheck);
		model.addAttribute("page", page);
		return "databoard/delete_ok";
	}
}
