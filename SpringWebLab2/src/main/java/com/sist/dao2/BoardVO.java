package com.sist.dao2;

import java.util.Date;

/*
 * ?? MVC (Model-View-Controller) ?��?��?�� 개념
 *	1. ?��?��?���? ?��?��?�� ?��?��
 *  2. 주목?�� : Business Logic�? Presentation Logic?�� 분리?���? ?��?��
 *  	     ?�� ?���? ?��?�� ?��?�� ?���? 고칠 ?�� ?��?�� Application?�� 만들 ?�� ?��?��
 *  3. Model 	  : Application?�� ?���? (?��?��?�� - Business Logic?�� ?��?��?��)
 *     View  	  : ?��?��?��?���? ?��공할 ?���? (Presentation Logic?�� ?��?��?��)
 *     Controller : Model�? View ?��?��?�� ?��?�� ?��?��?�� �?�? 
 *     
 *			     ?���?       ?���?처리 �?
 *				       ?��름제?�� ?��?��        ?���?
 *     Client  ?��  Controller  ?��  Model
 *     		   ?��	결과 ?��?��?���?	  ?��
 *      	       ?��?��       ?���? ?��?��?��?��	    결과
 * 					   ?��?��?���?
 * 					  View
 * 
 * ?? 각각?�� MVC 컴포?��?��?�� ?��?��
 *  1. Model 컴포?��?�� 
 *     - ?��?��?�� ???��?�� (DB)?? ?��?��?��?�� ?��?��?���? ?��?��?�� ?��?��?��?�� ?��?��?��?���? 출력?�� ?��?��?���? ?��루는 ?��?�� ?��
 *     - ?��?��개의 ?��?��?�� �?�? ?��?�� (추�?,�?�?,?��?��)?�� ?��?��?�� ?��?��?���? 묶는 ?��?��?��?��?�� ?��루는 ?��?�� ?��
 *     - DAO ?��?��?��, Service ?��?��?��?�� ?��?��
 *  
 *  2. View 컴포?��?��
 *     - 모델?�� 처리?�� ?��?��?��?�� �? ?��?�� 결과�? �?�?�? ?��?��?��?���? 출력?�� ?��면을 만드?�� ?��?�� ?��
 *     - ?��?��?�� ?��면�? ?�� 브라?��??�? 출력?���?, �? 컴포?��?��?�� HTML, CSS, Java, Script�? ?��?��?��?�� ?�� 브라?��??�? 출력?�� UI�? 만듦
 *     - HTML�? JSP�? ?��?��?��?�� ?��?��?�� ?�� ?��?��
 *  
 *  3. Controller 컴포?��?��
 *     - ?��?��?��?��?��?�� ?���??�� 받았?�� ?�� �? ?���??�� ???�� ?��?�� ?��무�?? ?��?��?��?�� 모델 컴포?��?���? ?��출하?�� ?��?�� ?��
 *     - ?��?��?��?��?���? 보낸 ?��?��?���? ?��?���? 모델?�� ?��출할 ?�� ?��?��?���? ?���? ?��?��?���? ?��?��?�� �?공하?�� ?��?�� ?�� 
 *     - 모델?�� ?���? ?��?��?�� ?��료하�? �? 결과�? �?�?�? ?��면을 ?��?��?��?���? 뷰에�? ?��?�� (?��?��?��?��?�� ?���??�� ???�� 모델�? 뷰�?? 결정?��?�� ?��?��)
 *     - Servlet�? JSP�? ?��?��?��?�� ?��?��?�� ?�� ?��?��       
 */
/*
 *  ?? 모델2 ?��?��?���? 개념
 *   모델1 ?��?��?���? : Controller ?��?��?�� JSP�? ?��?��?��
 *   모델2 ?��?��?���? : Controller ?��?��?�� Servlet?�� ?��?��?��
 *   		
 *   	             ?�� ?���?							       ?�� ?���?				            ?�� SQL
 *   Client --------> Controller Servlet  -------> Model 객체 ?���?   -------> DBMS
 *   						| |		  <-------			   <-------
 *   					?�� ?��?�� | |        결과                                             결과
 *   				       결과?���?	| |?�� ?��?��	      				          
 *   					  View JSP  ------------> VO �? 객체 
 *   								?�� 참조
 */

/*
 * ?? Front Controller ?��?��
 *  - Front Controller?�� ?��?��?��?��?���? 보낸 ?���??�� 받아?�� 공동?��?�� ?��?��?�� 먼�? ?��?��
 *  - Front Controller?�� ?��?��?�� ?���? Controller?���? ?��?��?�� ?��?��
 *  - 각각?�� ?��?��리�??��?�� Controller?�� ?��?��?��?��?��?���? 보낼 뷰�?? ?��?��?��?�� 최종결과�? ?��?��?��?�� ?��?��
 *  - Front Controller ?��?��?? ?��증이?�� 권한 체크 처럼 ?���??�� ???��?�� 공통?��?���? 처리?��?��?��?�� 로직?�� ?��?�� 경우, ?��?�� ?��체적?���? ?��?��?��?��?��?�� ?���??�� 중앙 집중?��?���? �?리하고자 ?�� 경우?�� ?��?��
 */

/*
 * ?? Spring MVC ?���?
 *  - Spring?? DI?�� AOP 같�? 기능 뿐만 ?��?��?�� ?��블릿 기반?�� ?�� 개발?�� ?��?�� MVC ?��?��?��?��?���? ?���? 
 *  - Spring MVC 모델2 ?��?��?��쳐�? Front Controller ?��?��?�� ?��?��?��?��?�� 차원?��?�� ?���?
 *  - Spring MVC ?��?��?��?��?��?�� Spring?�� 기반?���? ?���? ?���? ?��문에 Spring?�� ?��공하?�� ?��?��?��?�� 처리?�� DI �? AOP?��?�� ?��?���? ?��?�� 
 */

/* ?? Spring MVC ?? Front Controller
 *  - ??�?�? MVC ?��?��?��?��?��?��?? Front Controller ?��?��?�� ?��?��?��?�� 구현 
 *  - Spring MVC?��  Front Controller ?��?��?�� ?��?�� DispatcherServlet?��?��?�� ?��?��?���? �? ?��?��?�� ?���? ?��버로 ?��?��?��?�� 모든 ?���??�� 받아?�� 처리?��?���? 구성 
 */

/*
 * ?? DispatcherServlet Class
 *  - Front Controller ?��?�� ?��?��
 *  - web.xml?�� ?��?��
 *  - ?��?��?��?��?��로�??��?�� 모든 ?���??�� 받음 
 *  - Controller?�� View?? 같�? Spring MVC ?�� 구성?��?���? ?��?��?��?�� ?��?��?��?��?��?���? ?��비스�? ?��공함
 */

/*
 * ?? Spring MVC 주요 구성?��?��  (?���? 처리 과정)
 *  1. DispatcherServlet
 *     - ?��?��?��?��?�� ?���??�� 받아?�� Controller?���? ?��?��?��?��?��?�� ?���??�� ?��?��?���? 리턴?�� 결과값을 View?���? ?��?��?��?�� ?��맞�? ?��?��?�� ?��?��
 *  2. HandlerMapping
 *     - URI?? ?���? ?��보�?? 기�??���? ?��?�� ?��?��?�� 객체�? ?��?��?���? 결정?��?�� 객체?���? DispatcherServlet?? ?��?�� ?��?��?�� ?��?��?�� 매핑?�� �?�? ?�� ?��?��
 *  3. Controller
 *     - ?��?��?��?��?��?�� ?���??�� 처리?�� ?��, Model?�� ?��출하�? �? 결과�? DispatcherServlet?���? ?��?���? 
 *  4. ModelAndView
 *     - Controller�? 처리?�� ?��?��?�� �? ?��면에 ???�� ?��보�?? 보유?�� 객체 (Model ?��보�? View ?��보�?? ModelAndView 객체?�� ???��?��?�� 리턴?��)
 *  5. ViewResolver
 *     - Controller�? 리턴?�� �? ?��름을 기반?���? Controller처리 결과�? ?��?��?�� 뷰�?? 결정
 *  6. View
 *     - Controller?�� 처리 결과 ?��면에 ???�� ?��보�?? 보유?�� 객체 
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