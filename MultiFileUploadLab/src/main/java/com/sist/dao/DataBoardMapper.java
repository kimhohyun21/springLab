package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface DataBoardMapper {
	//리스트 불러오기
	@Select("SELECT no, subject, name, regdate, hit, num "
			+ "FROM (SELECT no, subject, name, regdate, hit, Rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit "
			+ "FROM multiBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> dataBoardListData(Map map);
	
	//전체 페이지 계산
	@Select("SELECT CEIL(COUNT(*)/10) FROM multiBoard")
	public int dataBoardTotalPage();
	
	//글쓰기
	@SelectKey(keyProperty="no", resultType=int.class, before=true,
			statement="SELECT NVL(MAX(no)+1, 1) as no FROM multiBoard")
	@Insert("INSERT INTO multiBoard VALUES(#{no}, #{name}, #{subject}, "
			+ "#{content}, #{pwd}, SYSDATE, 0, #{filename}, #{filesize}, #{filecount})")
	public void dataBoardInsert(DataBoardVO vo);
	
	//조회수 증가
	@Update("UPDATE multiBoard SET hit=hit+1 WHERE no=#{no}")
	public void dataBoardHitIncrement(int no);
	
	//글 불러오기
	@Select("SELECT no, name, subject, content, regdate, hit, filename, filesize, filecount FROM multiBoard WHERE no=#{no}")
	public DataBoardVO dataBoardContentData(int no);
	
	//패스워드 불러오기
	@Select("SELECT pwd FROM multiBoard WHERE no=#{no}")
	public String dataBoardGetPwd(int no);
	
	//파일 수정할 때 변경될 파일 데이터 불러오기
	@Select("SELECT filename, filesize, filecount FROM multiBoard WHERE no=#{no}")
	public DataBoardVO dataBoardGetDeleteFile(int no);
	
	//업데이트
	//null이 허용되는 항목에 대해서는 쿼리문에서 	지원되는 타입을 적어 줄수 있음 http://www.mybatis.org/mybatis-3/ko/sqlmap-xml.html 참고
	@Update("UPDATE multiBoard SET name=#{name}, subject=#{subject}, content=#{content}, regdate=SYSDATE, "
			+ "filename=#{filename, jdbcType=VARCHAR}, filesize=#{filesize, jdbcType=VARCHAR}, "
			+ "filecount=#{filecount, jdbcType=INTEGER} "
			+ "WHERE no=#{no}")
	public void dataBoardUpdate(DataBoardVO vo);
	
	@Delete("DELETE FROM multiboard WHERE no=#{no}")
	public void dataBoardDelete(int no);
}
