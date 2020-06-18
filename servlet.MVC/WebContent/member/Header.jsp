<%@page import="VO.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <jsp:useBean id="login" scope="session" class="VO.Member" ></jsp:useBean>
<%-- <%
Member member = (Member)session.getAttribute("member");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<%if(login.getEmail() != null) {%>
		<%=login.getName() %>님 반갑습니다. &nbsp; <a href="<%=request.getContextPath() %>/auth/logout.do"> logout</a>
		
	<%}else{%>
		<a href="<%=request.getContextPath() %>/auth/LoginForm.jsp"> 로그인</a>
		<%} %>
</body>
</html>