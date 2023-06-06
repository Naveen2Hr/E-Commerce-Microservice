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
	
<form:form action="save" method="post" modelAttribute="objOfBag">

<c:if test="${'edit' eq mode }">
Id     : <form:input path="id" readOnly="true" />	
</c:if>

colour     : <form:input path="colour" />

size   	 : <form:input path="size" />

noOfZips   : <form:input path="noOfZips" />

<c:choose>
	
	<c:when test="${'deliveryPartnerEdit' eq mode }">
		<input type="submit" value="Update Delivery Partner">
	</c:when>
	<c:when test="${'deliveryPartnerAdd' eq mode }">
		<input type="submit" value="Register Delivery Partner">
	</c:when>
	<c:when test="${'warehouseEdit' eq mode }">
		<input type="submit" value="Update Warehouse">
	</c:when>
	<c:when test="${'warehouseAdd' eq mode }">
		<input type="submit" value="Register Warehouse">
	</c:when>
	
</c:choose>

</form:form>

</pre>

	${msg}

	<a href="/BagSpringBootCRUDProj/all">Show All</a> &nbsp;
	<a href="/BagSpringBootCRUDProj/">Home</a>



</body>
</html>