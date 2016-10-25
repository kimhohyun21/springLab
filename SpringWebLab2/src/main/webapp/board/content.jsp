<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
	<center>
		<h1>내용보기</h1>
		<hr width="610" />
		<table width="600" border="0" id="table_content">
			<tr height="27">
				<th width="20%">번호</th>
				<td width="30%" align="center" class="tdcenter">${vo.no }</td>
				<th width="20%">작성일</th>
				<td width="30%" align="center" class="tdcenter">${vo.regdate }</td>
			</tr>
			<tr height="27">
				<th width="20%">작성자</th>
				<td width="30%" align="center" class="tdcenter">${vo.name }</td>
				<th width="20%">조회수</th>
				<td width="30%" align="center" class="tdcenter">${vo.hit }</td>
			</tr>
			<tr height="27">
				<th width="20%">제목</th>
				<td width="30%" align="left" colspan="3" class="tdleft">&nbsp;&nbsp;${vo.subject }</td>
			</tr>
			<tr>
				<td colspan="4" align="left" valign="top" height="200"
					class="tdleft"><pre>${vo.content }</pre></td>
			</tr>
		</table>
		<table width="600" border="0">
			<tr>
				<td align="right">
				<a href="reply.do?no=${vo.no }&page=${page}">
					<img alt="reply" src="image/btn_reply.gif">
				</a> 
				<a href="update.do?no=${vo.no}">
					<img alt="modify" src="image/btn_modify.gif">
				</a> 
				<a href="delete.do?no=${vo.no }&page=${page}"> 
					<img alt="delete" src="image/btn_delete.gif">
				</a> 
				<a href="list.do?page=${page}"> 
					<img alt="list" src="image/btn_list.gif">
				</a>
				<td>
			</tr>
		</table>
	</center>
</body>
</html>