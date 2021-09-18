<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="DAO.model" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

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
<% if (session.getAttribute("activeuser") == null)
{
response.sendRedirect("CustomerLogin.jsp");
}%>
	<jsp:include page="CustomerHeader.jsp"></jsp:include>





	<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-12">
				<div class="wrapper">
					<div class="row no-gutters mb-5">
						<div class="col-md-7">
							<div class="contact-wrap w-100 p-md-5 p-4">
								<h3 class="mb-4">Selected Car</h3>
								<div id="form-message-warning" class="mb-4"></div>
								<form method="POST" id="contactForm" name="contactForm"
									class="contactForm" action="bookcar">
									<div class="row">
										
										<!-- customerdetails -->			

										<div class="col-md-12">
											<div class="form-group">
												<label class="label" for="subject">Customer ID</label> <input
													type="text" class="form-control" name="custid" id="custid"
													placeholder="Customer ID" required value="${activeuserid}">
											</div>
										</div>
											
											
											<%
											model obj = new model();
											String cusid = session.getAttribute("activeuserid").toString();
											obj.getuserprofile(cusid);
											session.setAttribute("selectedcaruser", obj.usersobj);
																						
											%>
											
											
										<c:forEach items="${selectedcaruser}" var="user">
										<div class="col-md-12">
											<div class="form-group">
												<label class="label" for="name">Customer Name</label> <input
													type="text" class="form-control" name="cusname"
													id="fullname" placeholder="Customer Name" required
													value="${user.fname} ${user.lname}">
											</div>
										</div>

										<div class="col-md-12">
											<div class="form-group">
												<label class="label" for="name">Phone Number</label> <input
													type="text" class="form-control" name="phnum" id="phnum"
													placeholder="Phone Num" pattern="[0-9]{10}" required
													value="${user.phone}">
											</div>
										</div>

										<div class="col-md-12">
											<div class="form-group">
												<label class="label" for="name">Email ID</label> <input
													type="email" class="form-control" name="emailid" id="emailid"
													placeholder="Email ID" required value="${user.email}">
											</div>
										</div>

										<div class="col-md-12">
											<div class="form-group">
												<label class="label" for="subject">Aadhar Number</label> <input
													type="text" class="form-control" name="aadharnum"
													id="aadharnum" placeholder="Aadhar Number" required
													value="${user.aadharnumber}">
											</div>
										</div>

										<div class="col-md-12">
											<div class="form-group">
												<label class="label" for="subject">Aadhar Image</label> <img
													src="${user.path}" width="100px" height="100px" />
											</div>
										</div>
											</c:forEach>	
											<!-- end of customerdetails -->	
											
											
											<c:forEach items="${userselectedcararray}" var="car">
											
										<div class="col-md-12">
											<div class="form-group">
												<label class="label" for="name">Vehical Number</label> <input
													type="text" class="form-control" name="vehicleid" id="vehicleid"
													placeholder="Bike ID" required value="${car.carnumber}">
											</div>
										</div>
										
										<div class="col-md-12">
											<div class="form-group">
											<input type="hidden" value="${car.path}" name="path">
												<label class="label" for="name">Engine Type</label> <input
													type="text" class="form-control" name="enginetype" id="vehicletype"
													placeholder="Vehicle Type" required value="${car.enginetype}">
											</div>
										</div>

										<div class="col-md-12">
											<div class="form-group">
												<label class="label" for="name">Car Name</label> <input
													type="text" class="form-control" name="carname" id="vehiclename"
													placeholder="Car Name" required value="${car.carname}">
											</div>
										</div>

										<div class="col-md-12">
											<div class="form-group">
												<label class="label" for="name">Company Name</label> <input
													type="text" class="form-control" name="cname" id="cname"
													placeholder="Company Name" required
													value="${car.comp}">
											</div>
										</div>

										

										<div class="col-md-12">
											<div class="form-group">
												<label class="label" for="name">Mileage</label> <input
													type="text" class="form-control" name="mileage" id="mileage"
													placeholder="Mileage" required value="${car.mileage}">
											</div>
										</div>
																										
										<div class="col-md-12">
											<div class="form-group">
												<label class="label" for="subject">Amount/Day</label> <input
													type="number" class="form-control" name="amount"
													id="amount" placeholder="Amount/Day" required
													value="${car.amtperday}">
											</div>
										</div>
										<div class="col-md-12">
											<div class="form-group">
												<label class="label" for="subject">From Date</label> <input
													type="date" class="form-control" name="fromdate"
													id="fromdate" placeholder="From Date" required
													value="">
											</div>
										</div>
										
										<div class="col-md-12">
											<div class="form-group">
												<label class="label" for="subject">To Date</label> <input
													type="date" class="form-control" name="todate"
													id="fromdate" placeholder="To Date" required
													>
											</div>
										</div>
										
										


										<div class="col-md-12">
											<div class="form-group">
												<label class="label" for="subject">Booking Amount</label> 
												<label><mark>500</mark></label>
											</div>
										</div>


										<div class="col-md-12">
											<div class="form-group">
												<input type="submit" value="Make Payment"
													class="btn btn-primary">
												<div class="submitting"></div>
											</div>
										</div></c:forEach>
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
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="js/google-map.js"></script>
	<script src="js/main.js"></script>
</body>
</html>