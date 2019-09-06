<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>ShipmentType Register page</title>
</head>
<body>
<div class="container">
	<div class="card">
		<div class="card-header bg-info text-white">
			<h3>Welcome to ShipmentType Register page</h3>
		</div>
		
		<div class="card-body">
			<form:form action="insert" method="POST" modelAttribute="shipmentType">
				<div class="row">
					<div class="col-3"></div>
					<div class="col-2">
						<label for="shipmentTypeMode">Shipment Mode</label>
					</div>
					<div class="col-4">
						<form:select path="shipmentTypeMode" class="form-control">
							<form:option value="">-Select</form:option>
							<form:option value="AIR">Air</form:option>
							<form:option value="TRUCK">Truck</form:option>
							<form:option value="SHIP">Ship</form:option>
							<form:option value="TRAIN">Train</form:option>
						</form:select>
					</div>
				</div>
					
					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="shipmentTypeCode">Shipment Code</label>
						</div>
						<div class="col-4">
							<form:input path="shipmentTypeCode" class="form-control"/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="enableShipment">Enable Shipment</label>
						</div>
						<div class="col-4">
							<form:select path="enableShipment" class="form-control">
								<form:option value="">-Select-</form:option>
								<form:option value="YES">Yes</form:option>
								<form:option value="NO">No</form:option>
							</form:select>
						</div>
					</div>
					
					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="shipmentTypeGrade">Shipment Grade  </label>
						</div>
						<div class="col=4"> &nbsp; &nbsp;
							<form:radiobutton path="shipmentTypeGrade" value="A" />
							A 
							<form:radiobutton path="shipmentTypeGrade" value="B" />
							B 
							<form:radiobutton path="shipmentTypeGrade" value="C" />
							C
						</div>
					</div>
					
					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="descrpition">Description</label>
						</div>
						<div class="col-4">
							<form:textarea path="descrpition" class="form-control"/>
						</div>
					</div>
					
					<br/>
					<br/>
				<div class="row">
					<div class="col-5"></div>
					<div class="col-2">
						<input type="submit" class= "btn btn-success" value="Register"/>
					</div>
				</div>
			</form:form>
		</div>
		
		<h5>
			<a href="viewAll" class= "btn btn-info">View Data Here</a>
		</h5>
		
		
		<div class="card-footer bg-secondary text-white">
		${message}
		</div>
	</div>
</div>
</body>
</html>