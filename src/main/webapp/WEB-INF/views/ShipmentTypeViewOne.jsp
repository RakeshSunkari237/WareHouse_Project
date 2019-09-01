<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>ShipmentType view page</title>
</head>
<body>
<div class="container">
	
	<div  class="card">
		
		<div class="card-header bg-primary text-white">
			<div class="row">
				<div class="col-10">
				<h3>Welcome to ShipmentTypeView page </h3>
				</div>
				<div class="col-2">
					<a href="register" class="btn btn-info">Register</a>
				</div>
			</div>
		</div>
		
		<div class="card-body">
			<table border="1"  class="table table-bordered thead-dark table-hover table-danger bg-light text-succes">
				<tr>
					<th>shipment Id</th><td>${shipmentType.shipmentTypeId}</td>
				</tr>
				<tr>
					<th>shipment Mode</th><td>${shipmentType.shipmentTypeMode}</td>
				</tr>
				<tr>
					<th>shipment Code</th><td>${shipmentType.shipmentTypeCode}</td>
				</tr>
				<tr>
					<th>Enable</th><td>${shipmentType.enableShipment}</td>
				</tr>
				<tr>
					<th>shipment Grade</th><td>${shipmentType.shipmentTypeGrade}</td>
				</tr>
				<tr>
					<th>Description</th><td>${shipmentType.descrpition}</td>
				</tr>
			</table>
		</div>
		
		<div class="card-footer">
			<a href="edit?shipmentTypeId=${shipmentType.shipmentTypeId}"  class="btn btn-primary">Edit</a>
			<a href="delete?shipmentTypeId=${shipmentType.shipmentTypeId}"  class="btn btn-danger">Delete</a>
			<a href="excel?shipmentTypeId=${shipmentType.shipmentTypeId}" class="btn btn-info">Excel Export</a>
			<a href="pdf?shipmentTypeId=${shipmentType.shipmentTypeId}" class="btn btn-secondary">Pdf Export</a>
		</div>
	</div>
	
</div>
</body>
</html>