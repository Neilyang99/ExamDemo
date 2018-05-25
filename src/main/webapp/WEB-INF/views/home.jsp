<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

<style type="text/css">

</style>
</head>
<body>
<div class="generic-container">
		<div class="panel panel-default">
		<center>
<table  class="table table-hover">
<tr><td><a href="<c:url value='/newStation' />">新增站點</a></td></tr>
<tr><td><a href="<c:url value='/listStation' />">站點列表</a></td></tr>
<tr><td><a href="<c:url value='/newUser' />">新增護士</a></td></tr>
<tr><td><a href="<c:url value='/listUser' />">護士列表</a></td></tr>
</table>
</center>
</div>
</div>
	
</body>
</html>