<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>Uom Edit page</title>
</head>
<body>
<div class="container">

	<div class="card">
		
		<div class="card-header  bg-primary text-white">
			<h3>Welcome to Uom Edit Page</h3>
		</div>
		
		<div class="card-body">
			<form:form action="update" method="POST" modelAttribute="uom">
				<div class="row">
					<div class="col-3">
						<label for="uomId"></label>
					</div>
					<div class="col-3">
						<form:input path="uomId" readonly="true"/>
					</div>	
				</div>
				
				<div class="row">
					<div class="col-3">
						<label for="uomType">Uom Type</label>
					</div>
					<div class="col-3">
						<form:select path="uomType">
							<form:option value="">-Select-</form:option>
							<form:option value="PACKING">PACKING</form:option>
							<form:option value="NON-PACKING">NON-PACKING</form:option>
							<form:option value="-NA-">-NA-</form:option>
						</form:select>
					</div> 
				</div>
					
					<div class="row">
						<div class="col-3">
							<label for="uomModel">Uom Model</label>
						</div>
						<div class="col-3">
							<form:input path="uomModel"/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-3">
							<label for="uomDescrpition">Descrpition</label>
						</div>
						<div class="col-3">
							<form:textarea path="uomDescrpition"/>
						</div>
					</div>
					
				<input type="submit" value="Update Uom" class="btn btn-success"/>
			
			</form:form>
		</div>
		
		<div class="card-footer bg-success text-white">
		</div>
	</div>
	
</div>

</body>
</html>