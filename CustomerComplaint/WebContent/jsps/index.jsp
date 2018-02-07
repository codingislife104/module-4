<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1 align="center">Customer Complaint Request Form</h1>
<hr/>
 <table align="center">
		<sform:form modelAttribute="maComplaint" action="addComplaint.do">			
			<tr>
				<td>Account Id :* </td>
				<td><sform:input path="accountId" id="accountId" required="true" pattern="[0-9]{5,10}"/></td>
			</tr>
			<tr>
				<td>Branch Code :* </td>
				<td><sform:input path="branchCode" id="branchCode" required="true"/></td>
			</tr>
			<tr>
				<td>Email Id :* </td>
				<td><sform:input path="emailId" id="email" required="true"/></td>
			</tr>			
			<tr>
				<td>Complaint Category :* </td>
				<td><sform:select path="category" required="true">
					<sform:option name="--Select--" value=""></sform:option>
						<c:forEach var="categoryName" items="${categoryList}">
							<sform:option name="${categoryName}" value="${categoryName}"></sform:option>
						</c:forEach>
					</sform:select></td>
			</tr>
			<tr>
				<td>Description :* </td>
				<td><sform:input path="description" id="description" required="true"/></td>
			</tr>			
			<tr align="center">
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
		</sform:form>
	</table> 
	<br/>
	<div align="center"><a href="getCheckStatusForm.do">Check Status</a></div>
</body>
</html>