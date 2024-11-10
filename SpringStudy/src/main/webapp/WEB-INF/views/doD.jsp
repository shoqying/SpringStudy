<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> doD.jsp</h1>
	
<%-- 	<h2>${requestScope }</h2> --%>
	<h2>MemberVO : ${memberVO }</h2>
	<h2>vo : ${vo }</h2>
	<h2>${msg }</h2>
	
	<hr>
	<h2> http://localhost:8088/web/doD1 </h2>
	
	<h2> 전달된 정보(DB) 출력</h2>
	<h2> vo : ${memberVO }</h2>
	<h2> vo : ${vo }</h2>
	
	<hr>
	<h2>http://localhost:8088/web/doD2</h2>
	<h2> 전달된 정보(DB) 출력</h2>
	<h2> vo : ${memberVO }</h2>
	<h2> vo : ${vo }</h2>

	
</body>
</html>