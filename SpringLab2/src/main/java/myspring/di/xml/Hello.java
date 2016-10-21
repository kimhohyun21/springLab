package myspring.di.xml;

import java.util.*;

/*
 * #IoC(Inversion of Control)
 * 	1. ����
 *		1) ������� ����.
 *		2) ��ü�� ����, �����ֱ��� �������� ��� ��ü�� ���� ������� �ٲ���ٴ� ���� �ǹ�(F/w)
 * 			==> ������Ʈ �������� ����(component dependency resolution), 
 * 				����(configuration) �� �����ֱ�(lifecycle)�� �ذ��ϱ� ���� 
 * 				����������(Design Pattern)(������ ����:ó�� �ַ�� ����ȭ ��Ų ��)
 * 
 */
/*
 * #IoC �����̳�
 * 	1. ��� �� ����
 * 		1) Spring Framework�� IoC �����̳� ��� ����
 * 			- ��ü�� ���� ���� �� �����ֱ⸦ ������ �� �ִ� ���
 * 		2) IoC �����̳ʴ� ��ü�� ������ å������ �������� ������
 * 			- POJO�� ����, �ʱ�ȭ, ����, �Ҹ꿡 ���� ������ ����
 * 			- �����ڵ��� ���� POJO�� ������ �� ������ �����̳ʿ��� �ñ�
 * #IoC�з�
 * 	1. DL(Dependency Lookup) 
 * 		: ������ �˻�
 * 	2. DI(Dependency Injection) 
 * 		: ������ ���� 
 * 			==> �� Ŭ�������� �������踦 ����(bean deifinition)�� ������ �������� 
 * 				�����̳ʰ� �ڵ����� ��������
 * 		1) Setter Injection
 * 		2) Contructor Injection
 * 		3) Method Injection
 * 		
 * 			==> DI�� ����� ���.... 
 * 				* �����ڵ��� ���� �� ���� ���Ͽ� ���� ���谡 �ʿ��ϴٴ� ������ �߰��ϸ� ��
 * 				* ��ü ���۷����� �����̳ʷ� ���� ���� �޾Ƽ�, ����ÿ� �������� �������谡 ������
 * 				* �����̳ʰ� �帧�� ��ü�� �Ǿ� ���ø����̼� �ڵ忡 �������踦 �������ִ� ��
 * 				* ���� : �ڵ尡 �ܼ�����, ������Ʈ���� ���յ��� ���ŵ�	
 * 
 * #DI�� ����
 * 	1. Setter Injection 
 * 		: Setter �޼��带 �̿��� ������ ����.
 * 	2. Constructor Injection 
 * 		: �����ڸ� �̿��� ������ ����
 * 	3. Method Injection 
 * 		: �Ϲ� �޼��带 �̿��� ������ ����
 * 	
 * 																 <interface>			
 * 		Ŭ���� ==== ��� ====> �������̽�                Hello.java ==== ��� ===> Printer.java
 * 		 ^					 ^				 ^						^	 ^
 * 		 |					 |				 |						|	 |						
 * 	    ������ ����				����			     ������ ����					    ����
 * 		 |					 |				 |						|	 |
 * 		 |					 |				 |					    |    | 
 * 		������ ===== ���� ====> Ŭ����			  beans.xml =����=> StringPrinter ConsolePrinter	
 * 		
 */

public class Hello {
	private String name;
	private Printer printer;
	private List<String> names; //�÷���(Collection) Ÿ�԰� ����
	
	public Hello(){
		System.out.println("Hello ��ü ����");
	}
	
	public Hello(String name, Printer printer){
		this.name=name;
		this.printer=printer;
		System.out.println("Hello ��ü ����-������ �����ε�");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Printer getPrinter() {
		return printer;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}	
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}

	
	public String sayHello(){
		return "Hello "+name;
	}
	
	public void print(){
		printer.print(sayHello());
	}
}
