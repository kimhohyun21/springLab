package com.sist.dao;
/*
 * #MVC(Model-Controller-View) 패턴의 개념
 * 	: 아키텍처 패턴에 해당
 * 	1. 주목적 
 * 		1) Business logic과 Presentation logic을 분리하기 위함
 * 			==> 서로 영향을 받지 않고 쉽게 고칠 수 있는 어플리케이션을 만들 수 있음
 * 		2) Model : 어플리케이션의 정보 (데이터, Business logic 포함)
 * 		3) View : 사용자에게 제공할 화면 (Presentation logic)
 * 		4) Controller : Model과 View 사이의 상호 작용 관리
 * 
 * 	2. 각각의 MVC 컴포넌트의 역할
 * 		1) Model Component
 * 			- 데이터 저장소(DB)와 연동하여 사용자가 입력한 데이터나
 * 			    사용자에게 출력할 데이터를 다루는 일을 함
 * 			- 여러 개의 데이터 변경 작업(추가, 변경, 삭제)를 
 * 			    하나의 작업으로 묶는 트랜잭션을 다루는 일을 함
 * 			- DAO 클래스, Service 클래스에 해당	
 * 		2) View Component
 * 			- 모델이 처리한 데이터나 그 작업 결과를 가지고 사용자에게 출력할  화면을 만드는 일을 함
 * 			- 생성된 화면은 웹브라우저가 출력하고
 * 			    뷰 컴포넌트를 HTML, CSS, JavaScript를 사용하여
 * 			    웹브라우저가 출력할 UI를 만듬
 * 			- HTML과 JSP를 사용하여 작성할 수 있음
 * 		3) Controller Component
 * 			- 클라이언트의 요청을 받았을 때
 * 			    그 요청에 대해 실제 업무를 수행하는 모델 컴포넌트를 호출하는 일을 함
 * 			- 클라이언트가 보낸 데이터가 있다면,
 * 			    모델을 호출할 때 전달하기 쉽게 데이터를 적절히 가공하는 일을 함
 * 			- 모델이 업무 수행을 완료하면, 
 * 			    그 결과를 가지고 화면을 생성하도록 뷰에게 전달
 * 				==> 클라이언트의 요청에 대해, 모델과 뷰를 결정하여 전달
 * 			- Servlet과 JSP를 사용하여 작성할 수 있음 (Model2)
 * 	
 * #Model2 Architecture 개념
 * 	1. Model1 Architecture : Controller 역할을 JSP가 담당함
 * 	2. Model2 Architecture : Controller 역할을 Servlet이 담당함
 * 		
 * 		-----------				------------------             --------------             ---------
 * 		| 클라이언트 ㅣ	== 1)요청 ==> | < Controller > | == 2)호출 ==> | < Model > | == 3)SQL ==> | DBMS | 
 * 		|		  |	<==========	| 	       서블릿	     | <=== 결과 === |   모델 객체     | <=== 결과 ==== |      |       
 * 		-----------				-------------------			   --------------		      --------- 
 *                                    ▲    4)전달
 * 									  |	    |
 * 							6) 응답  결과 화면	▼
 * 								-------------------             ---------- 
 * 								|    < View >     | == 5)참조 ==> | < VO > |
 * 								|       JSP       |             |  값 객체    | 
 * 								------------------- 	        ----------
 * 
 * #Front Controller 패턴
 * 	1. Front Controller는 클라이언트가 보낸 요청을 받아서 공동적인 작업을 먼저 수행
 * 	2. Front Controller는 적절한 세부 Controller에게 작업을 위임
 * 	3. 각각의 어플리케이션 Controller는 클라이언트에게 보낼 뷰를 선택해서 최종결과를 생성하는 작업을 진행
 * 	4. Front Controller 패턴은 인증이나 권한 체크처럼 모든 요청에 대해여 공통적으로 
 * 	      처리해야하는 로직이 있을 경우, 전체적으로 클라이언트의 요청을 중앙 집중적으로 관리하고자 할 경우 사용.
 * 
 * #Spring MVC의 특징
 * 	1. Spring은 DI나 AOP 같은 기능 뿐만 아니라, 서블릿 기반의 웹개발을 하기 위한 MVC 프레임워크를 제공하고 있음
 * 	2. Spring MVC는 모델 2 아키텍쳐와 Front Controller 패턴을 프레임워크 차원에서 제공
 *  3. Spring MVC 프레임워크는 Spring을 기반으로 하고 있기 때문에, Spring이 제공하는 트랜잭션 처리나 
 *     DI 및 AOP 등을 손쉽게 사용
 * 
 * #Spring MVC와 Front Controller 패턴
 * 	1. 대부분 MVC 프레임워크들은 Front Controller 패턴을 적용해서 구현
 * 	2. Spring MVC도 Front Controller 역할을 하는 DispatcherServlet이라는
 * 	      클래스를 맨 앞단에 놓고, 서버로 들어오는 모든 요청을 받아서 처리하도록 구성
 * 
 * #DispatcherServlet 클래스
 * 	1. Front Controller 패턴 구성
 * 	2. web.xml에 설정
 * 	3. 클라이언트로부터의 모든 요청을 받음
 * 	4. Controller나 View와 같은 Spring MVC의 구성요소를 이용하여
 * 	      클라이언트에게 서비스를 요청
 * 
 * #Spring MVC 주요 구성요소
 * 	1. DispatcherServlet 
 * 		: 클라이언트의 요청을 받아 Controller에게 전달하고
 * 	              리턴한 결과 값을 View에게 전달하여 알맞은 응답을 생성
 * 	2. HandlerMapping 
 * 		: URI와 요청 정보를 기준으로 어떤 핸들러 객체를 사용할지 결정하는 객체 이며
 * 		  DispatcherServlet은 하나 이상의 핸들러 매핑을 가질 수 있음
 * 	3. Controller
 * 		: 클라이언트의 요청을 처리한 뒤, Model을 호출하고 
 *        다시 그 결과를 DispatcherServlet에게 알려줌
 *  4. ModelAndView 
 *  	: Controller가 처리한 데이터 및 화면에 대한 정보를 보유한 객체
 *  	  (Model 정보와 View 정보를 ModelAndView 객체에 저장하여 리턴함)
 *  5. ViewResolver
 *  	: Controller가 리턴한 뷰 이름을 기반으로 Controller 처리 결과물을 생성할 뷰를 결정
 *  6. View 
 *  	: Controller의 처리 결과 화면에 대한 정보를 보유한 객체
 * 
 */
public class BoardVO {

}
