<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
  <title>Seller Performance Tool</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="HomePage.html">Seller Performance Tool</a>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="nav navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href=""><%=session.getAttribute("name")%></a>
       </li>
       <li class="nav-item">
        <a class="nav-link" href="Home.jsp">Home</a>
       </li>
        <li class="nav-item">
        <a class="nav-link" href="completeProfile.jsp">Edit Profile</a>
       </li>
       <li class="nav-item">
        <a class="nav-link" href="HomePage.html">Logout</a>
      </li>
    </ul>
   </div>
 </nav>
 <br><br>
 <table class="table table-striped">
 <tbody>
    <tr>
      <th scope="row">Total Sales</th>
      <td><%=session.getAttribute("total_sales") %></td>
    </tr>
    <tr>
      <th scope="row">Products delayed in delivery</th>
      <td><%=session.getAttribute("delivery_delayed") %></td>
    </tr>
    <tr>
      <th scope="row">Products Cancelled</th>
      <td><%=session.getAttribute("products_cancelled") %></td>
    </tr>
    <tr>
      <th scope="row">Customers viewed but not bought</th>
      <td><%=session.getAttribute("customers_viewed") %></td>
    </tr>
     <tr>
      <th scope="row">Added to cart but not bought</th>
      <td><%=session.getAttribute("addedtocart") %></td>
    </tr>
     <tr>
      <th scope="row">Products with defects</th>
      <td><%=session.getAttribute("defect") %></td>
    </tr>
    </tr>
     <tr>
      <th scope="row"> Your Overall performance is</th>
      <td><%=session.getAttribute("performance") %>%</td>
    </tr>
    </tbody>
</table>
  <center>
  <br><br>
  	<% int delay_of_service = (Integer)session.getAttribute("performance");
  		if (delay_of_service > 0) {
  			%>Your Delivery service is poor, opt for <font color="blue">Amazon Delivery Service</font>
  		<%}%><br>
  		</center>