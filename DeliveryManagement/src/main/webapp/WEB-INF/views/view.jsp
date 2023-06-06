<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bag View Page</title>
</head>
<body>

<h2>Welcome to Bag View Page</h2>

<table border=2>

<tr>
	<th>Id</th>
	<td>${objOfBag.id}</td>
</tr>
<tr>
	<th>name</th>
	<td>${objOfBag.colour}</td>
</tr>
<tr>
	<th>phNum</th>
	<td>${objOfBag.size}</td>
</tr>
<tr>
	<th>email</th>
	<td>${objOfBag.noOfZips}</td>
</tr>

<tr>
	<th>Delete</th>
	<td>
		<a href="/BagSpringBootCRUDProj/delete?id=${emp.id}">Delete</a>
	</td>
</tr>
<tr>
	<th>Update</th>
	<td>
		<a href="/BagSpringBootCRUDProj/getUpdate?id=${emp.id}">Update</a>
	</td>
</tr>

</table>

<a href="/BagSpringBootCRUDProj/all">View All</a> &nbsp;
<a href="/BagSpringBootCRUDProj/reg">Register</a> &nbsp;
<a href="/BagSpringBootCRUDProj/">Home</a>

${msg}

</body>
</html>