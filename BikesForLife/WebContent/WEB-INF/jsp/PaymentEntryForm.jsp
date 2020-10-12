<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Details Form</title>

</head>

<body>

<jsp:include page="header.jsp" />

<form:form modelAttribute="payment" method="post" action="submitPayment">

	<table class="entry-table">
		<tr>
			<th>Credit Card Number</th>
			<th>Expiration Date</th>
			<th>CVV Code</th>
			<th>Cardholder name</th>
		</tr>
		<tr>
			<td><form:input path="creditCardNumber" /></td>
			<td><form:input path="expirationDate" /></td>
			<td><form:input path="cvvCode" /></td>
			<td><form:input path="cardholderName" /></td>
		</tr>
		<tr>
			<td colspan="4"><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form:form>
<jsp:include page="footer.jsp" />
</body>
</html>