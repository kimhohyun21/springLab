<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Main</title>
	<link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
	<div align="center">
		<table border="1" bordercolor="black" width="1000px" height="600px">
			<tr>
				<td colspan="2" height="100px">
					<tiles:insertAttribute name="header"/>
				</td>
			</tr>
			<tr>
				<td width="20%" height="400px">
					<tiles:insertAttribute name="nav"/>
				</td>
				<td  height="400px" valign="top">
					<tiles:insertAttribute name="body"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" height="100px">
					<tiles:insertAttribute name="footer"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>