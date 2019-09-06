<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>OrderMethod View one page</title>
</head>
<body>
<div class="container">

	<div class="card">
		
		<div class="card-header bg-info text-white">
			<h3>Welcome to OrderMethod View One page</h3>
		</div>
		
		<div class="card-body">
			<table border="1"  class="table table-bordered thead-dark table-hover  bg-light text-succes">
				<tr>
					<th>OrderMethod Id</th><td>${orderMethod.orderMethodId}</td>
				</tr>
				<tr>
					<th>Order Mode</th><td>${orderMethod.orderMethodMode}</td>
				</tr>
				<tr>
					<th>Order Code</th><td>${orderMethod.orderMethodCode}</td>
				</tr>
				<tr>
					<th>Execute Type</th><td>${orderMethod.excuteType}</td>
				</tr>
				<tr>
					<th>Order Accept</th><td>${orderMethod.orderMethodAccept}</td>
				</tr>
				<tr>
					<th>Description</th><td>${orderMethod.descrpition}</td>
				</tr>
					
			</table>
		</div>
		
		<div class="card-footer bg-light text-white">
			<div class="row">
				<div class="col-1">
					<a href="edit?orderMethodId=${orderMethod.orderMethodId}" >
						<img src="../resources/images/edit.png" height="40" width="40/">
					</a>
				</div>
				<div class="col-1">
					<a href="delete?orderMethodId=${orderMethod.orderMethodId}" >
						<img src="../resources/images/delete.png" height="40" width="40"/>
					</a>
				</div>
				<div class="col-1">
					<a href="excel?orderMethodId=${orderMethod.orderMethodId}" >
						<img src="../resources/images/excel.png" height="40" width="40" />
					</a>
				</div>
				<div class="col-1">
					<a href="pdf?orderMethodId=${orderMethod.orderMethodId}" >
						<img src="../resources/images/pdf.png" height="40" width="40"  />
					</a>
				</div>
			</div>
			
		</div>
		
	</div>
	
</div>
</body>
</html>