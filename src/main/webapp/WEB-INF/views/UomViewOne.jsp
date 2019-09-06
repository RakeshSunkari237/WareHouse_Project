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
		
		<div class="card-header bg-info text-white">
			<h3>Welcome to Uom View page</h3>
		</div>
		
		<div class="card-body">
			<table border="1"  class="table table-bordered thead-dark table-hover  bg-light text-succes">
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
					<th>Description</th><td>${uom.uomDescrpition}</td>
				</tr>
			</table>
		</div>
		
		<div class="card-footer bg-light text-white">
			<div class="row">
				<div class="col-1">
					<a href="edit?uomId=${uom.uomId}" >
						<img src="../resources/images/edit.png" height="40" width="40/">
					</a>
				</div>
				<div class="col-1">
					<a href="delete?uomId=${uom.uomId}" >
						<img src="../resources/images/delete.png" height="40" width="40"/>
					</a>
				</div>
				<div class="col-1">
					<a href="excel?uomId=${uom.uomId}" >
						<img src="../resources/images/excel.png" height="40" width="40" />
					</a>
				</div>
				<div class="col-1">
					<a href="pdf?uomId=${uom.uomId}" >
						<img src="../resources/images/pdf.png" height="40" width="40"  />
					</a>
				</div>
			</div>
			
			
			
			
		</div>
	</div>
	
	
</div>
</body>
</html>