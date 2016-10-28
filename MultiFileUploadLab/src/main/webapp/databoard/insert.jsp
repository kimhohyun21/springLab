<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="table.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	var fileIndex=0;
	$(function(){
		$('#addBtn').click(function(){
			$('.fileView').append(
				'<tr id=f'+fileIndex+'>'
					+'<td widht=20%>����'+(fileIndex+1)+'</td>'
					+'<td width=80% align=left>'
						+'<input type=file name=files['+fileIndex+'] size=30>'
					+'</td>'
				+'</tr>'
			);
			fileIndex=fileIndex+1;
		});
		$('#removeBtn').click(function(){
			$('#f' +(filesize-1)).remove();
			fileIndex=fileIndex-1;
		});
	});
	
	function send(){
		var f=document.frm;
		if(f.name.value==""){
			alert("�̸��� �Է��ϼ���.");
			f.name.focus();
			return;
		}
		if(f.subject.value==""){
			alert("������ �Է��ϼ���.");
			f.subject.focus();
			return;
		}
		if(f.content.value==""){
			alert("������ �Է��ϼ���.");
			f.content.focus();
			return;
		}
		if(f.pwd.value==""){
			alert("��й�ȣ�� �Է��ϼ���.");
			f.pwd.focus();
			return;
		}
		f.submit();
	}
</script>
</head>
<body>
	<center>
		<h3>�۾���</h3>
		<form:form method="post" action="insert_ok.do" name="frm"
			enctype="multipart/form-data"
			modelAttribute="uploadForm">
			<table width="700" id="table_content">
				<tr height="27">
					<td width="20%" align="center">�̸�</td>
					<td width="80%" align="left">
						<input type="text" size="10" name="name">
					</td>
				</tr>
				
				<tr height="27">
					<td width="20%" align="center">����</td>
					<td width="80%" align="left">
						<input type="text" size="45" name="subject">
					</td>
				</tr>
				
				<tr height="27">
					<td width="20%" align="center">����</td>
					<td width="80" align="left">
						<textarea rows="8" cols="46" name="content"></textarea>
					</td>
				</tr>
				
				<tr>
					<td width="20%" align="center">÷������</td>
					<td width="80%" align="left">
						<table id="table_cotent" width="560">
							<tr>
								<td colspan="2" align="right">
									<input type="button" value="�߰�" id="addBtn">
									<input type="button" value="���" id="removeBtn">
								</td>
							</tr>
						</table>
						<table id="table_content" width="560" class="fileView">
						</table>
					</td>
				</tr>
				<tr height="27">
					<td width="20%" align="center">��й�ȣ</td>
					<td width="80%" align="left">		
						<input type="password" size="10" name="pwd">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="�۾���" onclick="send()">
						<input type="button" value="���" onclick="javascipt:history.back()">
					</td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>
























