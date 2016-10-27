package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Select;

public interface DataBoardMapper {
	
	@Select("SELECT no, subject, name, regdate, hit, num "
			+ "FROM (SELECT no, subject, name, regdate, hit, Rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit "
			+ "FROM multiBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> dataBoardListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10) FROM multiBoard")
	public int dataBoardTotalPage();
}
