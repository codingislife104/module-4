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

<form action="ProcessGetProduct.obj" method="post" >
	Product ID: <input type="text" name="productId" />
				<input type="submit" value="Get Product Information" />
</form>

<c:if test="${ product != null}">

	<br/><br/>
	<b>Product Details;</b>
	<br/><br/>

	<table>
		<tr>
			<td>ID:</td>
			<td> ${ product.id } </td>
		</tr>
		<tr>
			<td>Name:</td>
			<td> ${ product.name } </td>
		</tr>
		<tr>
			<td>Price:</td>
			<td> ${ product.price } </td>
		</tr>
		<tr>
			<td>Quantity:</td>
			<td> ${ product.quantity } </td>
		</tr>
		<tr>
			<td>Category:</td>
			<td> ${ product.category } </td>
		</tr>
		<tr>
			<td>Can be Shipped Abroad? :</td>
			<td> ${ product.canBeShippedAbroad } </td>
		</tr>		

	</table>

</c:if>

</body>
</html>









