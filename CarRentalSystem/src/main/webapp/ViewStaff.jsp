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
	<c:forEach items="${detailedstaffobj}" var="staff">
	<div class="view-car" > <br>
	<div class="img" style="background-image:url(${staff.path}); width: 500px;height: 400px;">
	
	</div>
	<label>StaffID:${staff.staffid}</label>
	<label>Name:${staff.name}</label>
    <label>phone:${staff.phone}</label>
    <label>Email:${staff.email}</label>
    <label>Adharnumber:${staff.aadharnumber}</label>
	
	</div></c:forEach>
	<br> <br>
</body>
</html>