<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@page isELIgnored="false"%> <%@taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Customer Registration</title>
    <!---Custom CSS File--->
    <style type="text/css">
      /* Import Google font - Poppins */
      @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap");

      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: "Poppins", sans-serif;
      }

      body {
        min-height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 20px;
        background: rgb(130, 106, 251);
      }

      .container {
        position: relative;
        max-width: 700px;
        width: 100%;
        background: #fff;
        padding: 25px;
        border-radius: 8px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
      }

      .container header {
        font-size: 1.5rem;
        color: #333;
        font-weight: 500;
        text-align: center;
      }

      .container .form {
        margin-top: 30px;
      }

      .form .input-box {
        width: 100%;
        margin-top: 20px;
      }

      .input-box label {
        color: #333;
      }

      .form :where(.input-box input, .select-box) {
        position: relative;
        height: 50px;
        width: 100%;
        outline: none;
        font-size: 1rem;
        color: #707070;
        margin-top: 8px;
        border: 1px solid #ddd;
        border-radius: 6px;
        padding: 0 15px;
      }

      .input-box input:focus {
        box-shadow: 0 1px 0 rgba(0, 0, 0, 0.1);
      }

      .form .column {
        display: flex;
        column-gap: 15px;
      }

      .form .gender-box {
        margin-top: 20px;
      }

      .gender-box h3 {
        color: #333;
        font-size: 1rem;
        font-weight: 400;
        margin-bottom: 8px;
      }

      .form :where(.gender-option, .gender) {
        display: flex;
        align-items: center;
        column-gap: 50px;
        flex-wrap: wrap;
      }

      .form .gender {
        column-gap: 5px;
      }

      .gender input {
        accent-color: rgb(130, 106, 251);
      }

      .form :where(.gender input, .gender label) {
        cursor: pointer;
      }

      .gender label {
        color: #707070;
      }

      .address :where(input, .select-box) {
        margin-top: 15px;
      }

      .select-box select {
        height: 100%;
        width: 100%;
        outline: none;
        border: none;
        color: #707070;
        font-size: 1rem;
      }

      .form button {
        height: 55px;
        width: 100%;
        color: #fff;
        font-size: 1rem;
        font-weight: 400;
        margin-top: 30px;
        border: none;
        cursor: pointer;
        transition: all 0.2s ease;
        background: rgb(130, 106, 251);
      }

      .form button:hover {
        background: rgb(88, 56, 250);
      }
      /*Responsive*/
      @media screen and (max-width: 500px) {
        .form .column {
          flex-wrap: wrap;
        }
        .form :where(.gender-option, .gender) {
          row-gap: 15px;
        }
      }
    </style>
  </head>
  <body>
    <section class="container">
      <header>Customer Registration Form</header>
      <form action="register" class="form" method="post">
        <div class="input-box">
          <label>Full Name</label>
          <input
            type="text"
            value="<c:out value='${customer.customerName}'/>"
            name="customerName"
            placeholder="Enter full name"
            required
          />
        </div>

        <div class="input-box">
          <label>Email Address</label>
          <input
            type="text"
            value="<c:out value='${customer.customerEmail}'/>"
            name="customerEmail"
            placeholder="Enter email address"
            required
          />
        </div>

        <div class="column">
          <div class="input-box">
            <label>Phone Number</label>
            <input
              type="text"
              value="<c:out value='${customer.customerContact}'/>"
              name="customerContact"
              placeholder="Enter phone number"
              required
            />
          </div>
        </div>
        <div class="column">
          <div class="input-box">
            <label>Gender</label>
            <input
              type="text"
              value="<c:out value='${customer.customerGender}'/>"
              name="customerGender"
              placeholder="Enter your gender"
              required
            />
          </div>
        </div>
        <h3>Address Details</h3>
        <div class="column">
          <div class="input-box">
            <label>House details</label>
            <input
              type="text"
              value="<c:out value='${address.houseDetails}'/>"
              name="houseDetails"
              placeholder="Enter your house details"
              required
            />
          </div>
        </div>
        <div class="column">
          <div class="input-box">
            <label>City</label>
            <input
              type="text"
              value="<c:out value='${address.city}'/>"
              name="city"
              placeholder="Enter your City"
              required
            />
          </div>
        </div>
        <div class="column">
          <div class="input-box">
            <label>State</label>
            <input
              type="text"
              value="<c:out value='${address.state}'/>"
              name="state"
              placeholder="Enter your state"
              required
            />
          </div>
        </div>
        <div class="column">
          <div class="input-box">
            <label>Pincode</label>
            <input
              type="text"
              value="<c:out value='${address.pincode}'/>"
              name="pincode"
              placeholder="pincode"
              required
            />
          </div>
        </div>
        <button type="submit">Register</button>
        <button><a style="color: white;" href="home">Go Back</a></button>
      </form>
    </section>
  </body>
</html>
