package myspring.di.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * #Spring-Test���� �׽�Ʈ�� �����ϴ� ������̼�
 * 	1. @RunWith(SpringJUnite4ClassRunner.class)
 * 		1) JUnit �����ӿ�ũ �׽�Ʈ �������� Ȯ���� �� ����ϴ� ������̼�
 * 		2) �̱����� ApplicationContext�� ������
 * 	
 * 	2. @ContextConfiguration
 * 		1) �������� ��ϵǾ����� Bean���� ���� ���� ��ġ�� ������ �� ����ϴ� ������̼�
 * 	
 * 	3. @Autowired
 * 		1) ������ DI���� ����ϴ� Ư���� ������̼�
 * 		2) �ش� ������ �ڵ����� ��(Bean)�� ������ ��
 * 			==> GenericXmlApplicationContext�� ����� �ʿ䰡 ���Ե�
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	ApplicationContext context;
	
	@Test
	public void bean1(){
		//getBean ȣ��
		Hello hello=(Hello) context.getBean("hello");
		//sayHello ȣ��
		assertEquals("Hello Spring", hello.sayHello());
		
		hello.print();
		
		Printer string=context.getBean("stringPrinter", Printer.class);
		assertEquals("Hello Spring", string.toString());
	}
}
