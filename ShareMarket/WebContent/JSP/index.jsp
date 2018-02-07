<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Share price</h1>
	<table border="1">
		<tr>
			<th>Stock</th>
			<th>Quote</th>
		</tr>
		<c:forEach var="stock" items="${list}">
			<tr>
				<td><a href="order.obj?stockName=${stock.stockName}">${stock.stockName}</a></td>
				<td>${stock.quote}</td>
				</tr>
				</c:forEach>
				</table>
</body>
</html>