<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<script type="text/javascript">
//메시지 처리
//패스워드변경 결과 처리
if ('${msg}' != ''){
	alert('${msg}');
}

//수정시 체크
function modifyCheck() {
	var userid = modifyForm.userid.value;
	var oldpasswd = modifyForm.oldpasswd.value;
	var email = modifyForm.email.value;
	if (userid == ''){
		alert('아이디를 입력해 주세요!');
		modifyForm.userid.focus();
	}else if (oldpasswd == ''){
		alert('패스워드를 입력해 주세요!');
		modifyForm.oldpasswd.focus();
	}else if (email == ''){
		alert('이메일를 입력해 주세요!');
		modifyForm.email.focus();
	}else{
		modifyForm.submit();	
	}		
	
}

//삭제시 체크
function deleteCheck() {
	var userid = modifyForm.userid.value;
	var oldpasswd = modifyForm.oldpasswd.value;
	var email = modifyForm.email.value;
	if (userid == ''){
		alert('아이디를 입력해 주세요!');
		modifyForm.userid.focus();
	}else if (oldpasswd == ''){
		alert('패스워드를 입력해 주세요!');
		modifyForm.oldpasswd.focus();
	}else{
		modifyForm.action = "/spring/member/delete";
		modifyForm.submit();	
	}		
	
}


//패스워드 변경
function pwchange() {
	var oldpasswd = modifyForm.oldpasswd.value;
	var passwd = modifyForm.passwd.value;
	if (oldpasswd ==''){
		alert("현재 패스워드를 입력해 주세요!");
		modifyForm.oldpasswd.focus();
	}else if (passwd == ''){
		alert("변경할 패스워드를 입력해 주세요!");
		modifyForm.passwd.focus();
	} else{
		modifyForm.action = "/spring/member/pwUpdate";
		modifyForm.submit();
	}
		
}


</script>
</head>
<body>
	<h2>회원정보</h2>
	<form name="modifyForm" action="/mylogin/member/modify" 
			method="post" enctype="multipart/form-data">
		아이디 : <input type="text" name="userid" value="${dto.userid}" > <br>
		비밀번호 : 
			<input type="password" name="oldpasswd" size="4"><br>
		변경비밀번호
			<input type="password" name="passwd" size="4" >
			
			<input type="button" value="비밀번호변경" onclick="pwchange()">
		<br>
		이메일 : <input type="email" name="email" value="${dto.email}"><br>
		
		<!-- /images 경로 설정은 server.xml에서 --> 
		<div><img src="/images/${dto.filename}" width="100px">	
		 <input type="text" name="filename" value="${dto.filename}" readonly>
		<input type="file" name="photofile">
		</div>	
		
		<input type="button" value="수정" onclick="modifyCheck()">
		<input type="button" value="삭제" onclick="deleteCheck()">
		<input type="button" value="메인으로" 
			onclick="location.href='/spring/login/main'">

	</form>	
	
</body>
</html>