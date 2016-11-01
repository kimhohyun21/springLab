package com.sist.dao;
/*
 * #스프링의 특징
 * 	1. 일반 자바 객체의 생성 => 사용 => 소멸
 * 		==> 스프링 프레임워크에게 위임(xml, 어노테이션 설정)
 * 			: Enterprise 개발을 쉽고, 편리하게 할 수 있도록 지원해주는 오픈소스 프레임워크
 * 			    경량급 어플리케이션 프레임워크
 * 
 * 	2. java bean = DTO, VO
 * 		==> 스프링에서의 자바 빈 
 * 			: 스프링 프레임워크이 관리하는 모든 자바 객체들
 * 			    설정파일에서 <bean> tag사용
 * 
 * 	3. DI(Dependency Injection)지원
 * 	4. AOP(Aspect Oriented Programning)지원
 *  5. POJO(Plane Old Java Object : 일반 자원 클래스들, 순수 JAVA 파일)을 지원
 *  	==> Servlet(상속받은 사용자 정의 Servlet 클래스)는 POJO가 아님
 *  6. 트랜잭션 처리를 지원
 *  7. 영속성 계층(퍼시스턴스 레이어: DB관련 레이어)과 관련된 다양한 API 지원 및 연동 지원
 *  
 * #Spring 계층 구조 
 *  
 *  						        (Servlet 컨테이너 제공)
 *  		UI 계층(UI 레이어) 		  : Web MVC 프레임워크
 *  	   ==================================================
 *  								(Light Weight 컨테이너 제공)	
 *   		비지니스 계층(비지니스 레이어) :	Transaction 관리
 *  								POJO 생명주기 관리
 *  	   ==================================================
 *  		퍼시스턴스 계층			  : DAO		| 	OR Mapping
 *  	   ==================================================
 *  				 	        RDBMS
 *  
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class DataBoardDAO {
	
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> dataBoardListData(Map map){		
		return mapper.dataBoardListData(map);
	}
	
	public int dataBoardTotalPage(){
		return mapper.dataBoardTotalPage();
	}
	
	public void dataBoardInsert(DataBoardVO vo){
		mapper.dataBoardInsert(vo);
	}
	
	public DataBoardVO dataBoardContentData(int no){
		mapper.dataBoardHitIncrement(no);
		DataBoardVO vo=mapper.dataBoardContentData(no);
		return vo;
	}
	
	public DataBoardVO dataBoardUpdateData(int no){
		DataBoardVO vo=mapper.dataBoardContentData(no);
		return vo;
	}
	
	public String dataBoardGetPwd(int no){
		String pwd=mapper.dataBoardGetPwd(no);		
		return pwd;
	}
	
	public DataBoardVO dataBoardGetDeleteFile(int no){
		DataBoardVO vo=mapper.dataBoardGetDeleteFile(no);		
		return vo;
	}
	
	public void dataBoardUpdate(DataBoardVO vo){
		mapper.dataBoardUpdate(vo);
	}
	
	public void dataBoardDelete(int no){
		mapper.dataBoardDelete(no);
	}
}
