package com.sist.di;
/*
 * #Spring Framework란?
 * 	1. 개념
 * 		: Java 엔터프라이즈 개발을 편하게 해주는 오픈 소스
 * 		     경량급 어플리케이션 프레임워크 임
 *    	1) 어플리케이션 프레임워크 
 *      	- 특정 계층이나 기술, 업무분야에 국한하지 않고
 *            어플리케이션 전 영역을 포괄하는 범용적인 프레임워크
 *      
 *      2) 경량급 프레임워크
 *         	- 단순한 웹컨테이너에서도 엔터프라이즈 개발의 고급 기술을 
 *            대부분 사용할 수 있음
 * 		
 * 		3) 엔터프라이즈 개발 용이
 * 			- 개발자가 복잡하거나, 실수라기 쉬운 low level에 많이 신경쓰지 않으면서 
 * 			  Business Logic 개발에 전념할 수 있도록 도와줌
 * 		
 * 		4) 오픈 소스
 * 			- 무료로 소스를 사용할 수 있으나 문제 발생시 피드백을 받기 어려워
 * 			     자체적으로 해결 방안을 찾아야 하는 경우가 종종 있음
 * 	
 *	2. Spring Framework전략 (Spring Triangle)
 * 		: 엔터프라이즈 개발의 복잡성을 상대하는 Spring의 전략
 * 			==> PSA(Portable Service Abstraction), DI, AOP + POJO
 * 		1) PSA(서비스 추상화) 
 * 			- 트랜잭션 추상화, OXM 추상화....
 * 		   	- Low Level의 기술 구현 부분과 기술을 사용하는 인터페이스로 분리함
 * 		
 * 		2) 객체지향과 DI(Dependency Injection)
 * 			- Spring은 객체지향에 충실한 설계가 가능하도록 단순한 형태로 개발할 수 있고, 
 * 			  DI는 유연하게 확장이 가능한 객체를 만들어두고,
 * 			    그 관계는 외부에서 다이나믹하게 설정해줌
 * 			
 * 		3) AOP(Aspect Oriented Programing)
 * 			- 어플리케이션 로직을 담당하는 코드에 남아있는 기술관련 코드를 
 * 			    분리해서 별도의 모듈로 관리하게 해주는 강력한 기술임
 * 			
 * 		4) POJO(Plain Old Java Object)
 * 			- POJO는 객체지향 원리에 충실하면서, 특정환경이나 규약에 종속하지 않고
 * 			    필요에 따라 재활용될 수 있는 방식으로 설계된 객체임.	 	
 * 
 *  3. Spring Framework의 특징
 * 		1) 컨테이너의 역할 
 * 			: Java 객체의 Life Cycle을 관리,Spring 컨테이너로부터 필요한 객체를 가져와 사용할 수 있음
 * 	
 * 		2) DI(Dependency Injection) 지원
 * 			: Spring은 설정파일이나 어노테이션을 통해서 객체간의 의존관계를 설정할 수 있도록 하고 있음
 * 	
 * 		3) AOP(Aspect Oriented Programming)
 * 			: Spring은 트랜잭션이나 로깅, 보안과 같이 공통적으로 필요로하는 모듈들을 
 * 		 	    실제 핵심 모듈에서 분리해서 적용할 수 있음
 * 	    
 * 		4) POJO(Plain Old Java Object)
 * 			: Spring 컨테이너에 저장되는 Java객체는 특정한 인터페이스를 구현
 * 			    특정 클래스를 상속받지 않아도 됨
 * 		
 * 		5) 트랜잭션 처리를 위한 일관된 방법을 지원
 * 		
 * 		6) 영속성(Persistence)과 관련된 다양한 API 지원
 * 			: Spring은 MyBatis, Hibernate등 DB처리를 위한 
 * 			  ORM(Object Relational Mapping) 프레임워크와 연동 지원
 * 		
 */
/*
 * #Spring Framework를 구성하는 기능요소
 * 	1. Core Container
 * 		: Spring 프레임워트의 기본기능 제공
 * 		    이 모듈에 있는 BeanFactory는 Spring의 기본 컨테이너이면서
 * 		  Spring DI의 기반임.
 * 
 * 	2. AOP
 * 		: AOP 모듈을 통해 Aspect 지향 프로그래밍을 지원함
 * 	
 * 
 * 	3. Spring ORM 
 * 		: MyBatis, Hibernate, JPA등 널리 사용하는 ORM 프레임워크와의 연결고리를 제공함
 * 		  ORM 제품들을 Spring의 기능과 조합해서 사용할 수 있도록 해줌
 * 	
 * 	4. WebMVC (Model/View/Controller)
 * 		: 사용자 인터페이스가 어플리케이션 로직과 분리되는 웹 어플리케이션 만드는 경우에 
 * 		    일반적으로 사용되는 패러다임 	
 * 
 */
public class Di {
	
}
