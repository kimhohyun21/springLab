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
		// ��������(Tree����) : window �� document �� form �� input tag ...
		var f = document.form;
		if (f.name.value == "") {
			alert('�̸��� �Է��ϼ���');
			f.name.focus();
			return;
		}
		if (f.subject.value == "") {
			alert('������ �Է��ϼ���');
			f.subject.focus();
			return;
		}
		if (f.content.value == "") {
			alert('������ �Է��ϼ���');
			f.content.focus();
			return;
		}
		if (f.pwd.value == "") {
			alert('��й�ȣ�� �Է��ϼ���');
			f.pwd.focus();
			return;
		}
		f.submit();
	};
</script>
</head>
<body>
	<center>
		<h1 id="title">�۾���</h1>
		<form action="insert_ok.do" method="post" name="form">
			<table width="600" id="table_content">
				<tr height="27">
					<td width="30%" align="center" class="thcenter">�̸�</td>
					<td width="70%" align="left" class="tdleft">
					<input type="text" size="20" name="name" id="name" /></td>
				</tr>
				<tr height="27">
					<td width="30%" align="center" class="thcenter">�̸���</td>
					<td width="70%" align="left" class="tdleft">
					<input type="text" size="20" name="eamil" id="email" /></td>
				</tr>
				<tr height="27">
					<td width="30%" align="center" class="thcenter">����</td>
					<td width="70%" align="left" class="tdleft">
					<input type="text" size="50" name="subject" id="subject" /></td>
				</tr>
				<tr height="27">
					<td width="30%" align="center" class="thcenter">����</td>
					<td width="70%" align="left" class="tdleft">
					<textarea rows="8" cols="70" name="content" id="content"></textarea></td>
				</tr>
				<tr height="27">
					<td width="30%" align="center" class="thcenter">��й�ȣ</td>
					<td width="70%" align="left" class="tdleft">
					<input type="password" size="20" name="pwd" id="pwd" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="button" value="�۾���" onclick="send()" /> 
					<input type="button" value="���" onclick="javascript:history.back()" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>