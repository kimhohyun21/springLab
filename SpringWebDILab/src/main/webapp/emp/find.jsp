<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>�󼼺���</title>
	<link rel="styleSheet" type="text/css" href="emp/style.css">
</head>
<body>
	<div align="center">
		<h3>����� ������</h3>
		<table id="empfind">
			<tr>
				<th width="10%">��ȣ</th>
				<td width="10%">${vo.empno }</td>
				<th width="20%">�̸�</th>
				<td width="20%">${vo.ename }</td>
				<th width="20%">����</th>
				<td width="20%">${vo.job }</td>
			</tr>
			<tr>
				<th width="10%" rowspan="2">�μ���ȣ</th>
				<td width="10%" rowspan="2">${vo.dvo.deptno }</td>
				<th width="20%">�Ի���</th>
				<td width="20%">
					<fmt:formatDate value="${vo.hiredate }" pattern="yyyy-MM-dd"/>
				</td>
				<th width="20%">�޷�</th>
				<td width="20%">${vo.sal }</td>
			</tr>
			<tr>
				<th width="20%">�μ���</th>
				<td width="20%">${vo.dvo.dname }</td>
				<th width="20%">�ٹ�����</th>
				<td width="20%">${vo.dvo.loc }</td>
			</tr>
		</table>
		<input type="button" value="����Ʈ" onclick="javascript:location.href='list.do'">
	</div>
</body>
</html>