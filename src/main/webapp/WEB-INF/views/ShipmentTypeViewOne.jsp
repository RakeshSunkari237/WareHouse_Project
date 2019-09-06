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
		
		<div class="card-header bg-info text-white">
			<div class="row">
				<div class="col-10">
				<h3>Welcome to ShipmentType View page </h3>
				</div>
				<div class="col-2">
					<a href="register" class="btn btn-info">Register</a>
				</div>
			</div>
		</div>
		
		<div class="card-body">
			<table border="1"  class="table table-bordered thead-dark table-hover  bg-light text-success">
				<tr>
					<th>Shipment Id</th><td>${shipmentType.shipmentTypeId}</td>
				</tr>
				<tr>
					<th>Shipment Mode</th><td>${shipmentType.shipmentTypeMode}</td>
				</tr>
				<tr>
					<th>Shipment Code</th><td>${shipmentType.shipmentTypeCode}</td>
				</tr>
				<tr>
					<th>Enable Shipment</th><td>${shipmentType.enableShipment}</td>
				</tr>
				<tr>
					<th>Shipment Grade</th><td>${shipmentType.shipmentTypeGrade}</td>
				</tr>
				<tr>
					<th>Description</th><td>${shipmentType.descrpition}</td>
				</tr>
			</table>
		</div>
		
		<div class="card-footer bg-light text-white">
			
			<div class="row">
				<div class="col-1">
					<a href="edit?shipmentTypeId=${shipmentType.shipmentTypeId}" >
						<img src="../resources/images/edit.png" height="40" width="40/">
					</a>
				</div>
				<div class="col-1">
					<a href="delete?shipmentTypeId=${shipmentType.shipmentTypeId}">
						<img src="../resources/images/delete.png" height="40" width="40"/>
					</a>
				</div>
				<div class="col-1">
					<a href="excel?shipmentTypeId=${shipmentType.shipmentTypeId}">
						<img src="../resources/images/excel.png" height="40" width="40" />
					</a>
				</div>
				<div class="col-1">
					<a href="pdf?shipmentTypeId=${shipmentType.shipmentTypeId}">
						<img src="../resources/images/pdf.png" height="40" width="40"  />
					</a>
				</div>
				
			</div>

				
		</div>
	</div>
	
</div>  
</body>
</html>