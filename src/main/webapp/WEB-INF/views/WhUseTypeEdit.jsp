<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    
    <%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>WhUserType Edit page</title>
</head>
<body>
<div class="container">
	
	<div class="card">
		
 		<div class="card-header bg-info text-white">
			<h3>Welcome to WhUserType Edit page</h3>
		</div>
		
		<div class="card-body">
			<form:form action="update" method="POST" modelAttribute="whUserType">
				<div class="row">
					<div class="col-3"></div>
						<div class="col-2">
							<label for="whUserTypeId">WhUserType Id</label>
						</div>
						<div class="col-4">
							<form:input path="whUserTypeId" class="form-control" readonly="true"/>
						</div>
				</div>
				
				
				<div class="row">
					<div class="col-3"></div>
					<div class="col-2">
						<label for="userType">WhUser Type</label>
					</div>
					<div class="col-4">
						<form:radiobutton path="userType" value="Vendor"/>Vendor
						<form:radiobutton path="userType" value="Customer"/>Customer
					</div>
				</div>
				
				<div class="row">
					<div class="col-3"></div>
					<div class="col-2">
						<label for="whUserCode">WhUser Code</label>
					</div>
					<div class="col-4">
						<form:input path="whUserCode" class="form-control"/>		
					</div>
				</div>
				
				<div class="row">
					<div class="col-3"></div>
					<div class="col-2">
						<label for="whUserFor">WhUser For</label>
					</div>
					<div class="col-4">
						<form:select path="whUserFor" class="form-control">
							<form:option value="">-SELECT-</form:option>
							<form:option value="PURCHASE">PURCHASE</form:option>
							<form:option value="SALE">SALE</form:option>
						</form:select>	
					</div>
				</div>
				
				<div class="row">
					<div class="col-3"></div>
					<div class="col-2">
						<label for="whUserEmail">WhUser Email</label>
					</div>
					<div class="col-4">
						<form:input path="whUserEmail" class="form-control"/>
					</div>
				</div>
				
				<div class="row">
					<div class="col-3"></div>
					<div class="col-2">
						<label for="whUserContact">WhUser Contact</label>
					</div>
					<div class="col-4">
						<form:input path="whUserContact" class="form-control"/>
					</div>
				</div>
				
				<div class="row">
					<div class="col-3"></div>
					<div class="col-2">
						<label for="whUserIdType">WhUser Id Type</label>
					</div>	
					<div class="col-4">
						<form:select path="whUserIdType" class="form-control">
							<form:option value="">-SELECT-</form:option>
							<form:option value="PAN CARD">PAN CARD</form:option>
							<form:option value="ADHAR CARD">ADHAR CARD</form:option>
							<form:option value="VOTER ID">VOTER ID</form:option>
							<form:option value="OTHER">OTHER</form:option>
						</form:select>
					</div>
				</div>
				
				<div class="row">
					<div class="col-3"></div>
					<div class="col-2">
						<label for="whUserIdNumber">WhUser ID Number</label>	
					</div>
					<div class="col-4">
						<form:input path="whUserIdNumber" class="form-control"/>
					</div>
				</div>
				
				<br/>
				<br/>
				
				<div class="row">
					<div class="col-5"></div>
					<div class="col-3">
						<input type="submit" value="Update User" class="btn btn-success"/>
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