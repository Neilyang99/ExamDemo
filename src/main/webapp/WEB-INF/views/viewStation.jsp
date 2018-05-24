<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Station Data</title>

<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
</style>
	
</head>
<body>

 
 	<br>
 	<form:form method="POST" modelAttribute="station">
 	<div><a href="<c:url value='/listStation' />">返回</a><input type="submit" value="儲存"/></div>
 	
 		<form:input type="hidden" path="id" id="id"/>
 		<form:input type="hidden" path="modifyDate" id="modifyDate"/>
		<form:input type="hidden" path="status" id="status" value='Y'/>
 	<table>
			<tr>
				<td><label for="StationName">站點名稱: </label> </td>
				<td><form:input path="StationName" id="StationName"/></td>
		    </tr>
	    </table>
 	</form:form>
 	<br/>
 	站點護士列表
	<table>
		<tr>
			<td>員工編號</td><td>加入時間</td>
		</tr>
		
	</table>
	message : ${msg}
</body>
</html>