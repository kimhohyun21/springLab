package myspring.di.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

/*
 * #빈(Bean)
 * 
 * #빈 팩토리 (BeanFactory) 
 * 	1. 개념
 * 		1) 스프링의 IoC를 담당하는 핵심 컨테이너
 * 			- Bean을 등록, 생성, 조회, 반환 가능
 * 		2) 이 BeanFactory를 바로 사용하지 않고 이를 확장한
 * 		   ApplicationContext를 주로 이용함
 * 
 * #어플리케이션컨텍스트 (ApplicationContext)
 * 	1. 개념
 * 		1) BeanFactory(Bean등록, 관리 기능)과 동일
 * 		2) 스프링이 제공하는 각종 부가 서비스를 추가로 제공함
 * 		3) 스프링에서는 ApplicationContext를 BeanFactory 보다 많이 사용
 * 
 * #설정 메타정보 (Configuration Metadata)
 * 	1. 개념
 * 		1) ApplicationContext 또는 BeanFactory가 IoC를 적용하기 위해서 사용하는 메타정보를 말함
 * 		2) 설정 메타 정보는 IoC 컨테이너에 의해 관리되는 Bean 객체를 생성, 구성할때 사용함.
 */
public class HelloBeanTest {
	public static void main(String[] args){
		//1. IoC 컨테이너 생성 ==> beans.xml을 읽어와서 IoC컨테이너를 만들어야 함 ==> xml에서 생성한 class들을 사용할 수 있음 
		ApplicationContext context=new GenericXmlApplicationContext("config/beans.xml");
		
		//2. Hello Bean 가져오기
		Hello hello=(Hello) context.getBean("hello");
		System.out.println(hello.sayHello());
		hello.print();
		
		//3. StringPrinter Bean가져오기
		Printer string=context.getBean("stringPrinter", Printer.class);
		System.out.println(string);
		
		//4. ConsolePrinter Bean가져오기
		Printer console=context.getBean("consolePrinter", Printer.class);
		console.print(hello.sayHello());
		
		
	}
}
