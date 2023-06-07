<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>E ^ SHOPPERS Index Page</title>
    <link rel="stylesheet" href="/css/style.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
      integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    
    <style type="text/css">
    @import url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;1,500&display=swap");

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}
body {
  background: #2696e9;
}

header {
  z-index: 999;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 15px 200px;
  transition: 0.5s ease;
}

header .brand {
  color: #fff;
  font-size: 1.5em;
  font-weight: 700;
  text-transform: uppercase;
  text-decoration: none;
}

header .navigation {
  position: relative;
}

.brand{
  size: 100%;
  text-decoration-color: #000;
}

header .navigation .navigation_items a {
  position: relative;
  color: #fff;
  font-size: 1em;
  font-weight: 500;
  text-decoration: none;
  margin-left: 30px;
  transition: 0.3s ease;
}

header .navigation .navigation_items a::before {
  content: "";
  position: absolute;
  background: #fff;
  width: 0;
  height: 3px;
  bottom: 0;
  left: 0;
  transition: 0.3s ease;
}

header .navigation .navigation_items a:hover::before {
  width: 100%;
}

section {
  padding: 100px 200px;
}

.home {
  position: relative;
  width: 100%;
  min-height: 100vh;
  display: flex;
  justify-content: center;
  flex-direction: column;
  background: #2696e9;
}

.home:before {
  z-index: 777;
  content: "";
  position: absolute;
  background: rgba(3, 96, 251, 0.3);
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
}

.home img {
  z-index: 000;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.home .content {
  z-index: 888;
  color: #fff;
  width: 70%;
  margin-top: 50px;
  display: none;
}

.home .content.active{
  display: block;
  
}

.home .content h1 {
  font-size: 5em;
  font-weight: 100;
  text-transform: uppercase;
  letter-spacing: 5px;
  line-height: 75px;
  margin-bottom: 40px;
}

.home .content h1 span {
  font-size: 1em;
  font-weight: 500;
}

.home .content p {
  margin-bottom: 65px;
}

.home .content a {
  background: #fff;
  padding: 15px 35px;
  color: #1680ac;
  font-size: 1.1em;
  font-weight: 500;
  text-decoration: none;
  border-radius: 2px;
}

.home .media-icons {
  z-index: 888;
  position: absolute;
  right: 30px;
  display: flex;
  flex-direction: column;
  transition: 0.5s ease;
}

.home .media-icons a {
  color: #fff;
  font-size: 1.6em;
}

.home .media-icons a:not(:last-child) {
  margin-bottom: 20px;
}

.home .media-icons a:hover {
  transform: scale(1.3);
}

.home .slider-navigation {
  z-index: 888;
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  transform: translateY(80px);
  margin-bottom: 12px;
}

.slider-navigation .nav-btn {
  width: 12px;
  height: 12px;
  background-color: #fff;
  border-radius: 50%;
  cursor: pointer;
  box-shadow: 0 0 2px rgba(255, 255, 255, 0.5);
  transition: 0.3s ease;
}

.slider-navigation .nav-btn.active {
  background: #2696e9;
}

.slider-navigation .nav-btn:not(:last-child) {
  margin-right: 20px;
}

.slider-navigation .nav-btn:hover {
  transform: scale(1.2);
}
.video-slide{
  position: absolute;
  width: 100%;
  clip-path: circle(0.5% at 0 50%);
}

.video-slide.active{
  clip-path: circle(150% at 0 50%);
  transition: 2s ease;
  transition-property: clip-path;
}

@media (max-width: 1040px) {
  header {
    padding: 12px 20px;
  }

  section {
    padding: 100px 20px;
  }

  .home .media-icons {
    right: 15px;
  }

  header .navigation {
    display: none;
  }

  header .navigation.active {
    position: fixed;
    width: 100%;
    height: 100vh;
    top: 0;
    left: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: rgba(1, 1, 1, 0.5);
  }

  header .navigation .navigation_items a {
    color: #222;
    font-size: 1.2em;
    margin: 20px;
  }

  header .navigation .navigation-items a::before {
    background: #222;
    font-size: 1.2em;
    height: 20px;
  }

  header .navigation .navigation_items {
    background: #fff;
    width: 600px;
    max-width: 600px;
    margin: 20px;
    padding: 40px;
    display: flex;
    flex-direction: column;
    align-items: center;
    border-radius: 5px;
    box-shadow: 0 5px 25px rgb(1 1 1 / 20%);
  }

  .menu-btn {
    background: url(menu.png) no-repeat;
    background-size: 30px;
    background-position: center;
    width: 40px;
    height: 40px;
    cursor: pointer;
    transition: 0.3s ease;
  }

  .menu-btn.active {
    z-index: 999;
  }
}


    
    </style>
  </head>
  <body>
    <header>
      <a href="index.html" class="brand">E ^ SHOPPERS</a>
      <div class="menu-btn"></div>
      <div class="navigation">
        <div class="navigation_items">
          <a href="register">Home</a>
          <a href="#">About</a>
          <a href="productList">Start Shopping</a>
          <a href="register">Register</a>
          <a href="#">Login</a>
          <a href="#">Contact</a>
          <a href="productList">Product List</a>
        </div>
      </div>
    </header>

    <section class="home">
      <img class="video-slide active" src="https://wallpaperaccess.com/full/2483962.jpg">
      <img class="video-slide" src="https://wallpaperaccess.com/full/1637221.jpg">
      <img class="video-slide" src="https://wallpaperaccess.com/full/5671120.jpg">
      <img class="video-slide" src="https://www.concentrix.com/wp-content/uploads/2022/10/VOC_CaseStudy_FastlyB2B_Thumbnail.jpg">
      <img class="video-slide" src="https://static.vecteezy.com/system/resources/previews/001/990/179/original/online-delivery-service-background-concept-e-commerce-concept-red-scooter-smartphone-and-map-pin-illustration-free-vector.jpg">

      <!-- <video class="video-slide active" src="videos/shopping.mp4" autoplay muted loop></video>
      <video class="video-slide" src="videos/clothes.mp4" autoplay muted loop></video>
      <video class="video-slide" src="videos/unboxing.mp4" autoplay muted loop></video>
      <video class="video-slide" src="videos/happy.mp4" autoplay muted loop></video>
      <video class="video-slide" src="videos/shop go.mp4" autoplay muted loop></video> -->
      <div class="content active">
        <h1>Welcome <br /><span>E^shoppers.</span></h1>
        <p>
         E^Shoppers is one place to go site for all your needs.<br />
          Best Brands and Prices for your desires<br />
          Keep shopping.
        </p>
        <!-- <a href="#">Read More</a> -->
      </div>
      <div class="content">
        <h1>Fashion<br /><span>Brands & Trends</span></h1>
        <p>
          New, Branded, Trending Fashion products .<br />
          To all from A-2-Z.<br />Never
          Have a refreshing expeirnece.
        </p>
        <!-- <a href="#">Read More</a> -->
      </div>
      <div class="content">
        <h1>Unboxing<br /><span>Happiness</span></h1>
        <p>
          Fast Delivery and Fast Response Serivce.<br />
          Your shopping is our main goal.<br />
        </p>
        <!-- <a href="#">Read More</a> -->
      </div>
      <div class="content">
        <h1>Customer<br /><span>Satisfying</span></h1>
        <p>
         Your Satifaction is the Big Acheivement for us.<br />
          Just shop to the fullest.<br />
          
        </p>
        <!-- <a href="#">Read More</a> -->
      </div>
      <div class="content">
        <h1>Start.<br /><span>Shopping</span></h1>
        <p>
          Fast Shopping and Multiple Payment Options.<br />
          Express Delivery.<br />
          Never fails to amaze each and everytime you visit.
        </p>
        <!-- <a href="#">Read More</a> -->
      </div>
      <div class="media-icons">
        <a href="#"><i class="fab fa-facebook-f"></i></a>
        <a href="#"><i class="fab fa-instagram"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
      </div>
      <div class="slider-navigation">
        <div class="nav-btn active"></div>
        <div class="nav-btn"></div>
        <div class="nav-btn"></div>
        <div class="nav-btn"></div>
        <div class="nav-btn"></div>
      </div>
    </section>

    <script>
    const menuBtn = document.querySelector(".menu-btn");
    const navigation = document.querySelector(".navigation");
    

    menuBtn.addEventListener("click", () => {
      menuBtn.classList.toggle("active");
      navigation.classList.toggle("active");
    });

    //javascript for the video slider navigation
    const btns = document.querySelectorAll(".nav-btn");
    const slides = document.querySelectorAll(".video-slide");
    const contents = document.querySelectorAll(".content");

    var sliderNav = function (manual) {

      btns.forEach((btn) => {
        btn.classList.remove("active");
      });

      slides.forEach((slide) => {
          slide.classList.remove("active");
      });

      contents.forEach((content) => {
          content.classList.remove("active");
      });
      
      btns[manual].classList.add("active");
      slides[manual].classList.add("active");
      contents[manual].classList.add("active");

    };
    btns.forEach((btn, i) => {
      btn.addEventListener("click", () => {
        sliderNav(i);
      });
    });
    </script>
  </body>
</html>
