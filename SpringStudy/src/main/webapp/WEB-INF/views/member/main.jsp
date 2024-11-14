<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 로그인 정보가 있을때만 페이지 사용 -->
	<c:if test="${empty id }">
		<c:redirect url="/member/login"></c:redirect>
	</c:if>

	<h1>main</h1>
	
	${id}님 환영합니다 <br>
	
	<input type="button" value="로그아웃" onclick="location.href='/member/logout';" >
	
	<h3>전달 정보 : ${result }</h3>
	
	<script type="text/javascript">
		
		var result = "${result}";
	//	var result = loginOK;s
		
		if(result == "loginOK"){
			alert("로그인 성공");
		}
	
	</script>
	
	<hr>
	
	<h3><a href="/member/info">회원정보 조회(info)</a></h3>
	
	<h3><a href="/member/update">회원정보 수정(update)</a></h3>
	
	<h3><a href="/member/delete">회원정보 삭제(delete)</a></h3>
	
	<!-- 관리자 -->
<%-- 	<c:if test="${!empty id && id.equals('admin')}"></c:if> --%>
	<c:if test="${!empty id && id.contains('admin')}"></c:if> <!-- 아이디에 admin이 포함되어있는지 체크 -->
	<h3><a href="/member/list">회원정보 리스트(list)</a></h3>
	
	
	
	

</body>
</html>