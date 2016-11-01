package com.sist.dao;
/*
 * #�������� Ư¡
 * 	1. �Ϲ� �ڹ� ��ü�� ���� => ��� => �Ҹ�
 * 		==> ������ �����ӿ�ũ���� ����(xml, ������̼� ����)
 * 			: Enterprise ������ ����, ���ϰ� �� �� �ֵ��� �������ִ� ���¼ҽ� �����ӿ�ũ
 * 			    �淮�� ���ø����̼� �����ӿ�ũ
 * 
 * 	2. java bean = DTO, VO
 * 		==> ������������ �ڹ� �� 
 * 			: ������ �����ӿ�ũ�� �����ϴ� ��� �ڹ� ��ü��
 * 			    �������Ͽ��� <bean> tag���
 * 
 * 	3. DI(Dependency Injection)����
 * 	4. AOP(Aspect Oriented Programning)����
 *  5. POJO(Plane Old Java Object : �Ϲ� �ڿ� Ŭ������, ���� JAVA ����)�� ����
 *  	==> Servlet(��ӹ��� ����� ���� Servlet Ŭ����)�� POJO�� �ƴ�
 *  6. Ʈ����� ó���� ����
 *  7. ���Ӽ� ����(�۽ý��Ͻ� ���̾�: DB���� ���̾�)�� ���õ� �پ��� API ���� �� ���� ����
 *  
 * #Spring ���� ���� 
 *  
 *  						        (Servlet �����̳� ����)
 *  		UI ����(UI ���̾�) 		  : Web MVC �����ӿ�ũ
 *  	   ==================================================
 *  								(Light Weight �����̳� ����)	
 *   		�����Ͻ� ����(�����Ͻ� ���̾�) :	Transaction ����
 *  								POJO �����ֱ� ����
 *  	   ==================================================
 *  		�۽ý��Ͻ� ����			  : DAO		| 	OR Mapping
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
