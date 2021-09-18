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

<jsp:include page="commonheader.jsp"></jsp:include>


 <section class="hero-wrap hero-wrap-2" style="background-image: url('images/pic7.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs mb-2"><span class="mr-2"><a href="index.jsp">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>New User<i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-0 bread">New User</h1>
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
										<h3 class="mb-4">New User</h3>
										<div id="form-message-warning" class="mb-4"></div>
										
										<!-- to upload aadhar file -->
											<form action="useraadharupload" method="post" enctype="multipart/form-data">
							
											<%
											if (session.getAttribute("useraadharnumber") == null)
											{
											%>
											
											<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">Aadhar Number</label>
															<input type="text" class="form-control" name="aadharnum" id="subject" placeholder="Aadhar Number" required>
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">File Upload</label>
														<input type="file" class="form-control" name="filename" id="filename">
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<input type="submit" value="Upload Aadhar" class="btn btn-primary">
														<div class="submitting"></div>
													</div>
												</div>
												
												<% } else{ %>
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">Aadhar Number</label>
													<label class="label"> <mark> ${useraadharnumber}</mark></label>	
													</div>
												</div><% } %>
												
												
												
											</form>
											
										<!-- end of aadhar upload -->		
																			
										<form method="POST" id="contactForm" name="contactForm" class="contactForm" action="userregister">
											<div class="row">
											<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">First Name</label>
														<input type="text" class="form-control" name="fname" id="fname" placeholder="First Name" required>
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">Last Name</label>
														<input type="text" class="form-control" name="lname" id="lname" placeholder="Last Name" required>
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">Phone Number</label>
														<input type="text" class="form-control" name="phnum" id="name" placeholder="Phone Num" pattern="[0-9]{10}" required>
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">Email ID</label>
														<input type="email" class="form-control" name="emailid" id="name" placeholder="Email ID" required>
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">User Name</label>
														<input type="text" class="form-control" name="uname" id="name" placeholder="User Name" required>
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">Password</label>
														<input type="password" class="form-control" name="pwd" id="subject" placeholder="Password" required>
													</div>
												</div>
												
												
												
												<div class="col-md-12">
													<div class="form-group">
														<input type="submit" value="New User" class="btn btn-primary">
														<div class="submitting"></div>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>								
						</div>
					</div>
			</div>	</div>
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