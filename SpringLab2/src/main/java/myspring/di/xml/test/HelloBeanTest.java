package myspring.di.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

/*
 * #��(Bean)
 * 
 * #�� ���丮 (BeanFactory) 
 * 	1. ����
 * 		1) �������� IoC�� ����ϴ� �ٽ� �����̳�
 * 			- Bean�� ���, ����, ��ȸ, ��ȯ ����
 * 		2) �� BeanFactory�� �ٷ� ������� �ʰ� �̸� Ȯ����
 * 		   ApplicationContext�� �ַ� �̿���
 * 
 * #���ø����̼����ؽ�Ʈ (ApplicationContext)
 * 	1. ����
 * 		1) BeanFactory(Bean���, ���� ���)�� ����
 * 		2) �������� �����ϴ� ���� �ΰ� ���񽺸� �߰��� ������
 * 		3) ������������ ApplicationContext�� BeanFactory ���� ���� ���
 * 
 * #���� ��Ÿ���� (Configuration Metadata)
 * 	1. ����
 * 		1) ApplicationContext �Ǵ� BeanFactory�� IoC�� �����ϱ� ���ؼ� ����ϴ� ��Ÿ������ ����
 * 		2) ���� ��Ÿ ������ IoC �����̳ʿ� ���� �����Ǵ� Bean ��ü�� ����, �����Ҷ� �����.
 */
public class HelloBeanTest {
	public static void main(String[] args){
		//1. IoC �����̳� ���� ==> beans.xml�� �о�ͼ� IoC�����̳ʸ� ������ �� ==> xml���� ������ class���� ����� �� ���� 
		ApplicationContext context=new GenericXmlApplicationContext("config/beans.xml");
		
		//2. Hello Bean ��������
		Hello hello=(Hello) context.getBean("hello");
		System.out.println(hello.sayHello());
		hello.print();
		
		//3. StringPrinter Bean��������
		Printer string=context.getBean("stringPrinter", Printer.class);
		System.out.println(string);
		
		//4. ConsolePrinter Bean��������
		Printer console=context.getBean("consolePrinter", Printer.class);
		console.print(hello.sayHello());
		
		
	}
}
