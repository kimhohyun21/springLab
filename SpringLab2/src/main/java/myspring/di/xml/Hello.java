package myspring.di.xml;

/*
 * #IoC(Inversion of Control)
 * 	1. 개념
 *		1) 제어권의 역전.
 *		2) 객체의 생성, 생명주기의 관리까지 모든 객체에 대한 제어권이 바뀌었다는 것을 의미(F/w)
 * 			==> 컴포넌트 의존관계 결정(component dependency resolution), 
 * 				설정(configuration) 및 생명주기(lifecycle)를 해결하기 위한 
 * 				디자인패턴(Design Pattern)(디자인 패턴:처리 솔루션 정형화 시킨 것)
 * 
 */
/*
 * #IoC 컨테이너
 * 	1. 기능 및 역할
 * 		1) Spring Framework도 IoC 컨테이너 기능 제공
 * 			- 객체에 대한 생성 및 생명주기를 관리할 수 있는 기능
 * 		2) IoC 컨테이너는 객체의 생성을 책임지고 의존성을 관리함
 * 			- POJO의 생성, 초기화, 서비스, 소멸에 의한 권한을 가짐
 * 			- 개발자들이 직접 POJO를 생성할 수 잇지만 컨테이너에게 맡김
 * #IoC분류
 * 	1. DL(Dependency Lookup) 
 * 		: 의존성 검색
 * 	2. DI(Dependency Injection) 
 * 		: 의존성 주입 
 * 			==> 각 클래스간의 의존관계를 빈설정(bean deifinition)의 정보를 바탕으로 
 * 				컨테이너가 자동으로 연결해줌
 * 		1) Setter Injection
 * 		2) Contructor Injection
 * 		3) Method Injection
 * 		
 * 			==> DI를 사용할 경우.... 
 * 				* 개발자들은 단지 빈 설정 파일에 의존 관계가 필요하다는 정보를 추가하면 됨
 * 				* 객체 레퍼런스를 컨테이너로 부터 주입 받아서, 실행시에 동적으로 의존관계가 생성됨
 * 				* 컨테이너가 흐름의 주체가 되어 어플리케이션 코드에 의존관계를 주입해주는 것
 * 				* 장점 : 코드가 단순해짐, 컴포넌트간의 결합도가 제거됨	
 * 
 * #DI의 유형
 * 	1. Setter Injection 
 * 		: Setter 메서드를 이용한 의존성 삽입.
 * 	2. Constructor Injection 
 * 		: 생성자를 이용한 의존성 삽입
 * 	3. Method Injection 
 * 		: 일반 메서드를 이용한 의존성 삽입
 * 	
 * 																 <interface>			
 * 		클래스 ==== 사용 ====> 인터페이스                Hello.java ==== 사용 ===> Printer.java
 * 		 ^					 ^				 ^						^	 ^
 * 		 |					 |				 |						|	 |						
 * 	    의존성 삽입				구현			     의존성 삽입					    구현
 * 		 |					 |				 |						|	 |
 * 		 |					 |				 |					    |    | 
 * 		조립기 ===== 생성 ====> 클래스			  beans.xml =생성=> StringPrinter ConsolePrinter	
 * 		
 */
public class Hello {
	private String name;
	private Printer printer;
	
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
	
	
	public String sayHello(){
		return "Hello "+name;
	}
	
	public void print(){
		printer.print(sayHello());
	}
}
