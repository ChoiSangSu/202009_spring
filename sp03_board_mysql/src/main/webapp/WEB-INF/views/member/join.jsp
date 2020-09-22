<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script>
	if ('${msg}' != ''){
		alert('${msg}');
	}
	function joinCheck() {
		var userid = joinForm.userid.value;
		var passwd = joinForm.passwd.value;
		var email = joinForm.email.value;
		if (userid == ''){
			alert('아이디를 입력해 주세요!');
			joinForm.userid.focus();
		}else if (passwd == ''){
			alert('패스워드를 입력해 주세요!');
			joinForm.passwd.focus();
		}else if (email == ''){
			alert('이메일를 입력해 주세요!');
			joinForm.email.focus();
		}else{
			joinForm.submit();	
		}		
		
	}

</script>
</head>
	<h2>회원가입</h2>
	<form name="joinForm" action="/spring/member/join" method="post" enctype="multipart/form-data">
		아이디 : <input type="text" name="userid"> <br>
		비밀번호 : <input type="password" name="passwd"><br>
		이메일 : <input type="email" name="email"><br>
		사진 : <input type="file" name="photofile"><br>
		<input type="button" value="가입" onclick="joinCheck()">
	</form>	
	
	
</body>
</html>