package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface DataBoardMapper {
	//����Ʈ �ҷ�����
	@Select("SELECT no, subject, name, regdate, hit, num "
			+ "FROM (SELECT no, subject, name, regdate, hit, Rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit "
			+ "FROM multiBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> dataBoardListData(Map map);
	
	//��ü ������ ���
	@Select("SELECT CEIL(COUNT(*)/10) FROM multiBoard")
	public int dataBoardTotalPage();
	
	//�۾���
	@SelectKey(keyProperty="no", resultType=int.class, before=true,
			statement="SELECT NVL(MAX(no)+1, 1) as no FROM multiBoard")
	@Insert("INSERT INTO multiBoard VALUES(#{no}, #{name}, #{subject}, "
			+ "#{content}, #{pwd}, SYSDATE, 0, #{filename}, #{filesize}, #{filecount})")
	public void dataBoardInsert(DataBoardVO vo);
	
	//��ȸ�� ����
	@Update("UPDATE multiBoard SET hit=hit+1 WHERE no=#{no}")
	public void dataBoardHitIncrement(int no);
	
	//�� �ҷ�����
	@Select("SELECT no, name, subject, content, regdate, hit, filename, filesize, filecount FROM multiBoard WHERE no=#{no}")
	public DataBoardVO dataBoardContentData(int no);
	
	//�н����� �ҷ�����
	@Select("SELECT pwd FROM multiBoard WHERE no=#{no}")
	public String dataBoardGetPwd(int no);
	
	//���� ������ �� ����� ���� ������ �ҷ�����
	@Select("SELECT filename, filesize, filecount FROM multiBoard WHERE no=#{no}")
	public DataBoardVO dataBoardGetDeleteFile(int no);
	
	//������Ʈ
	//null�� ���Ǵ� �׸� ���ؼ��� ���������� 	�����Ǵ� Ÿ���� ���� �ټ� ���� http://www.mybatis.org/mybatis-3/ko/sqlmap-xml.html ����
	@Update("UPDATE multiBoard SET name=#{name}, subject=#{subject}, content=#{content}, regdate=SYSDATE, "
			+ "filename=#{filename, jdbcType=VARCHAR}, filesize=#{filesize, jdbcType=VARCHAR}, "
			+ "filecount=#{filecount, jdbcType=INTEGER} "
			+ "WHERE no=#{no}")
	public void dataBoardUpdate(DataBoardVO vo);
	
	@Delete("DELETE FROM multiboard WHERE no=#{no}")
	public void dataBoardDelete(int no);
}
