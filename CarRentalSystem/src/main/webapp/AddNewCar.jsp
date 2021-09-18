<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
 
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/ionicons.min.css">
    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<% if (session.getAttribute("activeadmin") == null)
{
response.sendRedirect("AdminLogin.jsp");
}%>
<jsp:include page="adminheader.jsp"></jsp:include>


 <section class="hero-wrap hero-wrap-2" style="background-image: url('images/pic7.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs mb-2"><span class="mr-2"><a href="AdminHomePage.jsp">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Add New Car<i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-0 bread">Add New Car</h1>
          </div>
        </div>
      </div>
    </section>
   	
    <section class="ftco-section">
    	<div class="container">
    		<div class="row justify-content-center">
					<div class="col-md-12">
						<div class="wrapper">
							<div class="row no-gutters mb-5">
								<div class="col-md-7">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<h3 class="mb-4">New Car</h3>
										<div id="form-message-warning" class="mb-4"></div>
										
										<!-- this form is for image uploading -->
													<form action="addcarimage" method="post" enctype="multipart/form-data">
													<% 
													if(session.getAttribute("carnumberforupload")==null)
													{
													%>
													<div class="col-md-12">				
													<div class="form-group">
														<label class="label" for="name">Car Number</label>
														<input type="text" class="form-control" name="carnum" id="name" placeholder="Car Num" required="required" >
													</div>
													</div>
													<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">File Upload</label>
														<input type="file" class="form-control" id="filetype" name="file">
													</div>
													
													</div>
													<div class="form-group">
														<input type="submit" value="Uploadimage" class="btn btn-primary">
														<div class="submitting"></div>
													</div>
													
													<% } else{ %>
													<div class="col-md-12">				
													<div class="form-group">
														<label class="label" for="name">Car Number</label>
														<label class="label"> <mark> ${carnumberforupload}</mark></label>	
														
													</div><% } %>
													
													</form>
													<!-- end of image uploading form -->
										<form method="POST" id="contactForm" name="contactForm" class="contactForm" action="addcar">
											<div class="row">
											
											
											
											
											<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">Car Name</label>
														<input type="text" class="form-control" name="carname" id="cname" placeholder="Car Name" required="required">
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">Company Name</label>
														<input type="text" class="form-control" name="cname" id="cname" placeholder="Company Name" required="required">
													</div>
												</div>
												
												
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">Mileage</label>
														<input type="text" class="form-control" name="mileage" id="name" placeholder="Mileage" required="required">
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">Amount Per Day</label>
														<input type="text" class="form-control" name="amount" id="amount" placeholder="Enter Amount" required="required">
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">How Many Gears</label>
														<!-- <input type="text" class="form-control" name="uname" id="name" placeholder="User Name" required> -->
														<select name="gear_not" class="form-control">
														<option>3</option>
														<option>4</option>
														<option>5</option>
														</select>
													</div>
												</div>
												
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">Petrol/Diesel/Electric</label>
														<select name="ctype" class="form-control"> 
														<option value="Petrol">Petrol</option>
														<option value="Diesel">Diesel</option>
														<option value="Electric">Electric</option>
														</select>
													</div>
												</div>
											
												<div class="col-md-12">
													<div class="form-group">
														<input type="submit" value="Add Car" class="btn btn-primary">
														<div class="submitting"></div>
													</div>
												</div>
												
												
													
												
												
											</div>
										</form>
											
											
											
											
													
													
													
									</div>
								</div>								
						</div>
					</div>
				</div>
    	</div>
    </section>

<jsp:include page="commonfooter.jsp"></jsp:include>

	<script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
</body>
</html>