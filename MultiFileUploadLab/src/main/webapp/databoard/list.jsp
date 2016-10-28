<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
	<center>
		<h3>자료실</h3>
		<table border="0" width="700">
			<tr>
				<td align="left">
					<a href="insert.do">글쓰기</a>
				</td>
			</tr>
		</table>
		<table id="table_content" width="700">
			<tr>
				<th width="10%">번호</th>
				<th width="45%">제목</th>
				<th width="15%">이름</th>
				<th width="20%">작성일</th>
				<th width="10%">조회수</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr id="dataTr">
					<td width="10%" align="center">${vo.no }</td>
					<td width="45%" align="left">
						<a href="content.do?no=${vo.no }">${vo.subject }</a>
					</td>
					<td width="15%" align="center">${vo.name }</td>
					<td width="20%" align="center">
						<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
					</td>
					<td width="10%" align="center">${vo.hit }</td>
				</tr>
			</c:forEach>	
		</table>
		<table border="0" width="700">
			<tr>
				<td align="right">
					<a href="list.do?page=${curpage>1?curpage-1:curpage}">이전</a>&nbsp;
					<a href="list.do?page=${curpage<totalpage?curpage+1:curpage}">다음</a>&nbsp;&nbsp;
					${curpage } page / ${totalpage } pages
				</td>
			</tr>
		</table>
	</center>
</body>
</html>


































