<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>Uom Data page</title>
</head>
<body>
<div class="container">
	
	<div class="card">
		
		<div class="card-header bg-primary text-white">
			<div class="row">
				<div class="col-10">
				<h3>Welcome to Uom Data page </h3>
				</div>
				<div class="col-2">
					<a href="register" class="btn btn-info">Register</a>
				</div>
			</div>
		</div>
		
		<div class="card-body">
			<table border="1" class=" table table-bordered thead-dark table-hover table-danger bg-light text-success">
				<tr>
					<th>Uom Id</th>
					<th>Uom Type</th>
					<th>Uom Model</th>
					<th>Descrpition</th>
					<th colspan="3">Operations</th>
				</tr>
				
				<c:forEach items="${uoms}" var="ob">
					<tr>
						<td><c:out value="${ob.uomId}"/></td>
						<td><c:out value="${ob.uomType}"/></td>
						<td><c:out value="${ob.uomModel}"/></td>
						<td><c:out value="${ob.uomDescrpition}"/></td>
						
						<td><a href="view?uomId=${ob.uomId}"  class="btn btn-info">View</a></td>
						<td><a href="edit?uomId=${ob.uomId}"  class="btn btn-primary">Edit</a></td>
						<td><a href="delete?uomId=${ob.uomId}"  class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
					
			</table>
		
		</div>
		
		<div class="card-footer bg-primary text-white">
			${message}<br><br>
		<a href="excel" class="btn btn-info">Excel Export</a>
		<a href="pdf" class="btn btn-secondary">Pdf Export</a>
		<a href="charts" class= "btn btn-danger">Charts</a>
		</div>
	</div>
	
</div>
</body>
</html>