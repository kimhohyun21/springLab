package com.sist.dao;

import java.util.Date;

/*
 * #Bean 등록 메타정보 구성 전략
 * 	1. XML 단독 사용
 * 		1) 모든 Bean을 명시적으로 XML에 등록하는 방법
 * 		2) 장점 
 * 			- 생성되는 모든 Bean을 XML에서 확인할 수 있음
 * 		3) 단점 
 * 			- Bean의 개수가 많아지면 XML 파일 관리의 번거로움
 * 			- 개발자간에 설정파일을 공유할 경우 ==> 충돌 발생
 * 			- DI에 필요하고 적절한 Setter 메서드 또는 Constructor가 코드 내에 반드시 존재해야함
 * 				==> 따라서, 개발 중에는 어노테이션 설정 방법 사용
 * 					             운영 중에는 관리 편의성 측면에서 XML 설정 변경 
 * 
 * 	2. XML과 빈 스캐닝(Bean Scanning)의 혼용
 * 		1) Bean으로 사용될 클래스에 특별한 어노테이션(annotation)을 부여해주면
 * 		      해당 클래스를 자동으로 찾아서 Bean으로 사용함
 * 			==> 빈 스캐닝을 통한 자동인식 Bean 등록 방식
 * 		2) 장점 
 * 			- 개발 속도 향상
 * 		3) 단점 
 * 			- 등록된 Bean간의 의존 관계 한눈에 파악하기 어려움
 * 
 * #Bean 등록 및 의존 관계 설정 annotation
 * 	1. @Component
 * 		: 컴포넌트를 나타내는 일반적인 스테레오 타입으로 <bean> 태그와 동일한 어노테이션
 * 	2. @Repository
 * 		: 퍼시스턴스 (persistance) 레이어, 영속성을 가지는 속성(파일, DB)을 가지는 어노테이션
 * 	3. @Service
 * 		: 서비스 레이어, 비지니스 로직을 가진 클래스
 * 	4. @Controller
 * 		: 프레젠테이션 레이어, 웹어플리케이션에 웹 요청과 응답을 처리하는 클래스
 * 	5. @Autowired, @Resource
 * 		: 의존 객체를 자동으로 주입해 주는 어노테이션 
 * 		1) @Autowired
 * 			- 의존 관계 주입(DI)이 필요한 경우에 유효함
 * 			- 프로퍼티, Setter메서드, 생성자, 일반메서드에 모두 적용 가능
 * 			- 의존 관계 객체를 주입할 때 주로 Type으로 이용하게 됨
 * 			- <property>, <constructor-arg> 태그와 동일한 역할
 * 		2) @Resource
 * 			- @Resource는 이름(name)으로 연결함
 * 			- 어플리케이션에서 필요로 하는 자원을 자동으로 연결할 때 사용함
 * 			- 프로퍼티, Setter 메서드에 적용 가능
 * 	6. @Value
 * 		: 단순한 값을 입력할 때, 사용하는 어노테이션
 * 		1) 형식	
 * 			: @Value("Spring")  
 * 				==> XML에서 <property.... value="Spring"/>의 역할을 함	
 * 	7. @Qualifier
 * 		: @Autowired 어노테이션과 함께 사용함
 * 			==> @Autowired Type(타입)으로 찾아서 주입하므로
 * 				동일한 타입의 Bean객체가 여러 개 존재할 때, 특정 Bean을 찾기 위해서는
 * 				@Qualifier를 같이 사용해야 함
 */		
public class EmpVO {
	private int emp;
	private String ename;
	private String job;
	private Date hiredate;
	private int sal;
	public int getEmp() {
		return emp;
	}
	public void setEmp(int emp) {
		this.emp = emp;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}	
}
