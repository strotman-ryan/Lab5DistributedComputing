<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="header.jsp" />

<p>Thank you for using Bike for Life </p>
<h1>Where bikes last for a life time!</h1>
<h3>Confirmation code: <%= request.getSession().getAttribute("confNum") %></h3>

<jsp:include page="footer.jsp" />

</body>
</html>