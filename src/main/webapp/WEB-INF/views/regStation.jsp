<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Station Registration</title>
</head>
<body>

<h2>Registration Form</h2>
 
	<form:form method="POST" modelAttribute="station">
	
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='/list' />">List of All Station</a>
</body>
</html>