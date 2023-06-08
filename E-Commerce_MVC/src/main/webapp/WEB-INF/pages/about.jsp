<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>About us</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<style>
@import
	url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;1,500&display=swap")
	;

* {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
	font-family: "Poppins", sans-serif;
}

.section {
	font-family: "Montserrat", sans-serif;
	background-image:
		url("https://img.freepik.com/free-photo/black-friday-elements-assortment_23-2149074076.jpg?w=1380&t=st=1686236414~exp=1686237014~hmac=63a44eca1ef342714b2c625a281bf17b2bb35eaa1dba0bb58cccc9c3cc3bb632");
	background-size: center;
	background-position: center;
	background-blend-mode: color-burn;
	background-repeat: no-repeat;
	
}

.section {
	width: 100%;
	min-height: 100vh;
	background-color: #ddd;
}

.container {
	width: 80%;
	display: block;
	margin: auto;
	padding-top: 100px;
}

.content-section {
	float: left;
	width: 55%;
}

.image-section {
	float: right;
	width: 40%;
}

.image-section img {
	width: 100%;
	height: auto;
}

.content-section .title {
	text-transform: uppercase;
	font-size: 28px;
}

.content-section .content h3 {
	margin-top: 20px;
	color: #fff;
}

.content-section .content p {
	margin-top: 10px;
	font-family: sans-serif;
	font-size: 17px;
	line-height: 1.5em;
}

.content-section .content .button {
	margin-top: 30px;
}

.content-section .content .button a {
	background-color: #3d3d3d;
	padding: 12px 40px;
	text-decoration: none;
	color: #fff;
	font-size: 25px;
	letter-spacing: 1.5px;
}

.content-section .content .button a:hover {
	background-color: #a52a2a;
	color: #fff;
}

.content-section .social {
	margin: 40px 40px;
}

.content-section .social i {
	color: #a52a2a;
	font-size: 30px;
	padding: 0px 10px;
}

.content-section .social i:hover {
	color: #3d3d3d;
}

@media screen and (max-width: 768px) {
	.container {
		width: 80%;
		display: block;
		margin: auto;
		padding-top: 50px;
	}
	.content-section {
		float: none;
		width: 100%;
		display: block;
		margin: auto;
	}
	.image-section {
		float: none;
		width: 100%;
		display: block;
		margin: auto;
	}
	.image-section img {
		width: 100%;
		height: auto;
		display: block;
		margin: auto;
	}
	.content-section .title {
		text-align: center;
		font-size: 19px;
	}
	.content-section .content .button {
		text-align: center;
	}
	.content-section .content .button a {
		padding: 9px 30px;
	}
	.content-section .social {
		text-align: center;
	}
}
</style>
</head>
<body>
	<div class="section">
		<div class="container">
			<div class="content-section">
				<div class="title">
					<h1>About Us</h1>
				</div>
				<div class="content">
					<h3>
              E ^ Shoppers Powers Over 17,000 
                  Businesses in WorldWide <br>
                  The All in One Plat Platform for start,run and shop
            </h3>
            <p>
              The first E ^ Shoppers store was our own
              Over a decade ago, we started a store to sell Snow Boards online.
              None of the E-Commerce Solutions at the time gave us the control we 
              needed to be successful so we built our own. <br>Today, businesses of all sizes use E ^ Shoppers, 
              whether they are selling online, in retail stores, or on-the-go.
            </p>
					<div class="button">
						<a href="/">Home Page</a>
					</div>
				</div>
				<div class="social">
					<a href=""><i class="fab fa-facebook-f"></i></a> <a href=""><i
						class="fab fa-twitter"></i></a> <a href=""><i
						class="fab fa-instagram"></i></a>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
