package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

public interface BoardMapper {
	@Select("SELECT no, name, subject, regdate, hit, group_tab, num "
			+ "FROM (SELECT no, name, subject, regdate, hit, group_tab, ROWNUM as num "
			+ "FROM (SELECT no, name, subject, regdate, hit, group_tab "
			+ "FROM replyBoard ORDER BY group_id DESC, group_step ASC))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10) FROM board")
	public int boardTotalPage();
	
	@SelectKey(keyProperty="no", resultType=int.class, before=true, 
				statement="SELECT NVL(MAX(no)+1, 1) as no FROM replyBoard")
	@Insert("INSERT INTO replyBoard (no, name, email, subject, content, pwd, group_id) "
			+ "VALUES(#{no}, #{name}, #{email}, #{subject}, #{content}, #{pwd},"
			+ "(SELECT NVL(MAX(group_id)+1, 1) as group_id FROM replyBoard))")
	public void boardInsert(BoardVO vo);
}
