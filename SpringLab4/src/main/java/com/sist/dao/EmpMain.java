package com.sist.dao;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args){
		ApplicationContext app=new ClassPathXmlApplicationContext("com/sist/dao/app.xml");
		EmpDAO dao=(EmpDAO) app.getBean("empDAO");
		List<EmpVO> list=dao.empAllData();
		
		System.out.println("   이름        직위     ");
		for(EmpVO vo : list){
			System.out.println(vo.getEname()+" "+vo.getJob());
		}
	}
}
