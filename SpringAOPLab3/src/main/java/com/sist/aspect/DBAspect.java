package com.sist.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.dao.DBConnection;
/*
 * #PointCut 표현식
 * 	1. 특징
 * 		1) AspectJ  포인트컷 표현식은 포인트 컷 지시자를 이용하여 작성
 * 	 	2) 포인트 컷 지시자 중에서 가장 대표적으로 사용되는 것은 execution() 임
 * 		3) execution() 지시자를 사용한 포인트 컷 표현식의 문법구조
 * 	
 * 	2. 작성 방법
 * 								리턴값의 타입패턴 ==> 생략 가능
 * 							    ------
 * 									    패키지와 클래스 이름에 관한 패턴 ==> 생략가능 	
 * 									  -------		
 * 		execution([접근제한자 패턴]	타입패턴[타입패턴.]	[이름 패턴 (타입 패턴 )])		
 * 				   ---------- 					 		 ------ 
 * 				   public, private ==> 생략 가능         		  파라미터 타입 패턴 : ".."==> 파라미터 유무 모두 가능	
 * 												 ------
 * 												  메서드 이름 패턴 
 * 
 * 		Ex)
 * 				   any type  package  class method 
 * 					   |		|		|    |
 * 			"execution(* com.sist.dao.EmpDAO.*(..))"
 * 											   |
 * 										any type and number of argument	 
 */

/* 부가 기능  호출 및 설정*/
@Aspect
@Component
public class DBAspect {
	
	@Autowired
	public DBConnection dbcon;

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}
	
	//부가 기능 호출 및 포인트 컷 설정
	@Before("execution(* com.sist.dao.EmpDAO.*(..))")
	public void getConnection(JoinPoint jp){
		dbcon.getConnection();
	}
	
	@After("execution(* com.sist.dao.EmpDAO.*(..))")
	public void disConnection(JoinPoint jp){
		dbcon.disConnection();
	}
	
	
}
