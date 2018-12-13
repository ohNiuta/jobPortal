<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2 {
color: red;
}
</style>
</head>
<body>
	<h1>Remove Job</h1>
	
	<c:if test="${error != null}">
		<h2>There was an error</h2>
	</c:if>
	
	<form action="/JobPortal/RemoveJob" method="POST">
	Job Id: <input type="text" name="id"/><br/>
	Posting Password: <input type="text" name="password" /><br/>
	<input type="submit" value="submit" />
	</form>

</body>
</html>