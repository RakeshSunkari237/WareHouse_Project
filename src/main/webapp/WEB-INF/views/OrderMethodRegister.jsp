<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>OrderMethod Register page</title>
</head>
<body>
<div class="container">
	
	<div class="card">
		
		<div class="card-header  bg-info text-white">
			<h3>Welcome to OrderMethod Register page</h3>
		</div>
		
		<div class="card-body">
			<form:form action="insert" method="POST" modelAttribute="orderMethod">
				
				<div class="row">
					<div class="col-3"></div>
					<div class="col-2">
						<label for="orderMethodMode" >Order Mode</label>
					</div>
					<div class="col-4"> 
						<form:radiobutton path="orderMethodMode" value="SALE" />Sale &nbsp; &nbsp;
						<form:radiobutton path="orderMethodMode" value="PURCHASE"/>Purchase
					</div>
				</div>
				
				<div class="row">
					<div class="col-3"></div>
					<div class="col-2">
						<label for="orderMethodCode">Order Code</label>
					</div>
					<div class="col-4">
						<form:input path="orderMethodCode" class="form-control"/>
					</div>
				</div>
				
				<div class="row">
					<div class="col-3"></div>
					<div class="col-2">
						<label for="excuteType">Execute Type</label>
					</div>
					<div class="col-4">
						<form:select path="excuteType" class="form-control">
							<form:option value="">-Select-</form:option>
							<form:option value="FIFO">FIFO</form:option>
							<form:option value="LIFO">LIFO</form:option>
							<form:option value="FCFO">FCFO</form:option>
							<form:option value="FEFO">FEFO</form:option>
						</form:select>
					</div>
				</div>
				
				<br/>
				
				<div class="row">
					<div class="col-3"></div>
					<div class="col-2">
						<label for="orderMethodAccept">Order Accept</label>
					</div>
					<div class="col-5">
						<form:checkbox path="orderMethodAccept" value="Multi-Model" />Multi-Model &nbsp;
						<form:checkbox path="orderMethodAccept" value="Accept-Return" />Accept-Return
						<form:checkbox path="orderMethodAccept" value="Service-Extend" />Service-Extend
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
					<div class="col-3">
						<input type="submit" value="Create Order Method" class="btn btn-success"/>
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