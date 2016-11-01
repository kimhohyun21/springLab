<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${bCheck==false }">
	<script>
		alert('비밀번호가 잘 못 되었습니다.');
		history.back();
	</script>
</c:if>
<c:if test="${bCheck==true }">
	<script>
		alert('삭제 되었습니다.');
		location.href="list.do?page=${page }";
	</script>
</c:if>