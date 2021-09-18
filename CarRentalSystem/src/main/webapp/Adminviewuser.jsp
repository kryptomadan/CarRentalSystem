<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="DAO.model" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
label{
color:black;
font-weight: bold;
font-family: sans-serif;
font-size: 25px;
}
</style>

</head>
<body>
<% if (session.getAttribute("activeadmin") == null)
{
response.sendRedirect("AdminLogin.jsp");
}%>
<jsp:include page="adminheader.jsp"></jsp:include>
<section class="ftco-section">
    	<div class="container">
    		<div class="row">
    			<div class="col-md-12">
    				<p>
					<c:forEach items="${admninviewuser}" var="user">
					<div class="contact-wrap w-60 p-md-0 p-0">
										<h3 class="mb-4" style="text-align: center;">User Profile</h3>
										<div id="form-message-warning" class="mb-4"></div>
										
					
										<img alt="" src="${user.path}" width="25%" height="250px" style="margin-left:400px; border-radius: 5px;"> <br>
										<label style="margin-left:400px;">UserID: ${user.cusid}</label> <br>
    									<label style="margin-left:400px;">First Name: ${user.fname}</label> <br>
    									<label style="margin-left:400px;">Last Name: ${user.lname}</label> <br>
    									<label style="margin-left:400px;">Phone: ${user.phone}</label> <br>
    									<label style="margin-left:400px;">Email: ${user.email}</label> <br>
    									<label style="margin-left:400px;">Aadhar Number: ${user.aadharnumber}</label> <br>
    
					
										
					</div>	</c:forEach>
    				</p>
    			</div>    			
    		</div>
    	</div>
    </section>
</body>
</html>