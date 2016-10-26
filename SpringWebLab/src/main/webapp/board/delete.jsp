<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>삭제하기</title>
	<link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
	<div align="center">
		<h3>삭제하기</h3>
		<form action="delete_ok.do?page=${page }&no=${no }" method="post" name="frm">
			<table id="delete_table">
				<tr>
					<th width="20%">비밀번호</th>
				</tr>
				<tr>
					<td>
						<input type="password" size="15" name="pwd">
<%-- 						<input type="hidden" name="page" value="${page }">
						<input type="hidden" name="no" value="${no }"> --%>
					</td>
				</tr>
			</table>
			<table class="button_table">
				<tr>
					<td align="center">
						<input type="submit" value="삭제">
						<input type="reset" value="취소" onclick="javascript:history.back();">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>