<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registration</title>
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

 
 	<form:form method="POST" modelAttribute="user"  name="form1" class="form-horizontal">
 	
 		<div>
 			
 			<c:choose>
						<c:when test="${edit}">
							<div class="well lead">維護護士資料</div>
							<a href="<c:url value='/listUser' />">返回</a>
							<input type="submit" value="儲存"  class="btn btn-info btn-sm"/>
						</c:when>
						<c:otherwise>
							<div class="well lead">新增護士資料</div>
							<a href="<c:url value='/' />">返回</a>
							<input type="submit" value="新增"  class="btn btn-info btn-sm"/>
						</c:otherwise>
			</c:choose>
 		
 		</div>
 	<br>
	
		<form:input type="hidden" path="id" id="id"/>
		<form:input type="hidden" path="modifyDate" id="modifyDate"/>
		<form:input type="hidden" path="working" id="working"/>
		
		<div class="row">
			<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="employeeID" style="width:90px">員工編號</label>
				<div class="col-md-7">
					<form:input type="text" path="employeeID" id="employeeID"  maxlength="10" class="form-control input-sm"/>
					<form:errors path="employeeID" cssClass="error"/>
				</div>
			</div>
		</div>	
		<div class="row">
			<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="name" style="width:90px">護士姓名</label>
				<div class="col-md-7">
					<form:input type="text" path="name" id="name"  maxlength="6" class="form-control input-sm"/>
					<form:errors path="name" cssClass="error"/>
				</div>
			</div>
		</div>
		
		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="stationID"  style="width:90px">分配站點</label>
                <div class="col-md-7">
                    <form:select path="stationID" items="${stationList}" multiple="false" class="form-control input-sm" />
                </div>
            </div>
        </div>
	</form:form>
	<br/>

	message : ${msg}
	<hr/>
	
</div>	
</body>
</html>