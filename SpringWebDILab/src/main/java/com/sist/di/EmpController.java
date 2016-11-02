package com.sist.di;

import com.sist.dao.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {
	
	@Autowired
	private EmpDAO dao;
	
	@RequestMapping("list.do")
	public String empAllData(Model model){
		
		List<EmpVO> list=dao.empdeptAllData();
		model.addAttribute("list", list);
		
		return "emp/list";
	}
}
