<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Order Form</title>

</head>
<body>

<jsp:include page="header.jsp" />

<form:form modelAttribute="order" method="post" action="purchase/submitItems">
	
	<p style="color: red; font-size: 18px;"><%= request.getSession().getAttribute("error") %></p>
    <table class="entry-table">
      	<tr>
   			<th>Item</th>
    		<th>Price</th>
    		<th>Quantity</th>
 		</tr>
	<c:forEach items="${order.items}" var="item" varStatus="loop">
		<tr>
			<td><form:input path="items[${loop.index}].name" readonly="true" /></td>
			<td>$<form:input path="items[${loop.index}].price" readonly="true" /></td>
			<td><form:input path="items[${loop.index}].quantity" /></td>
		</tr>
	</c:forEach>

	  <tr>
		<td colspan="3"><input type="submit" value="Purchase"></td>
	  </tr>
	

    </table>
</form:form>
<jsp:include page="footer.jsp" />

</body>
</html>