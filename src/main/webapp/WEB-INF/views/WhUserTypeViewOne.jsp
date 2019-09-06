<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>WhUserType View one page</title>
</head>
<body>
<div class="container">
	
	<div class="card">
		
		<div class="card-header bg-info text-white">
			<div class="row">
				<div class="col-10">
				<h3>Welcome to WhUserType View One page </h3>
				</div>
				<div class="col-2 ">
					<a href="register" class="btn btn-info">Create User</a>
				</div>
			</div>
		</div>
		</div>
		
		<div class="card-body">
			<table border="1"  class="table table-bordered thead-dark table-hover  bg-light text-succes">
				<tr>
					<th>WhUserType Id </th><td>${whUserType.whUserTypeId}</td>
				</tr>
				<tr>
					<th>WhUser Type</th><td>${whUserType.userType}</td>
				</tr>
				<tr>
					<th>WhUser Code</th><td>${whUserType.whUserCode}</td>
				</tr>
				<tr>	
					<th>WhUser For</th><td>${whUserType.whUserFor}</td>
				</tr>
				<tr>	
					<th>WhUser Email</th><td>${whUserType.whUserEmail}</td>
				</tr>
				<tr>	
					<th>WhUser Contact</th><td>${whUserType.whUserContact}</td>
				</tr>
				<tr>
					<th>WhUser Id Type</th><td>${whUserType.whUserIdType}</td>
				</tr>
				<tr>
					<th>WhUser Id Number</th><td>${whUserType.whUserIdNumber}</td>
				</tr>
			</table>		
		</div>
		
		<div class="card-footer bg-light text-white">
			<div class="row">
				<div class="col-1">
					<a href="edit?whUserTypeId=${whUserType.whUserTypeId}">
						<img src="../resources/images/edit.png" height="40" width="40/">
					</a>
				</div>
				<div class="col-1">
					<a href="delete?whUserTypeId=${whUserType.whUserTypeId}">
						<img src="../resources/images/delete.png" height="40" width="40"/>
					</a>
				
				</div>
				<div class="col-1">
					<a href="excel?whUserTypeId=${whUserType.whUserTypeId}">
						<img src="../resources/images/excel.png" height="40" width="40" />
					</a>
				</div>
				<div class="col-1">
					<a href="pdf?whUserTypeId=${whUserType.whUserTypeId}">
						<img src="../resources/images/pdf.png" height="40" width="40"  />
					</a>
				</div>
			</div>
			
		</div>
		
		
	</div>
</div>
</body>
</html>