package com.sist.web;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.jws.WebResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("board/insert.do")
	public String board_insert(){
		return "insert";
	}
	
	@RequestMapping("board/insert_ok.do")
	@ResponseBody
	public String board_insert_ok(BoardVO vo){
		dao.boardInsert(vo);		
		String result="<script type='text/javascript'>"
				+ "alert('글이 작성 되었습니다.');"
				+ "location.href='list.do'"
				+ "</script>";
		
		return result;
	}
	
	@RequestMapping("board/content.do") 
	public String board_content(String no, String page, Model model){
		BoardVO vo=dao.boardContent(no);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		return "content";
	}
	
	@RequestMapping("board/update.do")
	public String board_update(int no, String page, Model model){
		BoardVO vo=dao.boardUpdate(no);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		return "update";
	}
	
	@RequestMapping("board/update_ok.do")
	@ResponseBody
	public String board_update_ok(BoardVO vo, String page){
		boolean bCheck=dao.boardUpdatedata(vo);
		//Ajex 사용 : 새로고침 없이 데이터 반영
		String result;
		if(bCheck==false){
			result="<script type='text/javascript'>"
					+ "alert('패스워드가 잘 못 되었습니다.');"
					+ "history.back();"
					+ "</script>";
		}else{
			result="<script type='text/javascript'>"
					+ "alert('수정 되었습니다.');"
					+ "location.href='content.do?page="+page+"&no="+vo.getNo()+"'"
					+ "</script>";
		}
		
		return result;
	}
	
	@RequestMapping("board/reply.do")
	public String board_reply(String no, String page, Model model){
		model.addAttribute("page", page);
		model.addAttribute("no", no);
		return "reply";
	}
	
	@RequestMapping("board/reply_ok")
	public String board_reply_ok(String no, String page, Model model){
		model.addAttribute("page", page);
		model.addAttribute("no", no);
		return "list";
	}
}
