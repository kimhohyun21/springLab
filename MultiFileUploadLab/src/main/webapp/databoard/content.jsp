<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>상세보기</title>
	<link rel="stylesheet" type="text/css" href="databoard/table.css">
</head>
<body>
	<div align="center">
		<h3>상세 보기</h3>
		<table id="content_table">
			<tr class="cont_tr">
				<th width="20%">번호</th>
				<td width="30%">${vo.no }</td>
				<th width="20%">작성일</th>
				<fmt:formatDate var="regdate" value="${vo.regdate }" pattern="yyyy-MM-dd"/>
				<td width="30%">${regdate }</td>
			</tr>
			<tr class="cont_tr">
				<th width="20%">이름</th>
				<td width="30%">${vo.name }</td>
				<th width="20%">조회수</th>
				<td width="30%">${vo.hit }</td>
			</tr>
			<tr class="cont_tr">
				<th width="20%">제목</th>
				<td id="left_td" colspan="3">${vo.subject }</td>
			</tr>
			<tr class="cont_tr">
				<th width="20%">첨부파일</th>
				<td id="left_td" colspan="3">
			<c:if test="${vo.filecount!=0 }">				
				<c:forEach var="file" items="${vo.nameList }">
						<a href="download.do?fn=${file }">${file }</a>&nbsp;
				</c:forEach>
			</c:if>		
				</td>
			</tr>
			<tr class="cont_tr">
				<td id="cont" colspan="4">${vo.content }</td>
			</tr>
		</table>
		<table class="button_table">
			<tr>
				<td id="right_td">
					<a href="list.do?page=${page }">
						<img alt="list button" src="databoard/img/btn_list.gif">
					</a>
					<a href="update.do?page=${page }&no=${vo.no }">
						<img alt="update button" src="databoard/img/btn_modify.gif">
					</a>
					<a href="delete.do?page=${page }&no=${vo.no }">
						<img alt="delete button" src="databoard/img/btn_delete.gif">
					</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>