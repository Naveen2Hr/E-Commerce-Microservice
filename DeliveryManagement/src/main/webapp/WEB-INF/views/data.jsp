<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bag Data Page</title>
</head>
<body>

	<h2>Welcome To Bag Data Page</h2>

	<c:if test="${empty list}">
		<h4>No Data Found</h4>
	</c:if>


	<c:if test="${!empty list}">

		<table border=2>
			<tr>
				<th>Id</th>
				<th>colour</th>
				<th>size</th>
				<th>noOfZips</th>
			</tr>

			<c:forEach items="${list}" var="ob">
				<tr>
					<td>${ob.id}</td>
					<td>${ob.colour}</td>
					<td>${ob.size}</td>
					<td>${ob.noOfZips}</td>
					<td><a href="/BagSpringBootCRUDProj/view?id=${ob.id}">View</a></td>
				</tr>
			</c:forEach>

		</table>

	</c:if>

	<a href="/BagSpringBootCRUDProj/reg">Register</a> ${msg} &nbsp;
	<a href="/BagSpringBootCRUDProj/">Home</a> ${msg}

</body>
</html>