<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>글쓰기</title>
	<link rel="stylesheet" type="text/css" href="table.css">
	<script type="text/javascript">
		function enter(){
			if(event.keyCode==13){
				send();	
			}
		};
	
		function send(){			
			//계층구조 : window ==> document ==> form ==> input
			var f=document.frm;
			if(f.name.value==""){
				alert('이름을 입력해주세요.');
				f.name.focus();
				return;
			}
			if(f.subject.value==""){
				alert('제목을 입력해주세요.');
				f.subject.focus();
				return;
			}
			if(f.content.value==""){
				alert('내용을 입력해주세요.');
				f.content.focus();
				return;
			}
			if(f.pwd.value==""){
				alert('비밀번호를 입력해주세요.');
				f.pwd.focus();
				return;
			}
			f.submit();
		}; 
	</script>
</head>
<body>
	<div align="center">
		<h3>글쓰기</h3>
		<form action="insert_ok.do" method="post" name="frm">
			<table id="insert_table">
				<tr>
					<th width="20%">이름</th>
					<td>
						<input type="text" size="15" name="name" onkeydown="enter()">
					</td>
				</tr>
				<tr>
					<th width="20%">이메일</th>
					<td>
						<input type="text" size="50px" name="email" onkeydown="enter()">
					</td>
				</tr>
				<tr>
					<th width="20%">제목</th>
					<td>
						<input type="text" size="50" name="subject" onkeydown="enter()">
					</td>
				</tr>
				<tr>
					<th width="20%">내용</th>
					<td>
						<textArea cols="52" rows="10" name="content"></textArea>
					</td>
				</tr>
				<tr>
					<th width="20%">비밀번호</th>
					<td>
						<input type="password" size="15px" name="pwd" onkeydown="enter()">
					</td>
				</tr>
			</table>
			<table class="button_table">
				<tr>
					<td align="center">
						<input type="button" value="글쓰기" onclick="send()">
						<input type="reset" value="취소" onclick="javascript:history.back()">
					</td>
				</tr>
			</table>	
		</form>
	</div>
</body>
</html>