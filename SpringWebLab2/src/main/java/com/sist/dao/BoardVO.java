package com.sist.dao;

import java.util.Date;

/*
 * ※ MVC (Model-View-Controller) 패턴의 개념
 *	1. 아키텍쳐 패턴에 해당
 *  2. 주목적 : Business Logic과 Presentation Logic을 분리하기 위함
 *  	     → 서로 영향 없이 쉽게 고칠 수 있는 Application을 만들 수 있음
 *  3. Model 	  : Application의 정보 (데이터 - Business Logic이 포함됨)
 *     View  	  : 사용자에게 제공할 화면 (Presentation Logic에 해당됨)
 *     Controller : Model과 View 사이의 상호 작용을 관리 
 *     
 *			     요청       요청처리 및
 *				       흐름제어 담당        호출
 *     Client  →  Controller  →  Model
 *     		   ←	결과 ↑↓화면	  ←
 *      	       응답       화면 ↑↓생성	    결과
 * 					   ↑↓요청
 * 					  View
 * 
 * ※ 각각의 MVC 컴포넌트의 역할
 *  1. Model 컴포넌트 
 *     - 데이터 저장소 (DB)와 연동하여 사용자가 입력한 데이터나 사용자에게 출력할 데이터를 다루는 일을 함
 *     - 여러개의 데이터 변경 작업 (추가,변경,삭제)을 하나의 작업으로 묶는 트랜잭션을 다루는 일을 함
 *     - DAO 클래스, Service 클래스에 해당
 *  
 *  2. View 컴포넌트
 *     - 모델이 처리한 데이터나 그 작업 결과를 가지고 사용자에게 출력할 화면을 만드는 일을 함
 *     - 생성된 화면은 웹 브라우저가 출력하고, 뷰 컴포넌트는 HTML, CSS, Java, Script를 사용하여 웹 브라우저가 출력할 UI를 만듦
 *     - HTML과 JSP를 사용하여 작성할 수 있음
 *  
 *  3. Controller 컴포넌트
 *     - 클라이언트의 요청을 받았을 때 그 요청에 대해 실제 업무를 수행하는 모델 컴포넌트를 호출하는 일을 함
 *     - 클라이언트가 보낸 데이터가 있다면 모델을 호출할 때 전달하기 쉽게 데이터를 적절히 가공하는 일을 함 
 *     - 모델이 업무 수행을 완료하면 그 결과를 가지고 화면을 생성하도록 뷰에게 전달 (클라이언트 요청에 대해 모델과 뷰를 결정하여 전달)
 *     - Servlet과 JSP를 사용하여 작성할 수 있음       
 */
/*
 *  ※ 모델2 아키텍쳐 개념
 *   모델1 아키텍쳐 : Controller 역할을 JSP가 담당함
 *   모델2 아키텍쳐 : Controller 역할을 Servlet이 담당함
 *   		
 *   	             ① 요청							       ② 호출				            ③ SQL
 *   Client --------> Controller Servlet  -------> Model 객체 호출   -------> DBMS
 *   						| |		  <-------			   <-------
 *   					⑥ 응답 | |        결과                                             결과
 *   				       결과화면	| |④ 전달	      				          
 *   					  View JSP  ------------> VO 값 객체 
 *   								⑤ 참조
 */

/*
 * ※ Front Controller 패턴
 *  - Front Controller는 클라이언트가 보낸 요청을 받아서 공동적인 작업을 먼저 수행
 *  - Front Controller는 적절한 세부 Controller에게 작업을 위임
 *  - 각각의 애플리케이션 Controller는 클라이언트에게 보낼 뷰를 선택해서 최종결과를 생성하는 작업
 *  - Front Controller 패턴은 인증이나 권한 체크 처럼 요청에 대하여 공통적으로 처리해야하는 로직이 있을 경우, 또는 전체적으로 클라이언트의 요청을 중앙 집중적으로 관리하고자 할 경우에 사용
 */

/*
 * ※ Spring MVC 특징
 *  - Spring은 DI나 AOP 같은 기능 뿐만 아니라 서블릿 기반의 웹 개발을 위한 MVC 프레임워크를 제공 
 *  - Spring MVC 모델2 아키텍쳐와 Front Controller 패턴을 프레임워크 차원에서 제공
 *  - Spring MVC 프레임워크는 Spring을 기반으로 하고 있기 때문에 Spring이 제공하는 트랜잭션 처리나 DI 및 AOP등을 손쉽게 사용 
 */

/* ※ Spring MVC 와 Front Controller
 *  - 대부분 MVC 프레임워크들은 Front Controller 패턴을 적용해서 구현 
 *  - Spring MVC도  Front Controller 역할을 하는 DispatcherServlet이라는 클래스를 맨 앞단에 놓고 서버로 들어오는 모든 요청을 받아서 처리하도록 구성 
 */

/*
 * ※ DispatcherServlet Class
 *  - Front Controller 패턴 적용
 *  - web.xml에 설정
 *  - 클라이언트로부터의 모든 요청을 받음 
 *  - Controller나 View와 같은 Spring MVC 의 구성요소를 이용하여 클라이언트에게 서비스를 제공함
 */

/*
 * ※ Spring MVC 주요 구성요소  (요청 처리 과정)
 *  1. DispatcherServlet
 *     - 클라이언트 요청을 받아서 Controller에게 클라이언트의 요청을 전달하고 리턴한 결과값을 View에게 전달하여 알맞은 응답을 생성
 *  2. HandlerMapping
 *     - URI와 요청 정보를 기준으로 어떤 핸들러 객체를 사용할지 결정하는 객체이며 DispatcherServlet은 하나 이상의 핸들러 매핑을 가질 수 있음
 *  3. Controller
 *     - 클라이언트의 요청을 처리한 뒤, Model을 호출하고 그 결과를 DispatcherServlet에게 알려줌 
 *  4. ModelAndView
 *     - Controller가 처리한 데이터 및 화면에 대한 정보를 보유한 객체 (Model 정보와 View 정보를 ModelAndView 객체에 저장해서 리턴함)
 *  5. ViewResolver
 *     - Controller가 리턴한 뷰 이름을 기반으로 Controller처리 결과를 생성할 뷰를 결정
 *  6. View
 *     - Controller의 처리 결과 화면에 대한 정보를 보유한 객체 
 */

public class BoardVO {
	private int no;
	private String name;
	private String email;
	private String subject;
	private String content;
	private Date regdate;
	private String pwd;
	private int hit;

	private int group_id;
	private int group_setp;
	private int group_tab;

	private int root;
	private int depth;
	private String msg;

	private String today;
	private String dbday;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public int getGroup_setp() {
		return group_setp;
	}
	public void setGroup_setp(int group_setp) {
		this.group_setp = group_setp;
	}
	public int getGroup_tab() {
		return group_tab;
	}
	public void setGroup_tab(int group_tab) {
		this.group_tab = group_tab;
	}
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getDbday() {
		return dbday;
	}
	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
}
