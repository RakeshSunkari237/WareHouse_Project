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
		
		<div class="card-header bg-info text-white">
			<div class="row">
				<div class="col-10">
				<h3>Welcome to Uom Data page </h3>
				</div>
				<div class="col-2">
					<a href="register" class="btn btn-info">Create Uom</a>
				</div>
			</div>
		</div>
		
		<div class="card-body">
			<table border="1" class=" table table-bordered thead-dark table-hover  bg-light text-success">
				<tr>
					<th>Uom Id</th>
					<th>Uom Type</th>
					<th>Uom Model</th>
					<th>Description</th>
					<th colspan="3">Operations</th>
				</tr>
				
				<c:forEach items="${uoms}" var="ob">
					<tr>
						<td><c:out value="${ob.uomId}"/></td>
						<td><c:out value="${ob.uomType}"/></td>
						<td><c:out value="${ob.uomModel}"/></td>
						<td><c:out value="${ob.uomDescrpition}"/></td>
						
						<td><a href="view?uomId=${ob.uomId}" >
								<img src="../resources/images/view.png" height="40" width="40"/>
							</a>
						</td>
						<td><a href="edit?uomId=${ob.uomId}" >
							<img src="../resources/images/edit.png" height="40" width="40/">
							</a>
						</td>
						<td><a href="delete?uomId=${ob.uomId}">
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
					<a href="excel" >
						<img src="../resources/images/BulkExcel.png" height="60" width="160" />
					</a>
					<a href="pdf" >
						<img src="../resources/images/BulkPdf.png" height="60" width="160" />
					</a>
					<a href="charts" >
						<img src="../resources/images/charts.png" height="60" width="160" />
					</a>
				</div>
				
			</div>
			
		</div>
	</div>
	
</div>
</body>
</html>