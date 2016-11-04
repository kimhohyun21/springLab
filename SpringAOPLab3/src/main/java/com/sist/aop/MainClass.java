package com.sist.aop;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		EmpDAO dao=app.getBean("dao", EmpDAO.class);
		List<EmpVO> list=dao.empAllData();
		
		System.out.println();
		System.out.println("��ȣ        �̸�       ����          �Ի���");
		for(EmpVO vo : list){
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getHiredate());
		}
		
	}
}
