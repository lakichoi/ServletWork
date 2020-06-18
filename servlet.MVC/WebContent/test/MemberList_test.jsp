<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page import="VO.Member"%>
<%@ page import="java.util.ArrayList"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList</title>
</head>
<body>
	<a href="../index.jsp">초기화면</a><br>
	<h1>회원목록</h1>
	<jsp:include page="/member/Header.jsp"></jsp:include>
	<p><a href="add.do">신규</a></p>
	<c:forEach var="member" items="${member }">
		${member.no },
		<a href="update.do?no=${member.no }">${member.name },</a>
		${member.email },
		${member.createdDate }<br>
	</c:forEach>
	<%-- <%
	ArrayList<Member>members = (ArrayList<Member>)request.getAttribute("member");
	%>
	<%for(Member mem : members){%>
	
	<%=mem.getNo() %>
	<a href='update?no=<%=mem.getNo() %>'><%=mem.getName() %></a>
	<%=mem.getEmail() %>
	<%=mem.getCreatedDate() %><br>
	<%} %> --%>
	-END-
	
	
</body> 
</html>