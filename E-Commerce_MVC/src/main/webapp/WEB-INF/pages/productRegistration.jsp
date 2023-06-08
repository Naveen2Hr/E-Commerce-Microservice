<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="UTF-8" />
<title>Responsive Registration Form | CodingLab</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<style>
@import
	url("https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap")
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "Poppins", sans-serif;
}

body {
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 10px;
	background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

.container {
	max-width: 700px;
	width: 100%;
	background-color: #fff;
	padding: 25px 30px;
	border-radius: 5px;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.15);
}

.container .title {
	font-size: 25px;
	font-weight: 500;
	position: relative;
}

.container .title::before {
	content: "";
	position: absolute;
	left: 0;
	bottom: 0;
	height: 3px;
	width: 30px;
	border-radius: 5px;
	background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

.content form .user-details {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	margin: 20px 0 12px 0;
}

form .user-details .input-box {
	margin-bottom: 15px;
	width: calc(100%/ 2 - 20px);
}

select {
	height: 45px;
	width: 100%;
	outline: none;
	font-size: 16px;
	border-radius: 5px;
	padding-left: 15px;
	border: 1px solid #ccc;
	border-bottom-width: 2px;
	transition: all 0.3s ease;
}

form .input-box span.details {
	display: block;
	font-weight: 500;
	margin-bottom: 5px;
}

.user-details .input-box input {
	height: 45px;
	width: 100%;
	outline: none;
	font-size: 16px;
	border-radius: 5px;
	padding-left: 15px;
	border: 1px solid #ccc;
	border-bottom-width: 2px;
	transition: all 0.3s ease;
}

.user-details .input-box input:focus, .user-details .input-box input:valid
	{
	border-color: #9b59b6;
}

form .gender-details .gender-title {
	font-size: 20px;
	font-weight: 500;
}

form .category {
	display: flex;
	width: 80%;
	margin: 14px 0;
	justify-content: space-between;
}

form .category label {
	display: flex;
	align-items: center;
	cursor: pointer;
}

form .category label .dot {
	height: 18px;
	width: 18px;
	border-radius: 50%;
	margin-right: 10px;
	background: #d9d9d9;
	border: 5px solid transparent;
	transition: all 0.3s ease;
}

#dot-1:checked ~ .category label .one, #dot-2:checked ~ .category label .two,
	#dot-3:checked ~ .category label .three {
	background: #9b59b6;
	border-color: #d9d9d9;
}

form input[type="radio"] {
	display: none;
}

form .button {
	height: 45px;
	margin: 35px 0;
}

form .button input {
	height: 100%;
	width: 100%;
	border-radius: 5px;
	border: none;
	color: #fff;
	font-size: 18px;
	font-weight: 500;
	letter-spacing: 1px;
	cursor: pointer;
	transition: all 0.3s ease;
	background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

form .button input:hover {
	/* transform: scale(0.99); */
	background: linear-gradient(-135deg, #71b7e6, #9b59b6);
}

@media ( max-width : 584px) {
	.container {
		max-width: 100%;
	}
	form .user-details .input-box {
		margin-bottom: 15px;
		width: 100%;
	}
	form .category {
		width: 100%;
	}
	.content form .user-details {
		max-height: 300px;
		overflow-y: scroll;
	}
	.user-details::-webkit-scrollbar {
		width: 5px;
	}
}

@media ( max-width : 459px) {
	.container .content .category {
		flex-direction: column;
	}
}
</style>
</head>

<body>
	<div class="container">
		<div class="title">Product Registration</div>
		<div class="content">
			<form action="productRegister" method="post">
				<div class="user-details">
					<div class="input-box">
						<span class="details">Product Name</span> <input type="text"
							name="productName" placeholder="Enter Product name" required />
					</div>
					<div class="input-box">
						<span class="details">Product Category</span> <select
							name="productCategory" id="cat">
							<option value="">Select the category</option>
							<option value="Mobile">Mobile</option>
							<option value="Laptop">Laptop</option>
							<option value="Kadai">Kadai</option>
							<option value="Clothes">Clothes</option>
							<option value="Pan">Pan</option>
							<option value="MakeUp">MakeUp</option>
							<option value="FaceWash">FaceWash</option>
						</select>
					</div>
					<div class="input-box">
						<span class="details">Product Status</span> <select
							name="ProductStatus" id="cat">
							<option value="Available">Available</option>
							<option value="Out of Stocks">Out of Stocks</option>
						</select>
					</div>
					<div class="input-box">
						<span class="details">Product Count</span> <input name="count"
							type="text" placeholder="Enter the count" required />
					</div>
					<div class="input-box">
						<span class="details">Product Image</span> <input name="image"
							type="text" placeholder="Enter the count" required />
					</div>
					<div class="input-box">
						<span class="details">Product Type</span> <select
							name="ProductType" id="cat">
							<option value="">Product Type</option>
							<option value="Electronics">Electronics</option>
							<option value="Fashion">Fashion</option>
							<option value="Beauty">Beauty</option>
							<option value="Applaince">Applaince</option>
						</select>
					</div>
					<div class="input-box">
						<span class="details">Product Price</span> <input name="price"
							type="text" placeholder="Enter the price" required />
					</div>
					<div class="input-box">
						<span class="details">Product Description</span>
						<textarea name="description" cols="90" rows="4"
							placeholder="Enter the Description" required></textarea>
					</div>
				</div>

				<button type="submit">Register</button>
			</form>
		</div>
	</div>
</body>
</html>
