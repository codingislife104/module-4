<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Schedule Management </h1>

<table>
<tr>
<th>Session name</th>
<th>Duration(Days)</th>
<th>Faculty</th>
<th>Mode</th>
<th>Action</th>
</tr>
<c:forEach var="schedule" items="${list }">
<tr>
<%--  <td>${schedule.id }</td> --%>
<td>${schedule.name }</td>
<td>${schedule.duration }</td>
<td>${schedule.faculty }</td>
<td>${schedule.mode }</td>
<td><a href="update.obj?id=${schedule.id}&name=${schedule.name}&duration=${schedule.duration}&faculty=${schedule.faculty}&mode=${schedule.mode}">Update</a></td>
</tr>


</c:forEach>
</table>
</body>
</html>