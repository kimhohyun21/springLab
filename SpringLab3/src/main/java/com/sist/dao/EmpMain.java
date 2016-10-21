package com.sist.dao;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args){
		ApplicationContext app=new ClassPathXmlApplicationContext("com/sist/dao/app.xml");
		
		EmpDAO dao=(EmpDAO) app.getBean("dao");
		List<EmpVO> list=dao.empAlldata();
		
		System.out.println("사번       이름              직위               입사일                월급    ");
		for(EmpVO vo : list){
			System.out.println(vo.getEmp()+" "
								+vo.getEname()+"   "
								+vo.getJob()+"   "
								+vo.getHiredate()+" "
								+vo.getSal());
		}
	}
}
