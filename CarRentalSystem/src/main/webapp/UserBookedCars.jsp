<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="DAO.model2" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
   	height: 300px;
   	width: 300px;
   	color:white;
   	margin-left:20px;
   	align-items:center;
   	flex-flow:column;
   	justify-content:space-around;
   	font-weight:bold;
   	background-color: black;
   	margin-top: 10px;
    }
    
    
    </style>
    
</head>
<body>
<% if (session.getAttribute("activeuser") == null)
{
response.sendRedirect("CustomerLogin.jsp");
}  %>
<jsp:include page="CustomerHeader.jsp"></jsp:include>
<%
model2 obj = new model2();
String cusid = session.getAttribute("activeuserid").toString();
obj.userbookedcars(cusid);

session.setAttribute("userbookedcars", obj.bookedcarsobj);
%>

<section class="ftco-section">
    	<div class="container">
    		<div class="row">
    			
    				
    				<c:forEach items="${userbookedcars}" var="car"> 
    				
    				<div class="view-cars">
    				<img alt="" src="${car.path}" width="100px" height="100px">
    				<label>Car Name:${car.carname} ${car.carcomp} </label>
    				<label>CustomerID:${car.cusid}</label>
    				<label>CarNumber:${car.carnumber}</label>
    				<label>From:${car.from}</label>
    				<label>TO:${car.to}</label>
    				<c:set value="${car.from}" var="from" scope="session"></c:set>
    				<c:set value="${car.to}" var="to" scope="session"></c:set>
    				<c:set value="${car.carnumber}" var="carnumberforamt" scope="session"></c:set>
    				<%
    				String from = session.getAttribute("from").toString();
    				String to = session.getAttribute("to").toString();
    				String carnumber = session.getAttribute("carnumberforamt").toString();
    				int days = obj.calculatdays(from, to);
    				long amt = obj.checkamtfordays(carnumber, days);
    				String totalamt = String.valueOf(amt);
    				session.setAttribute("totalamtofbookedcar"+carnumber, totalamt);
    				String pricetopay = session.getAttribute("totalamtofbookedcar"+carnumber).toString();
    				%>
    				<label>Total Amount to Pay:<%= pricetopay %></label>
    				
    				
    				
											
												
										
    				</div>
    				
               		</c:forEach>
    				
    				
				 			
    		</div>
    	</div>
    </section>
    
    <jsp:include page="commonfooter.jsp"></jsp:include>
</body>
</html>