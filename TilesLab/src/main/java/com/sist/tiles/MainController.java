package com.sist.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * #Tiles
 * 	1. 개념
 * 		1) 컴포넌트 뷰 패턴 구현 프레임워크
 * 		2) Tiles2 설정 파일 작성
 * 		3) 레이아웃 템플릿 작성 
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
