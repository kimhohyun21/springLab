package com.sist.di;
/*
 * #���������� 
 * 	1. ���� : �����ϱ� ���� ���·� Ư�� �Ծ��� ��� ������ ��
 * 	
 *  2. ��� ����
 * 		1) �䱸 ������ ���÷� ���� ==> Source Code ������ �ּ�ȭ
 * 		2) ��������� �� ������Ʈ�� ���� ==> �������� �ڵ� ��Ÿ���� ����
 * 
 * #�����ӿ�ũ 
 * 	1. ���� 
 * 		- ������ �䱸����(����, ������, ���� ��)��  �����ϴ� ������ ���̺귯�� ���
 * 		- ������ ����� ���������� ����ǵ��� �������ִ� �� ������� ���̺귯�� ���
 *  		==> �����ӿ�ũ�� �Ϻα����� ���������ν� �����ڵ�� �Ͽ��� 
 *              �ý��� �Ϻα����� �����ϴµ� ���� ��� �����ϵ��� ������
 *  2. �������	
 * 		- ������ ��ҵ��� �ʱ� ���ߴܰ踶�� �����ؾ��ϴ� �Ҹ����� �غ�����
 * 		- �������(Functional)�䱸 ���׿� ������ �� �ֵ��� ����
 *      - ����������, �ݺ������� �߰ߵǴ� ������ �ذ��ϱ� ���� Ưȭ�� Solution�� ����
 *  
 *  ==> �����ӿ�ũ�� ������ ���ϰ� �Բ� ������ ����� ��� Ŭ���� ���̺귯���� ����
 *  ==> �������� Ʋ�� �����ڵ鸣 �Բ� ������
 *  
 * #������
 * 	- �����ӿ�ũ�� ����ڵ带 Ȯ���Ͽ� ���
 * 	- �ڿ������� �ش� �����ӿ�ũ���� ���� ������ ������ �� �ְ� ��
 *  
 */
/*
 * #IoC(Inversion of Control)
 * 	1. ���� 
 * 		- ���� : ������ ����
 * 		- �ν��Ͻ� �������� �Ҹ������ �ν��Ͻ� �����ֱ� ������ �����ڰ� �ƴ� 
 * 		     �����̳�(�����ӿ�ũ)�� ��� ���شٴ� ��
 *      - �����̳��� ������ �����ӿ�ũ���� �����ϴ� ������ �Ѱܼ� 
 *        �������� �ڵ尡 �Ű����ϴ� �κ��� ���̴� ����
 * 		- �����ӿ�ũ�� ���ۿ����� �����帧�� �Ϲ����� �帧�� �ݴ�� ���������� IoC��� ��
 * 		- �����������̳ʴ� IoC�� �����ϸ�, ��Ÿ������(XML ����)�� ���� beans�� �����ϰ�
 * 		    ���ø����̼��� �߷��� �κ��� ������.
 *      - Spring �����̳ʴ� �����Ǵ� beans���� ������ ����(Di: Dependency Injection)��
 *        ���� IoC�� ������.
 * 
 */
/*
 * #Ŭ���� ���̺귯��(Class Library) 
 * 	1. ����
 * 		- �����ӿ�ũ�� ������ �ϳ��� "Semi Complete(����ǰ)"��
 * 		- �����ӿ�ũ�� Ư�� �κ��� ������� ������ ���̺귯�����·� ����, 
 * 		    ��, ���̺귯���� �����ӿ�ũ�� �� ���� ���
 * 
 *  Ư¡				�����ӿ�ũ				���̺귯��
 *  �����ڵ� �ۼ�	  �����ӿ�ũ Ŭ������                    ���������� �ۼ�
 *               ����Ŭ�����ؼ� �ۼ�		
 *  ȣ�� �帧		   �����ӿ�ũ�ڵ尡	           ������ ���̺귯�� ȣ�� 
 *                �����ڵ带 ȣ��
 *  �����帧		   �����ӿ�ũ�� ����		      �����ڵ尡 ����
 *  ��ü�� ����		   �����ӿ�ũ�� ����	               ���������� ���� 
 *  
 *  #���������� + ���̺귯�� = �����ӿ�ũ 
 */
/*
 * �����ӿ�ũ�� ����
 * 		��� 									�����ӿ�ũ ����
 * 		��(MVC) 								Spring MVC, Struts2, PlayFramwork
 * 		OR(Object-Relational) ����			Mybatis, Hibernate, JPA, Spring JDBC
 * 		AOP(Aspect Oriented Programming)	Spring AOP, JBoss AOP
 * 		DI(Dependency Injection) 			Spring DI....
 * 		Build�� Library ����					Ant, Maven, Gradle.....
 * 		JavaScript							jQuery, AngularJS, node.js....
 * 		
 */
public class Di {

}