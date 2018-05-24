<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Station List</title>

<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
</style>
	
</head>
<body>

 
 	<div><a href="<c:url value='/' />">Menu</a></div>
 	<br>
	<table>
		<tr>
			<td>站點</td><td>修改時間</td><td>動作</td>
		</tr>
		<c:forEach items="${station}" var="station">
		<tr>
			<td>${station.stationname}</td>
			<td>${station.modifyDate}</td>
			<td><a href="<c:url value="/view-${station.id}-station" />">View</a>
			<td><a href="<c:url value="/del-${station.id}-station" />">Del</a>
		</tr>
			
		</c:forEach>
	</table>
	
</body>
</html>