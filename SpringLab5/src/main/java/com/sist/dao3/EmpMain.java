package com.sist.dao3;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EmpMain {
	
	@Autowired // 자동으로 컨테이너에 객체 생성
	private EmpDAO dao;
	
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("com/sist/dao3/app.xml");
		
		EmpMain em=(EmpMain) app.getBean("empMain");
		List<EmpVO> list=em.dao.empAllData();
		for(EmpVO vo : list){
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}
		
	}
}
