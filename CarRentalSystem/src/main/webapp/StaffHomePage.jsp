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
<% if (session.getAttribute("activestaff") == null)
{
response.sendRedirect("Staff_Login.jsp");
}%>
<jsp:include page="StaffHeader.jsp"></jsp:include>

<section class="ftco-section">
    	<div class="container">
    		<div class="row">
    			<div class="col-md-12">
    				<h5 class="font-weight-bold">Online Vehicle rental Management System</h5>
    				<p>Vehicle management system is an automation software for the transportation industry or an organization which owned a large number of vehicle & managing fleet. It is an organized code which provides management functions that permit corporations to get rid of or minimize the risks related to vehicles. It helps a business to boost up some outstanding criteria includes the daily management of vehicles, fuel and services management, HRM system, tracking & managing inventory, Cost management etc. Having the ability to supply glorious reports at any situation, it involves with auditing, formulating technic, making strategy and implementing policies, procedures and systems etc. are considered a fast and straightforward task while you are using ultimate Vehicle Management software system.

Bdtask has designed the most modern Vehicle Management Software to manage large vehicle and fleet. This system process and analyze every single data of your all Vehicles. It is an online based Software which is really helpful for Bus, Car, taxi, Cover Van & Truck operators to manage everyday workflow and performance. It is an online and offline based application, it can be run from anywhere, which is designed by PHP and Codeigniter framework with MySQL. It can be operated from around the world using username and password. In this Vehicle management system, one or more operator can use at a time from anywhere in the world. They can Add, Delete, Edit, any data in the software. </p>
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