<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipping Details Form</title>
<style>
table {
  border-collapse: collapse;
}

table, td, th {
  border: 1px solid black;
}
</style>

</head>

<body>

<form:form modelAttribute="shippingInfo" method="post" action="submitShipping">

	<table>
		<tr>
			<th>Name</th>
			<th>Address Line 1</th>
			<th>Address Line 2</th>
			<th>City</th>
			<th>State</th>
			<th>Zip</th>
		</tr>
		<tr>
			<td><form:input path="name" /></td>
			<td><form:input path="addressLine1" /></td>
			<td><form:input path="addressLine2" /></td>
			<td><form:input path="city" /></td>
			<td><form:input path="state" /></td>
			<td><form:input path="zip" /></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form:form>

</body>
</html>