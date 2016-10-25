<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="table.css" />
<script type="text/javascript">
	function send() {
		// 계층구조(Tree구조) : window → document → form → input tag ...
		var f = document.form;
		if (f.name.value == "") {
			alert('이름을 입력하세요');
			f.name.focus();
			return;
		}
		if (f.subject.value == "") {
			alert('제목을 입력하세요');
			f.subject.focus();
			return;
		}
		if (f.content.value == "") {
			alert('내용을 입력하세요');
			f.content.focus();
			return;
		}
		if (f.pwd.value == "") {
			alert('비밀번호를 입력하세요');
			f.pwd.focus();
			return;
		}
		f.submit();
	};
</script>
</head>
<body>
	<center>
		<h1 id="title">글쓰기</h1>
		<form action="insert_ok.do" method="post" name="form">
			<table width="600" id="table_content">
				<tr height="27">
					<td width="30%" align="center" class="thcenter">이름</td>
					<td width="70%" align="left" class="tdleft">
					<input type="text" size="20" name="name" id="name" /></td>
				</tr>
				<tr height="27">
					<td width="30%" align="center" class="thcenter">이메일</td>
					<td width="70%" align="left" class="tdleft">
					<input type="text" size="20" name="eamil" id="email" /></td>
				</tr>
				<tr height="27">
					<td width="30%" align="center" class="thcenter">제목</td>
					<td width="70%" align="left" class="tdleft">
					<input type="text" size="50" name="subject" id="subject" /></td>
				</tr>
				<tr height="27">
					<td width="30%" align="center" class="thcenter">내용</td>
					<td width="70%" align="left" class="tdleft">
					<textarea rows="8" cols="70" name="content" id="content"></textarea></td>
				</tr>
				<tr height="27">
					<td width="30%" align="center" class="thcenter">비밀번호</td>
					<td width="70%" align="left" class="tdleft">
					<input type="password" size="20" name="pwd" id="pwd" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="button" value="글쓰기" onclick="send()" /> 
					<input type="button" value="취소" onclick="javascript:history.back()" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>