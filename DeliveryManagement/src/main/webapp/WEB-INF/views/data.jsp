<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:choose>
	<c:when test="${'allDeliveryPartners' eq mode }">
		<title>DeliveryPartner Data Page</title>
	</c:when>
	<c:when test="${'allWarehouses' eq mode }">
		<title>Warehouse Data Page</title>
	</c:when>
</c:choose>
</head>
<body>
	<c:choose>
		<c:when test="${'allDeliveryPartners' eq mode }">
			<h2>Welcome To DeliveryPartner Data Page</h2>
		</c:when>
		<c:when test="${'allWarehouses' eq mode }">
			<h2>Welcome To Warehouse Data Page</h2>
		</c:when>
	</c:choose>
	<c:if test="${empty list}">
		<h4>No Data Found</h4>
	</c:if>

	<c:choose>
		<c:when test="${'allDeliveryPartners' eq mode }">
			<c:if test="${!empty list}">

				<table border=2>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Phone Number</th>
						<th>Vehicle</th>
						<th>Capacity</th>
					</tr>

					<c:forEach items="${list}" var="dp">
						<tr>
							<td>${dp.dpId}</td>
							<td>${dp.dpName}</td>
							<td>${dp.dpPhone}</td>
							<td>${dp.dpVehicle}</td>
							<td>${dp.dpCapacity}</td>
							<td><a href="/delivery/viewDeliveryPartner?id=${ob.dpId}">View</a></td>
						</tr>
					</c:forEach>

				</table>

			</c:if>
			<a href="/delivery/registerDeliveryPartner">Register Delivery
				Partner</a> &nbsp;
	<a href="/delivery/welcome">Home</a>
		</c:when>

		<c:when test="${'allWarehouses' eq mode }">
			<c:if test="${!empty list}">

				<table border=2>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Capacity</th>
						<th>Pin-Code</th>
					</tr>

					<c:forEach items="${list}" var="warehouse">
						<tr>
							<td>${warehouse.warehouseId}</td>
							<td>${warehouse.warehouseName}</td>
							<td>${warehouse.warehouseCapacity}</td>
							<td>${warehouse.warehousePincode}</td>
							<td><a
								href="/delivery/viewWarehouse?id=${warehouse.warehouseId}">View</a></td>
						</tr>
					</c:forEach>

				</table>

			</c:if>

			<a href="/delivery/registerWarehouse">Register Warehouse</a> &nbsp;
	<a href="/delivery/welcome">Home</a>
		</c:when>
	</c:choose>
	<br> ${msg}

</body>
</html>