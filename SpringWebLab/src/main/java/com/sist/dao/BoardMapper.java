package com.sist.dao;

import java.util.*;
import org.apache.ibatis.annotations.Select;

public interface BoardMapper {
	@Select("SELECT no, name, subject, regdate, hit, group_tab, TO_CHAR(regdate, 'YYYY-mm-DD'), num "
			+ "FROM (SELECT no, name, subject, regdate, hit, group_tab, ROWNUM as num "
			+ "FROM (SELECT no, name, subject, regdate, hit, group_tab "
			+ "FROM board ORDER BY group_id DESC, group_step ASC))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10) FROM board")
	public int boardTotalPage();
}
