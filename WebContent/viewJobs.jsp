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

<c:forEach items="${jobs}" var="job">
<h3>${job.jobName}</h3>
<p>${job.messageBody}</p>
<h4>${job.posterName}</h4>
<h4>${job.contactPhone}</h4>
<br/><br/>
</c:forEach>


</body>
</html>