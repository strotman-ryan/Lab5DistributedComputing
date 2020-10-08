<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Us</title>

<style>
.EmployeeName{
	color:gray;
	font-size:30px;
}
</style>


</head>
<body>

<jsp:include page="header.jsp" />

<table border=0>
	<tr>
		<td rowspan=3>
		<img src="Images/RyanHeadShot.JPG" alt="Ryan's pretty face">'
		</td>	
		<td>
			<div class="EmployeeName"> Name: Ryan Strotman </div>
		</td>	
	</tr>
	<tr>
		<td > 
			<div>Role: Owner of Bikes For Life and Janitor </div>
		</td>
	</tr>
	<tr>
		<td > 
			<div>Education: M.S in Computer Science and Engineering </div>
		</td>
	</tr>
</table>




<br />

<img src="Images/EliHeadShot.jpg" alt="Eli's not so great face, tbh">
<jsp:include page="footer.jsp" />
</body>
</html>