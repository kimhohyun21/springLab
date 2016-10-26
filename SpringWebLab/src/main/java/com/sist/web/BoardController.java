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
	//����Ʈ �о� ����
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
		String msg="�Խ��ڿ� ���� ������ �Խù��Դϴ�.";
		
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
	
	//�۾���
	@RequestMapping("board/insert.do")
	public String board_insert(){
		return "insert";
	}
	
	@RequestMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo){
		dao.boardInsert(vo);
		
		return "redirect:list.do";
	}
	
	//�󼼺���
	@RequestMapping("board/content.do") 
	public String board_content(String no, String page, Model model){
		BoardVO vo=dao.boardContent(no);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		return "content";
	}
	
	//�����ϱ�
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
		//Ajex ��� : ���ΰ�ħ ���� ������ �ݿ�
		String result;
		if(bCheck==false){
			result="<script type='text/javascript'>"
					+ "alert('�н����尡 �� �� �Ǿ����ϴ�.');"
					+ "history.back();"
					+ "</script>";
		}else{
			result="<script type='text/javascript'>"
					+ "alert('���� �Ǿ����ϴ�.');"
					+ "location.href='content.do?page="+page+"&no="+vo.getNo()+"'"
					+ "</script>";
		}
		
		return result;
	}
	
	//��۴ޱ�
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
	
	//�����ϱ�
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
					+ "alert('��й�ȣ�� �߸��Ǿ����ϴ�.');"
					+ "history.back();"
					+ "</script>";
		}else{
			result="<script>"
					+ "alert('���� �Ǿ����ϴ�.');"
					+ "location.href='list.do?page="+page+"';"
					+ "</script>";
		}
		return result;
	}
}
