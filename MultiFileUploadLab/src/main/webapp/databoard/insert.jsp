<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>�۾���</title>
	<link rel="stylesheet" type="text/css" href="table.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript">
		function enter(){
			if(event.keyCode==13){
				send();	
			}
		};
		
		function send(){			
			//�������� : window ==> document ==> form ==> input
			var f=document.frm;
			if(f.name.value==""){
				alert('�̸��� �Է����ּ���.');
				f.name.focus();
				return;
			}
			if(f.subject.value==""){
				alert('������ �Է����ּ���.');
				f.subject.focus();
				return;
			}
			if(f.content.value==""){
				alert('������ �Է����ּ���.');
				f.content.focus();
				return;
			}
			if(f.pwd.value==""){
				alert('��й�ȣ�� �Է����ּ���.');
				f.pwd.focus();
				return;
			}
			f.submit();
		}; 
		
		var fileIndex=0;
		$(function(){
			$('#addBtn').click(function(){
				$('.fileView').append(
						
				);			
			});
		});
	</script>
</head>
<body>
	<div align="center">
		<h3>�۾���</h3>
		<form:form action="insert_ok.do" method="post" name="frm" id="frm"
			enctype="multipart/form-data" modelAttribute="uploadForm">
			<table id="insert_table">
				<tr>
					<th width="20%">�̸�</th>
					<td>
						<input type="text" size="15" name="name" id="name" onkeydown="enter()">
					</td>
				</tr>
				<tr>
					<th width="20%">����</th>
					<td>
						<input type="text" size="50" name="subject" id="subject" onkeydown="enter()">
					</td>
				</tr>
				<tr>
					<th width="20%">����</th>
					<td>
						<textArea cols="52" rows="10" name="content" id="content"></textArea>
					</td>
				</tr>
				<tr>
					<th width="20%">÷������</th>
					<td>
						<table>
							<tr>
								<td>
									<input type="button" value="�߰�" id="addBtn">
									<input type="reset" value="���" id="removeBtn">
								</td>
							</tr>
						</table>
						<table class="fileView">
							
						</table>
					</td>
				</tr>
				<tr>
					<th width="20%">��й�ȣ</th>
					<td>
						<input type="password" size="15px" name="pwd" onkeydown="enter()">
					</td>
				</tr>
			</table>
			<table class="button_table">
				<tr>
					<td align="center">
						<input type="button" value="�۾���" onclick="send()">
						<input type="reset" value="���" onclick="javascript:history.back()">
					</td>
				</tr>
			</table>	
		</form:form>
	</div>
</body>
</html>