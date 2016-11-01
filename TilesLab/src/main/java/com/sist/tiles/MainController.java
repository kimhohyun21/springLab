package com.sist.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * #Tiles
 * 	1. ����
 * 		1) ������Ʈ �� ���� ���� �����ӿ�ũ
 * 		2) Tiles2 ���� ���� �ۼ�
 * 		3) ���̾ƿ� ���ø� �ۼ� 
 */
@Controller
public class MainController {
	
	@RequestMapping("main.do")
	public String main_page(){
		return "main";
	}
	
	@RequestMapping("notice.do")
	public String notice_page(){
		return "notice/list";
	}
	
	@RequestMapping("join.do")
	public String join_page(){
		return "member/join";
	}
	
	@RequestMapping("login.do")
	public String login_page(){
		return "member/list/login";
	}
}
