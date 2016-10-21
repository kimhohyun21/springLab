package com.sist.dao2;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {
	private EmpDAO dao;

	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	
	public static void main(String[] args){
		ApplicationContext app=new ClassPathXmlApplicationContext("com/sist/dao2/app.xml");
		
		EmpMain em=(EmpMain) app.getBean("empMain");
		List<EmpVO> list=em.dao.empAllData();
		
		System.out.println("*******EmpMain*******");
		for(EmpVO vo : list){
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}
		
		//그냥 dao 생성해서 실행도 가능
		System.out.println();
		EmpDAO dao=(EmpDAO) app.getBean("dao");
		List<EmpVO> list2=dao.empAllData();
		
		
		System.out.println("*******EmpDAO*******");
		for(EmpVO vo : list2){
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}
	}
	
}
