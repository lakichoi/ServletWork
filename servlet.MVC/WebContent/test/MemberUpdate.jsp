<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="VO.Member"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%Member mem = new Member(); 
	mem = (Member)request.getAttribute("member");
%> --%>

	<form action="update.do" method="post">
		번호: <input type="text" name="no" value="${member.no}"><br>
		이름: <input type="text" name="name" value="${member.name }"><br>
		이메일 <input type="text" name="email" value="${member.email}"><br>
		가입일: <input type="date" name="date" value="${member.createdDate }"><br>
		<input type="submit" value="수정" >
		<input type="reset" value="취소">
		<a href="delete.do?no=${member.no }">삭제</a>
		
	</form>
</body>
</html>