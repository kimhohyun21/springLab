package com.sist.aop;
/*
 * #원래는 핵심기능과 부가기능을 클래스를 따로 만들어야 하지만
 * 	여기서는 작동되는 원리와 흐름만 파악하기 위해
 * 	편의상 DB를 사용하지도 않고 하나의 클래스에 작성 
 */
public class MyDAO {
	/*부가(advice) 기능 ==> 로그, 트랜잭션*/
	public void getConnection(){
		System.out.println("오라클 연결");
	}
	
	/*부가(advice) 기능*/
	public void disConnection(){
		System.out.println("오라클 연결 해제");
	}
	
	
	/*핵심 로직(Target)있는 부분*/
	public void ainsert(){
		/*부가 기능
		getConnection();
		
		==> 각각의 핵심 기능에 공통으로 필요한 부가 기능을 
			직접적으로 기술하지 않고 AOP를 이용하여
			사용할 수 있도록 적용
		*/
		
		System.out.println("데이터 추가");
		
		/*부가 기능
		disConnection();*/
	}
	
	/*핵심 로직(Target)있는 부분*/
	public void aselect(String sql){
		/*부가 기능
		getConnection();*/
		
		System.out.println("SQL문장 수행");
		
		/*부가 기능
		disConnection();*/
	}
	
	/*핵심 로직(Target)있는 부분*/
	public void aupdate(){
		/*부가 기능
		getConnection();*/
		
		System.out.println("데이터 수정");
		
		/*부가 기능
		disConnection();*/
	}
	
	/*핵심 로직(Target)있는 부분*/
	public void adelete(){
		/*부가 기능
		getConnection();*/
		
		System.out.println("데이터 삭제");
		
		/*부가 기능
		disConnection();*/
	}
}
