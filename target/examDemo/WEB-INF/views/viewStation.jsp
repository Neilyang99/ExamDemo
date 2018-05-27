<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Station Data</title>
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<style>
	a:link, a:visited {
	    background-color: #286090;
	    color: white;
	    padding: 5px 10px;
	    text-align: center;
	    text-decoration: none;
	    display: inline-block;
	    border-radius: 3px;
	}
</style>
	
</head>
<body>

<div class="generic-container">
<div class="well lead">維護站點資料</div>
	<form:form method="POST" modelAttribute="station">
	<div ><a href="<c:url value='/listStation' />">返回</a> &nbsp; <input type="submit" value="儲存" class="btn btn-info btn-sm"></div>
 		<form:input type="hidden" path="id" id="id"/>
 		<form:input type="hidden" path="modifyDate" id="modifyDate"/>
		<form:input type="hidden" path="status" id="status" value='Y'/>
		<br>
		<div class="row">
			<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="StationName" style="width:90px">站點名稱</label>
				<div class="col-md-7">
					<form:input type="text" path="StationName" id="StationName"  maxlength="30" class="form-control input-sm"/>
				</div>
			</div>
		</div>
		
 	</form:form>
 	message : ${msg}
 	<br/>
 	<br/>
 	<div class="lead">站點護士列表</div>
 	
 	<table class="table table-hover">
		<tr>
			<td>員工編號</td><td>加入時間</td>
		</tr>
		<c:forEach items="${user}" var="user">
		<tr>
			<td>${user.employeeID}</td>
			<td>${user.modifyDate}</td>
		</tr>
			
		</c:forEach>
	</table>	
 	
 	
</div>
 
</body>
</html>