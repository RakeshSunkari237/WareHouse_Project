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
		<div class="card-header bg-primary text-white">
			<h3>Welcome to ShipmentType Register page</h3>
		</div>
		
		<div class="card-body">
			<form:form action="/insert" method="post" modelAttribute="shipmentType">
				<div class="row">
					<div class="col-3">
						<label for="shipmentMode">Shipment Mode</label>
					</div>
					<div class="col-3">
						<form:select path="shipmentMode">
							<form:option value="">-Select</form:option>
							<form:option value="AIR">Air</form:option>
							<form:option value="TRUCK">Truck</form:option>
							<form:option value="SHIP">Ship</form:option>
							<form:option value="TRAIN">Train</form:option>
						</form:select>
					</div>
				</div>
					
					<div class="row">
						<div class="col-3">
							<label for="shipmentCode">Shipment Code</label>
						</div>
						<div class="col-3">
							<form:input path="shipmentCode"/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-3">
							<label for="enableShipment">Enable Shipment</label>
						</div>
						<div class="col-3">
							<form:select path="enableShipment">
								<form:option value="">-Select-</form:option>
								<form:option value="YES">Yes</form:option>
								<form:option value="NO">No</form:option>
							</form:select>
						</div>
					</div>
					
					<div class="row">
						<div class="col-3">
							<label for="shipmentGrade">Shipment Grade</label>
						</div>
						<div class="col=3">
							<form:radiobutton path="shipmentGrade" value="A"/>A &nbsp
							<form:radiobutton path="shipmentGrade" value="B"/>B &nbsp
							<form:radiobutton path="shipmentGrade" value="C"/>C
						</div>
					</div>
					
					<div class="row">
						<div class="col-3">
							<label for="descrpition">Description</label>
						</div>
						<div class="col-3">
							<form:textarea path="descrpition"/>
						</div>
					</div>
				
				<input type="submit" class= "btn btn-success" value="Register"/>
			</form:form>
			
		</div>
		<div class="card-footer bg-primary text-white">
		${message}
		</div>
	</div>
</div>
</body>
</html>