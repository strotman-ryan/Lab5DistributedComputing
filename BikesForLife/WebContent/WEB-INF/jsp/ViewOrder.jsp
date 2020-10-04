<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Purchase Order</title>
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

	<!-- Items Table -->
	<table>
		<tr>
			<th colspan="3" align="center">Items</th>
		</tr>
		<tr>
			<th>Item</th>
			<th>Price</th>
			<th>Quantity</th>
		<c:forEach items="${order.items}" var="item" varStatus="loop">
		<tr>
			<td><jsp:text>${order.items[loop.index].name}</jsp:text></td>
			<td>$<jsp:text>${order.items[loop.index].price}</jsp:text></td>
			<td><jsp:text>${order.items[loop.index].quantity}</jsp:text></td>
		</tr>
		</c:forEach>
	</table>
	
	<br />
	<br />
	
	<!-- Payment Info Table -->
	<table>
		<tr>
			<th colspan="4" align="center">Payment Information</th>
		</tr>	
		<tr>
			<th>Credit Card Number</th>
			<th>Expiration Date</th>
			<th>CVV Code</th>
			<th>Cardholder Name</th>
		</tr>
		<tr>
			<td><jsp:text>${payment.creditCardNumber}</jsp:text></td>
			<td><jsp:text>${payment.expirationDate}</jsp:text></td>
			<td><jsp:text>${payment.cvvCode}</jsp:text></td>
			<td><jsp:text>${payment.cardholderName}</jsp:text></td>
		</tr>
	</table>
	
	<br />
	<br />
	
	<!-- Shipping Info Table -->
	<table>
		<tr>
			<th colspan="6" align="center">Shipping Information</th>
		</tr>
		<tr>
			<th>Name</th>
			<th>Address Line 1</th>
			<th>Address Line 2</th>
			<th>City</th>
			<th>State</th>
			<th>Zip</th>
		</tr>
		<tr>
			<td><jsp:text>${shippingInfo.name}</jsp:text></td>
			<td><jsp:text>${shippingInfo.addressLine1}</jsp:text></td>
			<td><jsp:text>${shippingInfo.addressLine2}</jsp:text></td>
			<td><jsp:text>${shippingInfo.city}</jsp:text></td>
			<td><jsp:text>${shippingInfo.state}</jsp:text></td>
			<td><jsp:text>${shippingInfo.zip}</jsp:text></td>
		</tr>
	</table>
	
	<br />
	
	<form:form method="post" action="confirmOrder">
		<input type="submit" value="Confirm">
	</form:form>
</body>
</html>