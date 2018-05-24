<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registration</title>

<style>
	
</style>
	
</head>
<body>

<h2>Registration Form</h2>
 
 	<form:form method="POST" modelAttribute="user">
 	
 		<div>
 			
 			<c:choose>
						<c:when test="${edit}">
							<a href="<c:url value='/listUser' />">返回</a>
							<input type="submit" value="儲存"/>
						</c:when>
						<c:otherwise>
							<a href="<c:url value='/' />">返回</a>
							<input type="submit" value="新增"/>
						</c:otherwise>
			</c:choose>
 		
 		</div>
 	<br>
	
		<form:input type="hidden" path="id" id="id"/>
		<form:input type="hidden" path="modifyDate" id="modifyDate"/>
		<form:input type="hidden" path="working" id="working"/>
		<table>
			<tr>
				<td><label for="employeeID">員工編號: </label> </td>
				<td><form:input path="employeeID" id="employeeID"/></td>
		    </tr>
			<tr>
				<td><label for="name">護士姓名: </label> </td>
				<td><form:input path="name" id="name"/></td>
		    </tr>
	    </table>
	</form:form>
	<br/>

	message : ${msg}
	<hr/>
	
	
</body>
</html>