<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>View All Product Details</h1>

<br/><br/>

<b>Product Details:</b>
<table>
	<tr>
		<td> ID </td>
		<td> Name </td>
		<td> Price </td>
		<td> Quantity </td>
		<td> Category </td>
		<td> Can Be Shipped Abroad </td>
	</tr>
	
	<c:forEach items="${products}" var="product">
		<tr>
			<td> ${product.id} </td>
			<td> ${product.name} </td>
			<td> ${product.price} </td>
			<td> ${product.quantity} </td>
			<td> ${product.category} </td>
			<td> ${product.canBeShippedAbroad} </td>
		</tr>
	</c:forEach>
	
</table>


</body>
</html>






