<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Station List</title>
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

<style>
		
</style>
	
</head>
<body>
<div class="generic-container">
		<div class="panel panel-default">
 
 	
 	<div class="panel-heading"><span class="lead">護士列表</span></div>
 
	<table class="table table-hover">
		<tr>
			<td>員編</td><td>修改時間</td><td>動作</td>
		</tr>
		<c:forEach items="${user}" var="user">
		<tr>
			<td>${user.employeeID}</td>
			<td>${user.modifyDate}</td>
			<td><a href="<c:url value="/view-${user.id}-user" />" class="btn btn-success custom-width">View</a>
			<a href="<c:url value="/del-${user.id}-user" />" class="btn btn-danger custom-width">Del</a></td>
		</tr>
			
		</c:forEach>
	</table>
		<br>
	<div class="form-actions floatRight">
			<div><a href="<c:url value='/' />" class="btn btn-primary btn-sm">返回</a></div>
	</div>
	
</div>
</div>	
</body>
</html>