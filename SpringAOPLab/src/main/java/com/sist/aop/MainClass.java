package com.sist.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * # 비지니스 컴포넌트 개발
 * 	1. 가장 중요한 원칙
 * 		1) 낮은 결합도 ==> 의존성 주입 (DI) 이용
 * 		2) 높은 응집도 ==> AOP 이용
 * 
 * #AOP (Aspect Oriented Programming)
 * 	1. 핵심 기능과 부가 기능
 * 		1) 핵심기능(Core Conerns) 
 * 			: 업무(Biz) 로직을 포함하는 기능
 * 		2) 부가기능(Cross-cutting Concerns) 
 * 			: 핵심기능을 도와주는 부가적인 기능(로깅, 보안 등)
 * 		
 * 		==> 기존의 Application에서는 oop의 기본원칙을 적용하여도
 * 			핵심기능에서 부가 기능을 분리, 모듈화 하는 것이 어려움
 *		==> 이를 보완하기 위해 탄생한 것이 AOP
 *
 *	2. AOP 개요
 *		1) 개념
 *			- 어플리케이션의 관심사의 분리 (기능의 분리)
 *			    즉, 핵심적인 기능에서 부가적인 기능을 분리함.
 *			- 분리한 부가기능을 애스팩트(Aspect)라는 독특한  모듈 형태로 만들어서
 *			    설계하고 개발하는 방법
 *
 *		2) 역할
 *			- AOP는 부가기능을 애스팩트로 정의하여, 핵심기능에서 부가기능을 분리함
 *			    핵심기능을 설계, 구현할 때, 객체지향적인 가치를 지킬 수 있게 도와줌
 *		
 *	3. AOP 용어
 *		1) 애스팩트(Aspect)
 *			- Aspect = Advice(어드바이스 : 부가기능을 정의한 코드) 
 *						+ PointCut(포인트 컷 : 어드바이스를 어디에 적용할지 결정하는 것) 	
 *		  	- 핵심기능 코드 사이에 침투된 부가기능을 독립적인 애스팩트로 구분해 낼 수 있음
 *			- 구분된 부가기능 애스팩트를 런타임시에 필요한 위치에 동적으로 참여할 수 있음
 *			- AOP의 기본 모듈
 *			- Aspect는 싱글톤 형태의 객체로 존재함
 *		
 *		2) 타겟(Target)
 *			- 핵심 기능을 담고 있는 모듈
 *			- 비지니스 로직을 구현한 부분, 클래스 내의 특정 메서드
 *			- 타겟은 부가기능을 부여할 대상이 됨
 *		
 *		3) 어드바이스(advice)
 *			- 어드바이스는 타겟에 제공할 부가기능을 담고 있는 모듈
 *		
 *		4) 조인 포인트(Join Point)
 *			- 어드바이스가 적용될 수 있는 위치를 말함
 *			- 즉, 타겟객체가 구현한 인터페이스의 모든 메서드는 조인 포인드가 됨
 *
 *		5) 포인트 컷(PointCut)
 *			- 어드바이스를 적용할 타겟의 메서드를  선별하는 정규 표현식		 
 *			- 즉, 포인트 컷 표현식은 execution으로 시작하고, 
 *			    매서드의 Signature를 비교하는 방법을 주로 이용함
 *
 *		6) 어드바이저(Advisor)
 *			- 어드바이져 = Aspect = 어드바이스 + 포인트컷
 *			- 스프링 AOP에서만 사용하는 용어
 *
 *		7) 위빙(Weaving)
 *			- 포인트 컷에 의해서 결정된 타깃의 조인 포인트에
 *			    부가기능(어드바이스)를 삽입하는 과정을 뜻함.
 *			- 위빙은 AOP가 핵심기능(타겟)의 코드에 영향을 주지 않으면서
 *			    필요한 부가기능(어드바이스)을 추가할 수 있도록 해주는 
 *			    핵심적인 처리 과정
 *	
 * 	4. Spring AOP의 특징
 * 		1) Spring은 프록시(Proxy) 기반 AOP 지원
 * 			- Spring은 타깃(Target)객체에 대한 프록시를 만들어 제공함
 * 			- 타겟을 감싸는 프록시는 실행시간(Runtime)에 생성됨
 * 			- 프록시는 어드바이스를 타깃 객체에 적용하면서 생성되는 객체임 			
 * 		
 * 		2) 프록시(Proxy)가 호출을 가로챔(intercept)
 * 			- 전처리 어드바이스 
 * 				: 프록시는 타깃 객체에 대한 호춯을 가로챈 다음 
 * 				    어드바이스의 부가기능 로직을 수행하고 난 후
 * 			             타깃의 핵심기능 로직을 호출함
 * 		
 * 			- 후처리 어드바이스
 * 				: 타깃의 핵심기능 로직 메서드를 호출한 후에 
 * 				    부가기능(어드바이스)를 수행하는 경우  
 * 
 * 		3) Spring AOP는 메서드 조인 포인트만 지원 함.
 * 			- Spring은 동적 프록시를 기반으로 AOP를 구현하므로
 * 			    메서드 조인 포인트만 지원함
 * 			- 즉, 핵심기능(타깃)의 메서드가 호출되는 런타임 시점에만
 * 			    부가기능(어드바이스)를 적용할 수 있음
 * 			- 객체의 생성, 필드값의 조회와 조작, static 메서드 호출 및 초기화 등의
 * 			    다양한 작업에 부가기능을 적용(AspectJ 고급 AOP 프레임워크의 경우)
 *	
 *	5. Spring AOP의 구현 방식
 *		1) XML 기반의 POJO 클래스를 이용한 AOP 구현
 *			- 부가기능을 제공하는 Advice 클래스를 작성함
 *			- XML 설정 파일에 <aop:config>를 이용해서 애스팩트(어드바이스+포인트컷)을 설정함.
 *				
 *		2) Aspect 어노테이션을 이용한 AOP 구현	
 *			- @Aspect 어노테이션을 이용하여
 *			     부가기능을 제공하는 Aspect 클래스를 작성
 *			  Aspect클래스는 어드바이스를 구현하는 메서드와 포인트 컷을 포함함.
 *			- XML 설정 파일에 <aop:aspectj-autoproxy/>를 설정함.
 *
 *	6. Advice의 종류
 *		1) Around 어드바이스
 *			- JoinPoint 앞과 뒤에서 실행되는 Advice
 *			- 타깃 메서드가 호출되기 이전(Before)시점과 이후(after) 시점에
 *			    모두 처리해야할 필요가 있는 부가기능을 정의함
 *
 *		2) Before 어드바이스
 *			- JoinPoint 앞에서 실행되는 Advice
 *			- 타깃의 메서드가 실행되기 이전(Before) 시점에서 처리해야할 필요가 있는 부가 기능을 정의함
 *		
 *		3) After Returning 어드바이스
 *			- JoinPoint 메서드 호툴이 정상적으로 종료된 뒤에 실행되는 Advice
 *			    타깃의 메서드가 정상적으로 실행된 이후(After) 시점에 처리해야할 필요가 있는 부가 기능을 정의 함
 *
 *		4) After Throwing 어드바이스
 *			- 예외가 발생할 때 실행되는 Advice
 *			- 타깃 메서드가 예외를 발행시킨 이후(After) 시점에 처리해야할 필요가 있는 부가기능을 정의함.
 */	
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		MyEmp emp=app.getBean("me", MyEmp.class);
		emp.dbConnection();
	}
}
