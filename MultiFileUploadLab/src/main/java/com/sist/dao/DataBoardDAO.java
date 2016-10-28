package com.sist.dao;

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
}
