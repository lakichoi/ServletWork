<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ȸ������</title>
</head>
<body>
<h1>ȸ������</h1>
<form action="add.do" method="post">
	�̸�: <input type="text" name="name"><br>
	�̸���: <input type="text" name="email"><br>
	��й�ȣ: <input type="password" name="password"><br>
	<input type="submit" value="Ȯ��">
	<input type="reset" value="���">
</form>
<!-- PrintWriter out = response.getWriter();
//		out.println("<html><head><title>�ű�ȸ��</title></head>");
//		out.println("<body><h1>ȸ������</h1>");
//		out.println("<form action='add' method='post'>");
//		out.println("�̸�: <input type='text' name='name'><br>");
//		out.println("�̸���: <input type='text' name='email'><br>");
//		out.println("��й�ȣ: <input type='password' name='password'><br>");
//		out.println("<input type='submit' value='Ȯ��'>");
//		out.println("<input type='reset' value='���'>");
//		out.println("</form>");
//		out.println("</body></html>"); -->
</body>
</html>