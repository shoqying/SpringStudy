<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>doC.jsp</h1>
	
	<h2> http://localhost:8088/web/doC?msg=Hello </h2>
	<h2> 전달된 정보 출력하기 </h2>
	<h2><%=request.getParameter("msg") %></h2>
	<h2>msg el : ${param.msg }</h2>
	
	
	@ModelAttribute("msg") String msg 사용 이후
	전달받은 데이터를 request 영역에 저장
	<hr>
	<h2>msg el : ${msg }</h2>
	msg el : $ { 영역객체Scope.msg }
	<h2>msg el : ${requestScope.msg }</h2>
	
	<hr>
	<h2>http://localhost:8088/web/doC1?id=Hello&pw=itwill</h2>
	<h2>${id }</h2>	
	<h2>${pw }</h2>
	
	
	
</body>
</html>