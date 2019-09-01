<%@page import="javax.persistence.Table"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>ShipmentType Data page </title>
</head>
<body>
<div class="container">

	<div class="card">
		
		<div class="card-header bg-primary text-white">
			<div class="row">
				<div class="col-10">
				<h3>Welcome to ShipmentTypeData page </h3>
				</div>
				<div class="col-2">
					<a href="register" class="btn btn-info">Register</a>
				</div>
			</div>
		</div>
		
		<div class="card-body">
			<table border="1" class=" table table-bordered thead-dark table-hover table-danger bg-light text-success">
				<tr>
					<th>shipment Id</th>
					<th>shipment Mode</th>
					<th>shipment Code</th>
					<th>Enable</th>
					
					<!-- <th>shipmentTypeGrade</th>
					<th>Descrpition</th> -->
					
					<th colspan="4">Operations</th>
				<c:forEach items="${list}" var="ob">
					<tr>
						<td><c:out value="${ob.shipmentTypeId}"/></td>
						<td><c:out value="${ob.shipmentTypeMode}"/></td>
						<td><c:out value="${ob.shipmentTypeCode}"/></td>
						<td><c:out value="${ob.enableShipment}"/></td>
						
						<%-- td><c:out value="${ob.shipmentTypeGrade}"/></td>
						<td><c:out value="${ob.descrpition}"/></td> --%>
						
						<td><a href="view?shipmentTypeId=${ob.shipmentTypeId}"  class="btn btn-info">View</a></td>
						<td><a href="edit?shipmentTypeId=${ob.shipmentTypeId}"  class="btn btn-primary">Edit</a></td>
						<td><a href="delete?shipmentTypeId=${ob.shipmentTypeId}"  class="btn btn-danger">Delete</a></td>
					</tr>
				
				</c:forEach>
				
				
				</tr>
			</table>
		</div>
		
		<div class="card-footer bg-primary text-white">
		${message}<br><br>
		<a href="excel" class="btn btn-info">Excel Export</a>
		<a href="pdf" class="btn btn-secondary">Pdf Export</a>
		<a href="charts" class= "btn btn-danger">Charts</a>
		
		</div>
	</div>
</div>
</body>
</html>