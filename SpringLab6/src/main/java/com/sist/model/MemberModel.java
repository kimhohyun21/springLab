package com.sist.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberModel {
	
	@Autowired
	private MyDAO dao;
	public void execute(){
		dao.getConnection();
		System.out.println();
		System.out.println("ȸ��ó��");
		System.out.println();
		dao.disConnection();		
	}
}
