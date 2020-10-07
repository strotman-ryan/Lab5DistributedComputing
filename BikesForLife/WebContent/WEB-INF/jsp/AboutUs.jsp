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
table {
	border-spacing: 15px 0px;
}
</style>


</head>
<body>

<jsp:include page="header.jsp" />

<table border=0>
	<tr>
		<td rowspan=3>
		<img src="Images/RyanHeadShot.JPG" alt="Ryan's pretty face" width="200px" height="200px">
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
<br />
<br />

<table border=0>
	<tr>
		<td rowspan=3>
		<img src="Images/EliHeadShot.jpg" alt="Eli's not so great face, tbh" width="200px" height="200px">
		</td>	
		<td>
			<div class="EmployeeName"> Name: Eli Vosniak </div>
		</td>	
	</tr>
	<tr>
		<td > 
			<div>Role: Board Chairman and Coffee Guy </div>
		</td>
	</tr>
	<tr>
		<td > 
			<div>Education: B.S. in Computer Science and Engineering - OSU </div>
		</td>
	</tr>
</table>
<jsp:include page="footer.jsp" />
</body>
</html>