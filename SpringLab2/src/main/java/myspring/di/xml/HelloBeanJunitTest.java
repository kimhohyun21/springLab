package myspring.di.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * #jUnit
 * 	: java에서 독립된 단위테스트(Unit Test)를 지원하는 프레임워크
 * 
 * #단위테스트
 * 	: 소스코드의 특정 모듈-의도된대로 작동 검증 절차, 모든 함수와 메소드에 대한 테스트 케이스를 작성하는 절차.
 * 		
 * # jUnit4부터는 테스트를 지원하는 어노테이션 제공함
 * 	1. @Test 
 * 		: @Test가 선언된 메서드는 테스트를 수행하는 메소드가 됨
 * 	2. @Before 
 * 		: @Before가 선언된 메서드는 @Test 메소드가 실행되기 전에 반드시 실행되어 짐
 * 	3. @After 
 * 		: @After가 선언된 메서드는 @Test메소드가 실행된 후 실행됨
 * 
 * #assert : 테스트 결과를 확인하는 메서드
 */
public class HelloBeanJunitTest {
	ApplicationContext context;	
	
	@Before
	public void init(){
		//1. IoC컨테이너 생성
		context=new GenericXmlApplicationContext("classpath:config/beans.xml");
	}
	
	@Test
	public void bean1(){
		//2.getBean() 호출
		Hello hello=(Hello) context.getBean("hello");
		
		//3. sayHello() 호출
		assertEquals("Hello Spring", hello.sayHello());
		//assertEquals(a, b) : 객체 a와 b가 동일 값인지 확인
		//==> hello.sayHello()를 호출한 결과값이 "Hello Spring"과 동일한지 확인
		
		//4. Hello의 printer() 호출
		hello.print();
	}
	
	@Test
	public void bean2(){
		Printer string=(Printer) context.getBean("stringPrinter");
		Printer string2=context.getBean("stringPrinter", Printer.class);
		
		/*
		 * assertSame(a, b) : 객체 a, b의 객체 자체가 동일한지 확인 (==)
		 * assertEquals(a, b) : 객체 a, b의 값이 동일한지 확인
		 */
		assertSame(string, string2);
	}
	
}
