
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="DAO.model2" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<style type="text/css">
body {
	color: black;
	background-color: white;
}


</style>
<script type="text/javascript">
function gotoservlet()
{
	let a= document.createElement('a');
	a.target= '_blank';
	a.rel="noopener noreferrer"
	a.href= 'paidforbooking';
	a.click();
	}
</script>

</head>
<body>
<% if (session.getAttribute("activeuser") == null)
{
response.sendRedirect("CustomerLogin.jsp");
}%>
	<jsp:include page="CustomerHeader.jsp"></jsp:include>
	<section class="ftco-section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
					
				<p>
					
				</p>

				<p>
				 
				 <%
				 model2 obj = new model2();
				String carnumber= session.getAttribute("bookingcarnumber").toString();
				 if(obj.ifpaid(carnumber))
				 {
				 %>
				 
				 
				 <h1>After Payment Please refresh</h1>
				 <button onclick="gotoservlet();"><a  target="_blank"  href="https://test.instamojo.com/@lokeshv_261/lfa625d26770c42dabf9dad4476d7e1fd/" rel="im-checkout" data-text="Pay 500 to Book now" data-css-style="color:#ffffff; background:#004dcf; width:300px; border-radius:4px"   data-layout="vertical"  ></a></button>
				<script src="https://js.instamojo.com/v1/button.js"></script>
				<% } else{%>

				<h1>Thank You Your car ${bookingcarname} is Booked Please visit the office</h1>
				
				<% } %>
				</p>
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