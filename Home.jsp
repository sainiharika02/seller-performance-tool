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
 <br><br>
 <center>
 Hello <%=session.getAttribute("name")%><br>
 Your health is <font color="red"><%= session.getAttribute("health")%>%</font><br><br>
 <% int health = (Integer)session.getAttribute("health");
if (health < 100) { %>
Your Health is lacking, <a href = "completeProfile.jsp">Complete now >></a> 
<% } %>
<%
 int performance = (Integer)session.getAttribute("performance");
%>
<br>Your Overall performance is <%=performance%>%
<% if (performance < 80) {%>
		<br>Your performance is lacking<br>
		The current product in trend is <%=session.getAttribute("recommendation")%>
	<%}
%>
</center>
</body>
</html>