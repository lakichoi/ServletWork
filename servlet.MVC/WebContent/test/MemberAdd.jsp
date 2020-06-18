<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<form action="add.do" method="post">
	이름: <input type="text" name="name"><br>
	이메일: <input type="text" name="email"><br>
	비밀번호: <input type="password" name="password"><br>
	<input type="submit" value="확인">
	<input type="reset" value="취소">
</form>
<!-- PrintWriter out = response.getWriter();
//		out.println("<html><head><title>신규회원</title></head>");
//		out.println("<body><h1>회원가입</h1>");
//		out.println("<form action='add' method='post'>");
//		out.println("이름: <input type='text' name='name'><br>");
//		out.println("이메일: <input type='text' name='email'><br>");
//		out.println("비밀번호: <input type='password' name='password'><br>");
//		out.println("<input type='submit' value='확인'>");
//		out.println("<input type='reset' value='취소'>");
//		out.println("</form>");
//		out.println("</body></html>"); -->
</body>
</html>