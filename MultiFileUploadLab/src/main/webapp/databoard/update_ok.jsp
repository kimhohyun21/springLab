<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:if test="${bCheck==false }">
	<script type="text/javascript">
		alert('��й�ȣ�� �� �� �Ǿ����ϴ�.');
		history.back();
	</script>
</c:if>
<c:if test="${bCheck==true }">
	<script type="text/javascript">
		alert('���� �Ǿ����ϴ�.');
		location.href="list.do?page=${page}";
	</script>
</c:if>