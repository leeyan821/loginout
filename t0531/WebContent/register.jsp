<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="RegisterServlet" method="post">
		ID:<input type="text" name="id"><br>
		PASSWORD:<input type="password" name="pwd"><br>
		이름:<input type="text" name="name"><br>
		<input type="submit" value="join">
	</form>
	<p>
	<a href="index.jsp">Home</a>
</body>
</html>