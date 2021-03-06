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
		
		<div class="card-header  bg-info text-white">
			<h3>Welcome to Uom Edit Page</h3>
		</div>
		
		<div class="card-body">
			<form:form action="update" method="POST" modelAttribute="uom">
				<div class="row">
					<div class="col-3"></div>
					<div class="col-2">
						<label for="uomId">Uom Id</label>
					</div>
					<div class="col-4">
						<form:input path="uomId" readonly="true" class="form-control"/>
					</div>	
				</div>
				
				<div class="row">
					<div class="col-3"></div>
					<div class="col-2">
						<label for="uomType">Uom Type</label>
					</div>
					<div class="col-4">
						<form:select path="uomType" class="form-control">
							<form:option value="">-Select-</form:option>
							<form:option value="PACKING">PACKING</form:option>
							<form:option value="NON-PACKING">NON-PACKING</form:option>
							<form:option value="-NA-">-NA-</form:option>
						</form:select>
					</div> 
				</div>
					
					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="uomModel">Uom Model</label>
						</div>
						<div class="col-3">
							<form:input path="uomModel" class="form-control"/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-3"></div>
						<div class="col-2">
							<label for="uomDescrpition">Descrpition</label>
						</div>
						<div class="col-3">
							<form:textarea path="uomDescrpition" class="form-control"/>
						</div>
					</div>
					
					<br/>
					<br/>
					
					<div class="row">
						<div class="col-5"></div>
						<div class="col-3">
							<input type="submit" value="Update Uom" class="btn btn-success"/>
						</div>
					</div>
			
			</form:form>
		</div>
		
		<div class="card-footer bg-secondary text-white">
		</div>
	</div>
	
</div>

</body>
</html>