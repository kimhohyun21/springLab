<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>list</title>
	<link rel="styleSheet" type="text/css" href="emp/style.css">
</head>
<body>
	<div align="center">
		<h3><a href="list.do">사원목록</a></h3>
		<table id="emplist">
			<tr>
				<th width="5%">번호</th>
				<th width="15%">이름</th>
				<th width="15%">직위</th>
				<th width="15%">입사일</th>
				<th width="15%">부서명</th>
			</tr>
		<c:forEach var="vo" items="${list }">
			<tr onclick="javascript:location.href='find.do?no=${vo.empno }'">
				<td width="5%">${vo.empno }</td>
				<td width="15%">
					${vo.ename }
				</td>
				<td width="15%">${vo.job }</td>
				<td width="15%">
					<fmt:formatDate value="${vo.hiredate }" pattern="yyyy-MM-dd"/>
				</td>
				<td width="15%">${vo.dvo.dname }</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>