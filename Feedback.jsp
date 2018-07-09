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
<style>
.sidenav {
    width: 130px;
    position: fixed;
    z-index: 1;
    top: 60px;
    left: 10px;
    background: #eee;
    overflow-x: hidden;
    padding: 8px 0;
}
.sidenav a {
    padding: 6px 8px 6px 16px;
    text-decoration: none;
    font-size: 15px;
    color: #2196F3;
    display: block;
}

.sidenav a:hover {
    color: #064579;
}



</style>
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
 <div class="sidenav">
  <a>Performance</a>
  <a href="FeedbackDataController">Feedback</a>
  <a href="SalesDataController">Sales</a>
</div>
</body>
<center>
<br>
<u><b>Feedback</b></u><br>
<%=session.getAttribute("feedback")%><br>
</center>
 <br><br>