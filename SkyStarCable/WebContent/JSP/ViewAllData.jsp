<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View all Data</title>
</head>
<body>
	<c:if test="${sky!=null}">

		<table border="1">
			<tr>
				<th>CustNumber</th>
				<th>Base Pack</th>
				<th>Optional Pack</th>
			</tr>
			<c:forEach items="${sky}" var="sky">
			<c:choose>
    			<c:when test="${sky.optionalPack!=null}">	
				<tr>
					<td><a href="CustReportBycustNum.obj?customerNumber=${sky.customerNumber}">${sky.customerNumber}</a></td>
					<td>${sky.basePack}</td>
					<td>${sky.optionalPack}</td>
				</tr>
				 </c:when> 
				 <c:otherwise>
				 <tr>
					<td><a href="CustReportBycustNum.obj?customerNumber=${sky.customerNumber}">${sky.customerNumber}</a></td>
					<td>${sky.basePack}</td>
					<td>None</td>
					</tr>
					</c:otherwise>
					</c:choose>
			</c:forEach>
		</table>

	</c:if>
</body>
</html>