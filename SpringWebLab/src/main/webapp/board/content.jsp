<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>상세보기</title>
	<link rel="stylesheet" type="text/css" href="board/table.css">
</head>
<body>
	<h3 id="title">내용보기</h3>
	<div align="center">
		<table id="content_table">
			<tr class="cont_tr">
				<th width="25%">번호</th>
				<td width="25%">${vo.no }</td>
				<th width="25%">작성일</th>
				<td width="25%">
					<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr class="cont_tr">
				<th width="25%">이름</th>
				<td width="25%">${vo.name }</td>
				<th width="25%">조회수</th>
				<td width="25%">${vo.hit }</td>
			</tr>
			<tr class="cont_tr">
				<th width="25%">제목</th>
				<td colspan="3" id="left_td">${vo.subject }</td>
			</tr>
			<tr class="cont_tr">
				<td colspan="4" id="cont">
					<pre>${vo.content }</pre>
				<td>
			</tr>
		</table>
		<table class="button_table">
			<tr>
				<td id="right_td">
					<a href="list.do?page=${page }">
						<img alt="list button" src="board/img/btn_list.gif">
					</a>
					<a href="reply.do?page=${page }&no=${dto.no }">
						<!-- 
							reply.do ==request==> DispatcherServlet(controller)
									 ===========> ReplyModel(처리)
									 ===========> DispatcherServlet(controller)
									 ==response=> jsp(view)
						 -->
						<img alt="reply button" src="board/img/btn_reply.gif">
					</a>
					<a href="modify.do?page=${page }&no=${dto.no }">
						<img alt="modify button" src="board/img/btn_modify.gif">
					</a>
					<a href="delete.do?page=${page }&no=${dto.no }">
						<img alt="delete button" src="board/img/btn_delete.gif">
					</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>