<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>수정하기</title>
	<link rel="stylesheet" type="text/css" href="table.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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
		
		var fileIndex=0;
		$(function(){
			$('#addBtn').click(function(){
				$('.fileView').append(
					'<tr id=f'+fileIndex+'>'
					+"<td width=20% align=center style='border-bottom: 0px;'>파일"+(fileIndex+1)+"</td>"
					+"<td width=80% style='border-bottom: 0px;'>"
					+'<input type=file name=files['+fileIndex+'] size=30>'
					+'</td>'
					+'</tr>'
				);
				fileIndex=fileIndex+1;
			});
			
			$('#removeBtn').click(function(){
				/*추가하면서 마지막으로 fileIndex가 +1이 되어 있기 때문에 마지막 객체는 fileIndex-1*/
				$('#f'+(fileIndex-1)).remove();
				fileIndex=fileIndex-1;
			});
		});
	</script>
</head>
<body>
	<div align="center">
		<h3>수정하기</h3>
		<form:form action="update_ok.do" method="post" name="frm"
			enctype="multipart/form-data" modelAttribute="uploadForm">
			<table id="insert_table">
				<tr>
					<th width="20%">이름</th>
					<td>
						<input type="text" size="15" name="name" value="${vo.name }" onkeydown="enter()">
						<input type="hidden" name="page" value="${page }">
						<input type="hidden" name="no" value="${vo.no }">
					</td>
				</tr>
				<tr>
					<th width="20%">제목</th>
					<td>
						<input type="text" size="50" name="subject" value="${vo.subject }" onkeydown="enter()">
					</td>
				</tr>
				<tr>
					<th width="20%">내용</th>
					<td>
						<textArea cols="52" rows="10" name="content">${vo.content }</textArea>
					</td>
				</tr>
				<tr>
					<th width="20%">첨부파일</th>
					<td>
						<table>
							<tr>
								<td style="border-bottom: 0px;">
									<input type="button" value="추가" id="addBtn">
									<input type="reset" value="삭제" id="removeBtn">
								</td>
							</tr>
						</table>
						<table class="fileView">
							
						</table>
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
						<input type="button" value="수정하기" onclick="send()">
						<input type="reset" value="취소" onclick="javascript:history.back()">
					</td>
				</tr>
			</table>	
		</form:form>
	</div>
</body>
</html>