<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  
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
</style>
</head>
<body>
<% if (session.getAttribute("activeadmin") == null)
{
response.sendRedirect("AdminLogin.jsp");
}%>
<jsp:include page="adminheader.jsp"></jsp:include>
	<br> <br>
	<c:forEach items="${detailedcararray}" var="car">
	<div class="view-car" > <br>
	<div class="img" style="background-image:url(${car.path}); width: 500px;height: 400px;">
	
	</div>
	<label>Car: ${car.carname}(${car.comp})</label>
    <label>CarNumber: ${car.carnumber}</label>
    <label>Amount per day: ${car.amtperday}</label>
    <label>EngineType: ${car.enginetype}</label>
    <label>Mileage: ${car.mileage}</label>
    <label>Gears: ${car.gears}</label>
	
	</div></c:forEach>
	<br> <br>

</body>
</html>