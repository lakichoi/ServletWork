<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MVC Index.jsp</h1><br>
	<a href="member/list.do">리스트</a>
	<a href="<%=request.getContextPath() %>/auth/LoginForm.jsp">로그인</a>
</body>
</html>