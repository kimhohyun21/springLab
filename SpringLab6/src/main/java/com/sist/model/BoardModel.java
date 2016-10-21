package com.sist.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * #������̼� : @Scope
 * 	1. <bean>�� scope �Ӽ��� ���õ� ������̼�
 * 		1) singleton : �����̳ʴ� �ϳ��� Bean��ü�� ����(default)
 * 		2) prototype : Bean�� ��û�� ������ ����
 * 		3) request   : Http ��û���� Bean��ü ����
 * 		4) Session   : Http Session ��ü�� ����������Ŭ ���� �ϳ��� ���� ��� 
 */

@Component("bm")
@Scope("prototype")
public class BoardModel {
	
	@Autowired
	private MyDAO dao;
	public void execute(){
		dao.getConnection();
		System.out.println();
		System.out.println("�Խ���");
		System.out.println();
		dao.disConnection();
	}
}
