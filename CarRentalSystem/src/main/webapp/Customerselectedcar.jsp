<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="DAO.model" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
.view-car{
display: flex;
width: 40%;
height: 600px;
flex-flow: column;
align-items: center;
justify-content: center;
color:white;
font-weight:bold;
margin:0 auto;
background-color: black;

}

button{
color:white;
height:30px;
width:120px;
ouline:none;
background: none;
border:none;
border:2px solid green;
}
button:hover{
background-color: green;
}
</style>
</head>
<body>
<% if (session.getAttribute("activeuser") == null)
{
response.sendRedirect("CustomerLogin.jsp");
}%>
<jsp:include page="CustomerHeader.jsp"></jsp:include>
<br> <br>
	<c:forEach items="${userselectedcararray}" var="car">
	<div class="view-car" > <br>
	<div class="img" style="background-image:url(${car.path}); width: 500px;height: 400px;">
	
	</div>
	<label>Car: ${car.carname}(${car.comp})</label>
    <label>CarNumber: ${car.carnumber}</label>
    <label>Amount per day: ${car.amtperday}</label>
    <label>EngineType: ${car.enginetype}</label>
    <label>Mileage: ${car.mileage}</label>
    <label>Gears: ${car.gears}</label>
	<br>
	<a href="CustomerSearchCars1.jsp"><button>Select Car</button> </a> <br> 
	</div></c:forEach>
	<br> <br>


</body>
</html>