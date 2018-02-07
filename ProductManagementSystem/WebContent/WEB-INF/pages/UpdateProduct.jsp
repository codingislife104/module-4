<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ProcessFetchForUpdate.obj" method="post" >
	Product ID: <input type="text" name="productId" />
				<input type="submit" value="Get Product Information" />
</form>


<c:if test="${ product != null}">

	<br/><br/>
	<b>Update Product Details;</b>
	<br/><br/>

<form:form action="ProcessUpdateProduct.obj" method="post" modelAttribute="product"> 

<table>

	<tr>
		<td>ID: </td>
		<td> 	<form:hidden path="id" />
				 ${product.id}
		</td>
	</tr>
	<tr>
		<td>Name: </td>
		<td> 	<form:input path="name" />
				<form:errors path="name" cssClass="ers" /> 
		</td>
	</tr>
	<tr>
		<td>Price: </td>
		<td> 	<form:input path="price" />
				<form:errors path="price" cssClass="ers" /> 
		</td>
	</tr>	
	<tr>
		<td>Quantity: </td>
		<td> 	<form:input path="quantity" />
				<form:errors path="quantity" cssClass="ers" /> 
		</td>
	</tr>
	<tr>
		<td>Category: </td>
		<td> 	
			<form:select path="category">
				<form:option value="">Select a Category</form:option>
				<form:options items="${categories}" /> 
			</form:select> 
		</td>
	</tr>	
	<tr>
		<td>Can be Shipped Abroad: </td>
		<td> 	
			<form:radiobutton path="canBeShippedAbroad" label="Yes" value="yes" />
			<form:radiobutton path="canBeShippedAbroad" label="No" value="no" /> 
		</td>
	</tr>
	<tr>
		<td colspan="2"> 
			<input type="submit" value="Update Product Details" />
			<input type="reset" value="Clear" />
		</td>
	</tr>
</table>

</form:form>

</c:if>


</body>
</html>