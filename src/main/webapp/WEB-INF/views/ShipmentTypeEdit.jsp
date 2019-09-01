<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>shipmentType Edit page</title>
</head>
<body>
<div class="container">
	
	<div class="card">
		
		<div class="card-header bg-primary text-white">
			<h3>Welcome to ShipmentTypeEdit Page</h3>
		</div>
		
		<div class="card-body">
			
			<form:form action="update" method="POST" modelAttribute="shipmentType">
			
				<div class="row">
					<div class="col-3">
						<label for="shipmentTypeId">ShipmentType Id</label>
					</div>
					<div class="col-3">
						<form:input path="shipmentTypeId" readOnly="true" />
					</div>
				</div>
				
				<div class="row">
					<div class="col-3">
						<label for="shipmentTypeMode">Shipment Mode</label>
					</div>
					<div class="col-3">
						<form:select path="shipmentTypeMode">
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
							<label for="shipmentTypeCode">Shipment Code</label>
						</div>
						<div class="col-3">
							<form:input path="shipmentTypeCode" readOnly="true"/>
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
							<label for="shipmentTypeGrade">Shipment Grade</label>
						</div>
						<div class="col=3">
							<form:radiobutton path="shipmentTypeGrade" value="A"/>A 
							<form:radiobutton path="shipmentTypeGrade" value="B"/>B 
							<form:radiobutton path="shipmentTypeGrade" value="C"/>C
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
				
				<input type="submit" class= "btn btn-success" value="Update"/>
			</form:form>	
		</div>
		
		<div class="card-footer">
		
		</div>
	</div>
</div>

</body>
</html>