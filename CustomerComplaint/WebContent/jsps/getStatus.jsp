<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Status Details</title>
</head>
<body>
	<h1 align="center">Check Status</h1>
	<hr />
	<div align="center">
		<form:form action="checkStatus.do">
			<div>
				<div>
					<b>ComplaintId :</b>
					<input type="text" name="complaintId"id="complaintId" />
				</div>
			</div>
			<br />
			<br />
			<div>
				<div>
					<input type="submit" value="Check Status" />
				</div>
			</div>
			<br />
		</form:form>
		<table border="1">
			<tr>
				<th>Complaint Id</th>
				<th>Description</th>
				<th>Status</th>
			</tr>
			<tr>
				<td>${complaint.complaintId}</td>
				<td>${complaint.description}</td>
				<td>${complaint.status}</td>
			</tr>
		</table>
		<br/>
		<br/> <a href="getRaiseComplaintForm.do">Raise Complaint</a>
	</div>
</body>
</html>