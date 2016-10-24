package com.sist.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.dao.*;

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
}
