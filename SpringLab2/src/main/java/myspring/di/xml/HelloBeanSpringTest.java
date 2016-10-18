package myspring.di.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * #Spring-Test에서 테스트를 지원하는 어노테이션
 * 	1. @RunWith(SpringJUnite4ClassRunner.class)
 * 		1) JUnit 프레임워크 테스트 실행방법을 확장할 때 사용하는 어노테이션
 * 		2) 싱글톤의 ApplicationContext를 보장함
 * 	
 * 	2. @ContextConfiguration
 * 		1) 스프링에 등록되어지는 Bean들의 설정 파일 위치를 지정할 때 사용하는 어노테이션
 * 	
 * 	3. @Autowired
 * 		1) 스프링 DI에서 사용하는 특별한 어노테이션
 * 		2) 해당 변수에 자동으로 빈(Bean)을 매핑해 줌
 * 			==> GenericXmlApplicationContext를 사용할 필요가 없게됨
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	ApplicationContext context;
	
	@Test
	public void bean1(){
		//getBean 호출
		Hello hello=(Hello) context.getBean("hello");
		//sayHello 호출
		assertEquals("Hello Spring", hello.sayHello());
		
		hello.print();
		
		Printer string=context.getBean("stringPrinter", Printer.class);
		assertEquals("Hello Spring", string.toString());
	}
}
