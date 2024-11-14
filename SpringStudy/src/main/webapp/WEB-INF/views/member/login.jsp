<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>주소 : /member/login</h1>
	<h1>화면 : /views/member/login.jsp</h1>
	
	<h2> 로그인 </h2>
<%-- 	${sessionScope.name } --%>
	
	<script type="text/javascript">
		var result = "${result}";
		
		if(result == "loginFail"){
			alert("로그인 실패");
		}
	</script>
	
	
	<fieldset>
		<legend> 로그인 페이지 </legend>
		<form action="" method="post">
			아이디 : <input type="text" name="userid"><br>
			패스워드 : <input type="password" name="userpw"><br>
			<input type="submit" value="로그인">
			<input type="button" value="회원가입"  onclick="location.href='/member/join'">
			
		</form>
	</fieldset>

</body>
</html>