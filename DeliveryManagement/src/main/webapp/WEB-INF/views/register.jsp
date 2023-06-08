<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:choose>

	<c:when test="${'deliveryPartnerEdit' eq mode }">
		<title>Delivery Partner Edit Page</title>
	</c:when>
	<c:when test="${'deliveryPartnerAdd' eq mode }">
		<title>Delivery Partner Register Page</title>
	</c:when>
	<c:when test="${'warehouseEdit' eq mode }">
		<title>Warehouse Edit Page</title>
	</c:when>
	<c:when test="${'warehouseAdd' eq mode }">
		<title>Warehouse Register Page</title>
	</c:when>

</c:choose>
</head>
<body>

	<c:choose>
		<c:when test="${'deliveryPartnerEdit' eq mode }">
			<h3>Welcome to Delivery Partner Edit Page</h3>
			<c:set var="dpeditid" value="${id}"></c:set>
		</c:when>
		<c:when test="${'deliveryPartnerAdd' eq mode }">
			<h3>Welcome to Delivery Partner Registration Page</h3>
		</c:when>
		<c:when test="${'warehouseEdit' eq mode }">
			<h3>Welcome to Warehouse Edit Page</h3>
			<c:set var="weditid" value="${id}"></c:set>
		</c:when>
		<c:when test="${'warehouseAdd' eq mode }">
			<h3>Welcome to Warehouse Registration Page</h3>
		</c:when>
	</c:choose>

	<pre>
	<c:choose>
<c:when test="${'deliveryPartnerAdd' eq mode }">
<form:form action="save" method="post" modelAttribute="deliveryPartner">

Name     : <form:input path="dpName" />

Phone Number     : <form:input path="dpPhone" />

Vehicle   	 : <form:input path="dpVehicle" />

Capacity   : <form:input path="dpCapacity" />

		<input type="submit" value="Register Delivery Partner">

</form:form>
</c:when>

<c:when test="${'deliveryPartnerEdit' eq mode }">
<form:form action="save" method="post" modelAttribute="deliveryPartner">

Id     : <form:input path="dpId" readOnly="true" />	

Name     : <form:input path="dpName" />

Phone Number     : <form:input path="dpPhone" />

Vehicle   	 : <form:input path="dpVehicle" />

Capacity   : <form:input path="dpCapacity" />


		<input type="submit" value="Update Delivery Partner">

</form:form>
</c:when>

<c:when test="${'warehouseAdd' eq mode }">
<form:form action="create" method="post" modelAttribute="warehouse">

Name     : <form:input path="warehouseName" />

Capacity     : <form:input path="warehouseCapacity" />

Pin-code   	 : <form:input path="warehousePincode" />


		<input type="submit" value="Register Warehouse">

</form:form>
</c:when>

<c:when test="${'warehouseEdit' eq mode }">
<form:form action="save" method="post" modelAttribute="warehouse">

Id     : <form:input path="warehouseId" readOnly="true" />	

Name     : <form:input path="warehouseName" />

Capacity     : <form:input path="warehouseCapacity" />

Pin-code   	 : <form:input path="warehousePincode" />


		<input type="submit" value="Update Warehouse">
	
</form:form>
</c:when>
</c:choose>
</pre>

	${msg}

	<a href="/delivery/all">Show All</a> &nbsp;
	<a href="/delivery/welcome">Home</a>



</body>
</html>