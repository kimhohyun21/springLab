package com.sist.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.dao.DBConnection;
/*
 * #PointCut ǥ����
 * 	1. Ư¡
 * 		1) AspectJ  ����Ʈ�� ǥ������ ����Ʈ �� �����ڸ� �̿��Ͽ� �ۼ�
 * 	 	2) ����Ʈ �� ������ �߿��� ���� ��ǥ������ ���Ǵ� ���� execution() ��
 * 		3) execution() �����ڸ� ����� ����Ʈ �� ǥ������ ��������
 * 	
 * 	2. �ۼ� ���
 * 								���ϰ��� Ÿ������ ==> ���� ����
 * 							    ------
 * 									    ��Ű���� Ŭ���� �̸��� ���� ���� ==> �������� 	
 * 									  -------		
 * 		execution([���������� ����]	Ÿ������[Ÿ������.]	[�̸� ���� (Ÿ�� ���� )])		
 * 				   ---------- 					 		 ------ 
 * 				   public, private ==> ���� ����         		  �Ķ���� Ÿ�� ���� : ".."==> �Ķ���� ���� ��� ����	
 * 												 ------
 * 												  �޼��� �̸� ���� 
 * 
 * 		Ex)
 * 				   any type  package  class method 
 * 					   |		|		|    |
 * 			"execution(* com.sist.dao.EmpDAO.*(..))"
 * 											   |
 * 										any type and number of argument	 
 */

/* �ΰ� ���  ȣ�� �� ����*/
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
	
	//�ΰ� ��� ȣ�� �� ����Ʈ �� ����
	@Before("execution(* com.sist.dao.EmpDAO.*(..))")
	public void getConnection(JoinPoint jp){
		dbcon.getConnection();
	}
	
	@After("execution(* com.sist.dao.EmpDAO.*(..))")
	public void disConnection(JoinPoint jp){
		dbcon.disConnection();
	}
	
	
}
