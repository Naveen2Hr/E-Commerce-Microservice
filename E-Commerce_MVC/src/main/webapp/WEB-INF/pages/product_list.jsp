<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<style type="text/css">
body {
	font-size: 18px;
	font-family: 'Secular One', sans-serif;
}

table {
	border-collapse: collapse;
	margin: 0;
	width: 100%;
	box-shadow: 0 0 5px rgba(0, 0, 0, .25);
}

table tr {
	padding: .45em;
}

thead tr {
	background-color: #6e0737;
}

thead th {
	color: #fff;
	font-size: 1.15em;
}

tbody tr:nth-child(even) {
	background-color: #eaeaea;
}

table th, table td {
	font-size: 1em;
	padding: 1em;
	text-align: center;
}

thead th {
	color: #fff;
	font-size: 1.15em;
}

@media ( max-width :440px) {
	table {
		border: 3px solid #6e0737;
	}
	table thead tr {
		display: none;
	}
	table tr {
		display: block;
	}
	table th, table td {
		padding: .5em;
	}
	table td {
		text-align: right;
		display: block;
		font-size: 1em;
	}
	table td::before {
		content: attr(data-title) ": ";
		float: left;
	}
	tbody tr:nth-child(even) {
		background-color: #6e0737;
		color: #fff;
	}
}
</style>
</head>

<body>
	<a href="order"
		style="float: right; margin: 40px; max-width: 200px; border-radius: 10px; padding: 10px; size: 10px;"
		class="btn btn-primary btn-sm">Proceed with Order</a>
	<a href="home"
		style="float: right; margin: 40px; max-width: 200px; border-radius: 10px; padding: 10px; size: 10px;"
		class="btn btn-primary btn-sm">Home</a>
	<table>
		<thead>
			<tr>
				<th>Product Image</th>
				<th>Product Name</th>
				<th>Product Category</th>
				<th>Product Status</th>
				<th>Product Count</th>
				<th>Product Type</th>
				<th>Product Price</th>
				<th>Product Description</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${proList}">
				<tr>
					<td data-title="Product Image"><img style="max-width: 80px"
						src="${product.imageLoc} }"></td>
					<td data-title="Product Name"><c:out
							value="${product.productName}" /></td>
					<td data-title="Product Category"><c:out
							value="${product.productCategory.catName}" /></td>
					<td data-title="Product Status"><c:out
							value="${product.productStatus}" /></td>
					<td data-title="Product Count"><c:out
							value="${product.productCount}" /></td>
					<td data-title="Product Type"><c:out
							value="${product.productType.typeName}" /></td>
					<td data-title="Product Price"><c:out
							value="${product.productPrice}" /></td>
					<td data-title="Product Description"><c:out
							value="${product.productDespcription}" /></td>
					<td data-title="Actions"><a class="btn btn-primary btn-sm"
						href="add?productId=${product.productId}"><i
							class="fas fa-add"></i>Add</a> <input type="text" value=""
						style="width: 25%; margin-left: 10px; border: 2px solid black; border-radius: 5px">
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>

</html>