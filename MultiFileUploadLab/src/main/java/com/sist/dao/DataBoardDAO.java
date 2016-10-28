package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> databoardListData(Map map){
		return mapper.dataBoardListData(map);
	}
	public int databoardTotalPage(){
		return mapper.dataBoardTotalPage();
	}
	
	public void databoardInsert(DataBoardVO vo){
		mapper.dataBoardInsert(vo);
	}
}
