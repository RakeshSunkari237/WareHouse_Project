<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>Uom view page</title>
</head>
<body>
<div class="container">
	
	<div class="card">
		
		<div class="card-header bg-primary text-white">
			<h3>Welcome to Uom View page</h3>
		</div>
		
		<div class="card-body">
			<table border="1"  class="table table-bordered thead-dark table-hover table-danger bg-light text-succes">
				<tr>
					<th>Uom Id</th><td>${uom.uomId}</td>
				</tr>
				<tr>
					<th>Uom Type</th><td>${uom.uomType}</td>
				</tr>
				<tr>
					<th>Uom Model</th><td>${uom.uomModel}</td>
				</tr>
				<tr>
					<th>Descrpition</th><td>${uom.uomDescrpition}</td>
				</tr>
			</table>
		</div>
		
		<div class="card-footer">
			<a href="edit?uomId=${uom.uomId}"  class="btn btn-primary">Edit</a>
			<a href="delete?uomId=${uom.uomId}"  class="btn btn-danger">Delete</a>
			<a href="excel?uomId=${uom.uomId}" class="btn btn-info">Excel Export</a>
			<a href="pdf?uomId=${uom.uomId}" class="btn btn-secondary">Pdf Export</a>
		</div>
	</div>
	
	
</div>
</body>
</html>