<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	Message Body: 
	<br />
	<textarea form = "postJobForm" rows="10" cols="50" name = "messagebody"></textarea>
	
	<form action = "/JobPortal/PostJob" method = "POST" id = "postJobForm">
		Job Name: <input type = "text" name = "jobname" /><br />
		Poster Name: <input type = "text" name = "postername" /><br />
		Secret Password: <input type = "text" name = "secretpassword" /><br />
		Contact Form : <input type = "text" name = "contactphone" /><br />
		<input type="submit" value = "submit">
	</form>

</body>
</html>