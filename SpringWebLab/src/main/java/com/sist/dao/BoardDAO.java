package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> boardListData(Map map){
		return mapper.boardListData(map);
	}
	
	public int boardTotalPage(){
		return mapper.boardTotalPage();
	}
	
	public void boardInsert(BoardVO vo){
		mapper.boardInsert(vo);
	}
	
	public BoardVO boardContent(String no){
		mapper.boardHitIncrement(no);
		return mapper.boardContentData(no);
	}
	
	public BoardVO boardUpdate(int no){
		return mapper.boardUpdate(no);
	}
	
	public Boolean boardUpdatedata(BoardVO vo){
		boolean bCheck=false;
		String db_pwd=mapper.boardGetPwd(vo.getNo());
		if(db_pwd.equals(vo.getPwd())){
			mapper.boardUpdateData(vo);
			bCheck=true;
		}		
		return bCheck;
	}
}
