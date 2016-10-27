package com.sist.multipart;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String main_page(HttpServletRequest request){
		String pathSet=request.getSession().getServletContext().getRealPath("main");
		System.out.println(pathSet);
		String url="file:\\\\\\"+pathSet;
		request.setAttribute("url", url);
		request.setAttribute("pathSet", pathSet);
		return "main.jsp";
	}
}
