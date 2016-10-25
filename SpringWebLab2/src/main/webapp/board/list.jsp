<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Spring MVC Board Lab</title>
<link rel="stylesheet" type="text/css" href="table.css"/>
</head>
<body>
	<center>
		<h1>BOARD</h1>
		<hr width="610" />
		<table border="0" width="600">
			<tr>
				<td align="left"><a href="insert.do">
				<img alt="글쓰기" src="image/btn_write.gif" border="0"></a></td>
			</tr>
		</table>
		<br />
		<table id="table_content" width="600">
			<tr>
				<th width="10%">No</th>
				<th width="45%">Subject</th>
				<th width="15%">Name</th>
				<th width="20%">Date</th>
				<th width="10%">Hit</th>
			</tr>

			<c:forEach var="vo" items="${list }">
				<tr class="dataTr">
					<td width="10%" class="tdcenter" align="center">${vo.no }</td>
					<td width="45%" class="tdleft" align="left">
						<!-- group_tab : 몇번째 단계의 답변인지 나타내는 컬럼 --> <c:if
							test="${vo.group_tab>0 }">
							<c:forEach var="i" begin="1" end="${vo.group_tab }">
								&nbsp;&nbsp;
							</c:forEach>
							<img alt="reply" src="image/icon_reply.gif">
						</c:if> <c:if test="${msg == vo.subject }">
							<font color="red">${vo.subject }</font>
							<!-- 관리자에 의해 삭제된 경우 -->
						</c:if> <c:if test="${msg != vo.subject }">
							<a href="content.do?no=${vo.no }&page=${curpage}">${vo.subject }</a>
						</c:if> <c:if test="${today == vo.dbday }">
							<img alt="" src="image/icon_new (2).gif">
						</c:if>
					</td>
					<td width="15%" class="tdcenter" align="center">${vo.name }</td>
					<td width="20%" class="tdcenter" align="center">
						<fmt:formatDate value="${vo.regdate }" patten="yyyy-MM-dd"/>
					</td>
					<td width="10%" class="tdcenter" align="center">${vo.hit }</td>
				</tr>
			</c:forEach>
		</table>
		
		<table border="0" width="600">
			<tr>
				<td align="right">
					<!-- [1][2][3][4][5]
					  ↑frompage   ↑topage
				 --> <c:if test="${curpage <= block }">
						<a href="list.do?page=1"> <img alt="begin"
							src="image/begin.gif" border="0">
						</a>
						<a href="list.do?page=${curpage>1? curpage-1 : curpage}"> <img
							alt="prev" src="image/prev.gif" border="0">
						</a>
					</c:if> <c:if test="${curpage > block }">
						<a href="list.do?page=1"> <img alt="begin"
							src="image/begin.gif" border="0">
						</a>
						<a href="list.do?page=${frompage-1}"> <img alt="prev"
							src="image/prev.gif" border="0">
						</a>
					</c:if> <c:forEach var="i" begin="${frompage }" end="${topage }">
					[
					<c:if test="${curpage==i }">
							<span style="color: red;">${i }</span>
						</c:if>
						<c:if test="${curpage!=i }">
							<a href="list.do?page=${i }">${i }</a>
						</c:if>
					]
				</c:forEach> <c:if test="${topage < totalpage }">
						<a href="list.do?page=${topage+1 }"> <img alt="next"
							src="image/next.gif" border="0">
						</a>
						<a href="list.do?page=${totalpage }"> <img alt="end"
							src="image/end.gif">
						</a>
					</c:if> <c:if test="${topage >= totalpage }">
						<a href="list.do?page=${curpage<totalpage? curpage+1 : curpage }">
							<img alt="next" src="image/next.gif" border="0">
						</a>
						<a href="list.do?page=${totalpage }"> <img alt="end"
							src="image/end.gif">
						</a>
					</c:if> &nbsp;&nbsp; ${curpage } page / ${totalpage } pages
				</td>
			</tr>
		</table>
	</center>
</body>
</html>