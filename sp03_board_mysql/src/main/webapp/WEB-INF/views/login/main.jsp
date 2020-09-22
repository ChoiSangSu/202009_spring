<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<script type="text/javascript">
	if ('${msg}' != ''){
		alert('${msg}');
	}

</script>
</head>
<body>
	<h2>메인</h2>
	${sessionScope.userid} 님 환영합니다.
	<input type="button" value="로그아웃"
		onclick="location.href='/spring/login/logout'"> 
	<input type="button" value="회원정보"
		onclick="location.href='/spring/member/modify'"> 
	
	
	<div>
		<img src="/spring/resources/images/cat.jpg" width="100%">
	</div>
	
	
	
	
	
	
</body>
</html>