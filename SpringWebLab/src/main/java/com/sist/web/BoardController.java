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
	//리스트 읽어 오기
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
		String msg="게시자에 의해 삭제된 게시물입니다.";
		
		model.addAttribute("msg", msg);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("block", block);
		model.addAttribute("today", today);
		model.addAttribute("fromPage", fromPage);
		model.addAttribute("toPage", toPage);
		model.addAttribute("list", list);
		
		return "list";
	}
	
	//글쓰기
	@RequestMapping("board/insert.do")
	public String board_insert(){
		return "insert";
	}
	
	@RequestMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo){
		dao.boardInsert(vo);
		
		return "redirect:list.do";
	}
	
	//상세보기
	@RequestMapping("board/content.do") 
	public String board_content(String no, String page, Model model){
		BoardVO vo=dao.boardContent(no);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		return "content";
	}
	
	//수정하기
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
	
	//답글달기
	@RequestMapping("board/reply.do")
	public String board_reply(String no, String page, Model model){
		model.addAttribute("page", page);
		model.addAttribute("no", no);
		return "reply";
	}
	
	@RequestMapping("board/reply_ok.do")
	public String board_reply_ok(String no, String page, BoardVO vo, Model model){
		BoardVO pvo=dao.boardParentData(no);
		dao.boardStepIncrement(pvo);
		
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);
		vo.setGroup_tab(pvo.getGroup_tab()+1);
		
		dao.boardReplyInsert(vo);
		
		dao.boardDepthIncrement(no);		
		
		model.addAttribute("page", page);
		model.addAttribute("no", no);		
		return "redirect:list.do";
	}
	
	//삭제하기
	@RequestMapping("board/delete.do")
	public String board_delete(int no, String page, Model model){		
		model.addAttribute("page", page);
		model.addAttribute("no", no);		
		return "delete";
	}
	
	@RequestMapping("board/delete_ok.do")
	@ResponseBody
	public String board_delete_ok(int no, String page, String pwd){
		boolean bCheck=dao.boardDelete(no, pwd);
		String result="";
		if(bCheck==false){
			result="<script>"
					+ "alert('비밀번호가 잘못되었습니다.');"
					+ "history.back();"
					+ "</script>";
		}else{
			result="<script>"
					+ "alert('삭제 되었습니다.');"
					+ "location.href='list.do?page="+page+"';"
					+ "</script>";
		}
		return result;
	}
}
