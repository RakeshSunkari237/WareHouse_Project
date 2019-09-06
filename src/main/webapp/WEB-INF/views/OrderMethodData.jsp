<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>OrderMethod Data page</title>
</head>
<body>
<div class="container">
	
	<div class="card">
		
		<div class="card-header bg-info text-white">
			<div class="row">
				<div class="col-10">
				<h3>Welcome to OrderMethod Data page </h3>
				</div>
				<div class="col-2">
					<a href="register" class="btn btn-info">Create OrderMethod</a>
				</div>
			</div>
		</div>
		
		<div class="card-body">
			<table border="1" class=" table table-bordered thead-dark table-hover  bg-light text-success">
				<tr>
					<th>OrderMethod Id</th>
					<th>Order Mode</th>
					<th>Order Code</th>
					<th>Execute Type</th>
					<th>Order Accept</th>
					<th>Description</th>
					<th></th>
					<th colspan="3">Operations</th>
				</tr>
				
				<c:forEach items="${orderMethods}" var="ob">
					<tr>
						<td><c:out value="${ob.orderMethodId}"/></td>
						<td><c:out value="${ob.orderMethodMode}"/></td>
						<td><c:out value="${ob.orderMethodCode}"/></td>
						<td><c:out value="${ob.excuteType}"/></td>
						<td><c:out value="${ob.orderMethodAccept}"/></td>
						<td><c:out value="${ob.descrpition}"/></td>
						
						<td><a href="view?orderMethodId=${ob.orderMethodId}">
							<img src="../resources/images/view.png" height="40" width="40"/>
							</a>
						</td>
						<td><a href="edit?orderMethodId=${ob.orderMethodId}" >
							<img src="../resources/images/edit.png" height="40" width="40/">
							</a>
						</td>
						<td><a href="delete?orderMethodId=${ob.orderMethodId}">
							<img src="../resources/images/delete.png" height="40" width="40"/>
							</a>
						</td>
					</tr>
				</c:forEach>
					
			</table>
		
		</div>
		
		<div class="card-footer bg-light text-danger">
			<div class="row">
				<div class="col-4">
					${message}
				</div>
				<div class="col-7">
					<a href="excel">
						<img src="../resources/images/BulkExcel.png" height="60" width="160" />
					</a>
					<a href="pdf">
						<img src="../resources/images/BulkPdf.png" height="60" width="160" />
					</a>
					<a href="charts">
						<img src="../resources/images/charts.png" height="60" width="160" />
					</a>
						
				</div>
			</div>
			
		</div>
	</div>
	
</div>
</body>
</html>