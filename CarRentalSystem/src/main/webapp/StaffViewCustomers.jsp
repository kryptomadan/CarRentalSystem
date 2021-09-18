
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="DAO.model" %>
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
    
    
      <style type="text/css">
    .view-cars{
    display: flex;
   	height: 60px;
   	width: 95%;
   	color:white;
   	align-items:center;
   	justify-content:space-around;
   	font-weight:bold;
   	background-color: black;
   	margin-top: 10px;
    }
    </style>
    
</head>
<body>
<% if (session.getAttribute("activestaff") == null)
{
response.sendRedirect("Staff_Login.jsp");
}%>
<jsp:include page="StaffHeader.jsp"></jsp:include>

<% model obj = new model();
obj.availabelusers();
session.setAttribute("alluserobjs", obj.usersobj);

%>

<section class="ftco-section">
    	<div class="container">
    		<div class="row">
    			<div class="col-md-12">
    				<h5 class="font-weight-bold">View All Cars Page</h5>
    				<c:forEach items="${alluserobjs}" var="user">
    				<form action="staffviewuser" id="${user.cusid}" method="post">
    				<a href="javascript:{}" onclick="document.getElementById('${user.cusid}').submit();">
    				<div class="view-cars">
    				<label>Name:${user.fname} ${user.lname}</label>
    				<label>CustomerID:${user.cusid}</label>
    				<label>Phone:${user.phone}</label>
    				<label>Email:${user.email}</label>
    				<input type="hidden" value="${user.cusid}" name="userid">
    				
    				</div>
    				</a>
               		</form>
               		</c:forEach>
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