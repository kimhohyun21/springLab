package com.sist.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * #어노테이션 : @Scope
 * 	1. <bean>의 scope 속성과 관련된 어노테이션
 * 		1) singleton : 컨테이너는 하나의 Bean객체만 생성(default)
 * 		2) prototype : Bean을 요청할 때마다 생성
 * 		3) request   : Http 요청마다 Bean객체 생성
 * 		4) Session   : Http Session 자체의 라이프사이클 동안 하나의 빈을 사용 
 */

@Component("bm")
@Scope("prototype")
public class BoardModel {
	
	@Autowired
	private MyDAO dao;
	public void execute(){
		dao.getConnection();
		System.out.println();
		System.out.println("게시판");
		System.out.println();
		dao.disConnection();
	}
}
