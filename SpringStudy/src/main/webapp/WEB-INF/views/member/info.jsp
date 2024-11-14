<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${empty id }">
		<c:redirect url="/member/login"></c:redirect>
	</c:if>
	
	${result }
	
	<h1>회원정보</h1>
	
	<table border="1px">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입날짜</th>
		</tr>
		<tr>
			<td>${result.userid }</td>
			<td>${result.userpw }</td>
			<td>${result.username }</td>
			<td>${result.useremail }</td>
			<td>${result.regdate }</td>
		</tr>
	</table>
	
	<h2><a href="/member/main"> 메인페이지로.. </a></h2>

</body>
</html>