<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RMI Dictionary Service - Distributed Systems Assignment</title>
</head>
<body>
	<h2>Meaning: </h2>
	<p>Enter the word you want to get the meaning of </p>
	<form action="DicServlet" method="POST">
		<input type="text" name="find">
		<br>
		<input type="submit" value="Teach Me!!">
	</form>
	<form action="DicServlet" method="GET">
	 <%= request.getParameter("word")
	 %>
	</form>

</body>
</html>