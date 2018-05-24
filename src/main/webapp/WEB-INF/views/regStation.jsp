<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Station Registration</title>

<style>
	
</style>
	
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<h2>Registration Form</h2>
 
 	<form:form method="POST" modelAttribute="station">
 	
 		<div><a href="<c:url value='/' />">Menu</a><input type="submit" value="Save"/></div>
 	<br>
	
		<form:input type="hidden" path="id" id="id"/>
		<form:input type="hidden" path="modifyDate" id="modifyDate"/>
		<form:input type="hidden" path="status" id="status" value='Y'/>
		<table>
			<tr>
				<td><label for="StationName">Name: </label> </td>
				<td><form:input path="StationName" id="StationName"/></td>
		    </tr>
	    </table>
	</form:form>
	<br/>

	message : ${msg}
	<hr/>
	
	
</body>
</html>