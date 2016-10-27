<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>자료 리스트</title>
	<link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
	<div align="center">
		<h3>자료실</h3>
		<table class="button_table">
			<tr>
				<td>
					<a href="insert.do">
						<img alt="write button" src="img/btn_write.gif">
					</a>
				</td>
			</tr>
		</table>
		<table id="content_table">
			<tr>
				<th width="10%">번호</th>
				<th width="45%">제목</th>
				<th width="15%">이름</th>
				<th width="20%">작성일</th>
				<th width="10%">조회수</th>				
			</tr>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td width="10%">${dto.no }</td>
				<td width="45%" id="left_td">
					<a href="content.do?page=${curPage}&no=${dto.no }">
						${dto.subject }
					</a>
					<fmt:formatDate value="${dto.regdate }" var="regdate" pattern="yyyy-MM-dd"/>
					<c:if test="${regdate==today }">
						<sup><img src="img/icon_new (2).gif"></sup>
					</c:if>				
				</td>
				<td width="15%">${dto.name }</td>
				<td width="20%">${regdate }</td>
				<td width="10%">${dto.hit }</td>		
			</tr>
		</c:forEach>
		</table>
		<table class="button_table">
			<tr>
				<td id="right_td">
				<!-- 
					[1][2][3][4][5][6]
					fp			tp	
				 -->
			 	<a href="list.do?page=1">
			 		<img src="img/begin.gif">
			 	</a>
			 	<!-- 기본적으로는 5페이지 단위로 페이지 이동, 처음 블록과 마지막 블록에서만 1페이지씩 이동 -->
				<c:if test="${curPage>block }">
					<a href="list.do?page=${fromPage-1}">
						<img src="img/prev.gif">				 		
				 	</a>
				</c:if>	
				<c:if test="${curPage<block }">
					<a href="list.do?page=${curPage>1 ? curPage-1 : 1 }">
						<img src="img/prev.gif">				 		
				 	</a>
				</c:if>
				<c:forEach var="i" begin="${fromPage }" end="${toPage }">
				 	[
					<c:if test="${curPage==i }">
						<font color="red">
							${i }
						</font>				 	
				 	</c:if>
				 	<c:if test="${curPage!=i }">
				 		<a href="list.do?page=${i }">
				 			${i }
				 		</a>
				 	</c:if>	
				 	]
				</c:forEach>
				<c:if test="${toPage<totalPage }">
					<a href="list.do?page=${toPage+1 }">
						<img src="img/next.gif">				 		
				 	</a>
				</c:if>
				<c:if test="${toPage>=totalPage }">
					<a href="list.do?page=${curPage<totalPage ? curPage+1 : totalPage }">
						<img src="img/next.gif">				 		
				 	</a>
				</c:if>
				<a href="list.do?page=${totalPage }">
			 		<img src="img/end.gif">
			 	</a>
			 	&nbsp;
			 	${curPage }page / ${totalPage }page 
				</td>
			</tr>
		</table>
	</div>
</body>
</html>