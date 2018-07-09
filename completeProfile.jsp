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
        <a class="nav-link"><%=session.getAttribute("name")%></a>
       </li>
       <li class="nav-item">
        <a class="nav-link" href="Home.jsp">Home</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="HomePage.html">Logout</a>
      </li>
    </ul>
   </div>
 </nav>
 <div class="container py-8">
    <div class="row">
        <div class="col-md-12">
            <h2 class="text-center text-white mb-4"></h2>
            <div class="row">
                <div class="col-md-6 mx-auto">

                    <!-- form card login -->
                    <div class="card rounded-0">
                        <div class="card-header">
                            <h3 class="mb-0">My Profile</h3>
                        </div>
                        <div class="card-body">
                            <form action = "ProfileDataController" method = "post">
                                 <div class="form-group">
                                    <label for="name">Name</label>
                                    <% String value = (String)session.getAttribute("name");
                                    	  if (value == null) {
                                    	      value = "";
                                    	  }
                                    %>
                                    <input type="text" class="form-control form-control-lg rounded-0" name="name" value = <%= value %>>
                                </div>
                                <div class="form-group">
                                    <label>Contact</label>
                                    <% value = (String)session.getAttribute("contact");
                                    	  if (value == null) {
                                    	      value = "";
                                    	  }
                                    %>
                                    <input type="text" class="form-control form-control-lg rounded-0" name ="contact" value = <%= value %>>
                                </div>
                                <div class="form-group">
                                    <label>Aadhar</label>
                                    <% value = (String)session.getAttribute("aadhar");
                                    	  if (value == null) {
                                    	      value = "";
                                    	  }
                                    %>
                                    <input type="text" class="form-control form-control-lg rounded-0" name ="aadhar" value = <%= value %>>
                                </div>
                                <div class="form-group">
                                    <label>Pancard</label>
                                    <% value = (String)session.getAttribute("pancard");
                                    	  if (value == null) {
                                    	      value = "";
                                    	  }
                                    %>
                                    <input type="text" class="form-control form-control-lg rounded-0" name ="pancard" value = <%= value %>>
                                </div>
                                <div class="form-group">
                                    <label>Account number</label>
                                    <% value = (String)session.getAttribute("account_number");
                                    	  if (value == null) {
                                    	      value = "";
                                    	  }
                                    %>
                                    <input type="text" class="form-control form-control-lg rounded-0" name ="account_number" value = <%= value %>>
                                </div>
                                <div class="form-group">
                                    <label>IFSC Code</label>
                                    <% value = (String)session.getAttribute("ifsc_code");
                                    	  if (value == null) {
                                    	      value = "";
                                    	  }
                                    %>
                                    <input type="text" class="form-control form-control-lg rounded-0" name ="ifsc_code" value = <%= value %>>
                                </div>
                                <button type="submit" class="btn btn-success btn-lg float-right">Submit</button>
                            </form>
                        </div>
                        <!--/card-block-->
                    </div>
                    <!-- /form card login -->
                </div>
            </div>
            <!--/row-->
        </div>
        <!--/col-->
    </div>
    <!--/row-->
</div>
</body>
</html>