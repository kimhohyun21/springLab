package myspring.di.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * #jUnit
 * 	: java���� ������ �����׽�Ʈ(Unit Test)�� �����ϴ� �����ӿ�ũ
 * 
 * #�����׽�Ʈ
 * 	: �ҽ��ڵ��� Ư�� ���-�ǵ��ȴ�� �۵� ���� ����, ��� �Լ��� �޼ҵ忡 ���� �׽�Ʈ ���̽��� �ۼ��ϴ� ����.
 * 		
 * # jUnit4���ʹ� �׽�Ʈ�� �����ϴ� ������̼� ������
 * 	1. @Test 
 * 		: @Test�� ����� �޼���� �׽�Ʈ�� �����ϴ� �޼ҵ尡 ��
 * 	2. @Before 
 * 		: @Before�� ����� �޼���� @Test �޼ҵ尡 ����Ǳ� ���� �ݵ�� ����Ǿ� ��
 * 	3. @After 
 * 		: @After�� ����� �޼���� @Test�޼ҵ尡 ����� �� �����
 * 
 * #assert : �׽�Ʈ ����� Ȯ���ϴ� �޼���
 */
public class HelloBeanJunitTest {
	ApplicationContext context;	
	
	@Before
	public void init(){
		//1. IoC�����̳� ����
		context=new GenericXmlApplicationContext("classpath:config/beans.xml");
	}
	
	@Test
	public void bean1(){
		//2.getBean() ȣ��
		Hello hello=(Hello) context.getBean("hello");
		System.out.println();
		//3. sayHello() ȣ��
		assertEquals("Hello Spring", hello.sayHello());
		//assertEquals(a, b) : ��ü a�� b�� ���� ������ Ȯ��
		//==> hello.sayHello()�� ȣ���� ������� "Hello Spring"�� �������� Ȯ��
		
		//4. Hello�� printer() ȣ��
		hello.print();
	}
	
	@Test
	public void bean2(){
		Printer string=(Printer) context.getBean("stringPrinter");
		Printer string2=context.getBean("stringPrinter", Printer.class);
		System.out.println();
		/*
		 * assertSame(a, b) : ��ü a, b�� ��ü ��ü�� �������� Ȯ�� (==)
		 * assertEquals(a, b) : ��ü a, b�� ���� �������� Ȯ��
		 */
		assertSame(string, string2);
	}
	
	@Test
	public void bean3(){
		//getBean() ȣ��
		Hello hello=(Hello) context.getBean("hello3");
		System.out.println();
		assertEquals(3, hello.getNames().size());
		
		List<String> list=hello.getNames();
		
		for(String value : list){
			System.out.println(value);
		}
	}
}
