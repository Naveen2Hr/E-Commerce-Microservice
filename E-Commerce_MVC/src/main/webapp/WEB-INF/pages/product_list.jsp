<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	font-family: Tahoma, Arial, sans-serif;
}

h1, h2, h3, b {
	color: white;
	background-color: #525D76;
}

h1 {
	font-size: 22px;
}

h2 {
	font-size: 16px;
}

h3 {
	font-size: 14px;
}

p {
	font-size: 12px;
}

a {
	color: black;
}

.line {
	height: 1px;
	background-color: #525D76;
	border: none;
}
</style>
</head>

<body>
	<table class="table table-bordered" id="myTable"
		style="align-content: center; border: column-rule-width; border-color: black;">
		<thead>
			<tr style="color: white; background: black">
				<th colspan="7" style="text-align: center;">Product List</th>
			</tr>
			<tr style="color: white; background: black">
				<th style="text-align: center">Product ID</th>
				<th style="text-align: center">Product Name</th>
				<th style="text-align: center">Product Category</th>
				<th style="text-align: center">Product Status</th>
				<th style="text-align: center">Product Count</th>
				<th style="text-align: center">Product Type</th>
				<th style="text-align: center">Product Price</th>
				<th style="text-align: center">Product Description</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${proList}">
				<tr>
					<td style="text-align: center"><c:out
							value="${product.productId}" /></td>
					<td style="text-align: center"><c:out
							value="${product.productName}" /></td>
					<td style="text-align: center"><c:out
							value="${product.productCategory.catName}" /></td>
					<td style="text-align: center"><c:out
							value="${product.productStatus}" /></td>
					<td style="text-align: center"><c:out
							value="${product.productCount}" /></td>
					<td style="text-align: center"><c:out
							value="${product.productType.typeName}" /></td>
					<td style="text-align: center"><c:out
							value="${product.productPrice}" /></td>
					<td style="text-align: center"><c:out
							value="${product.productDespcription}" /></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>

</html>