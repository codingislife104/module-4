<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Details</title>
</head>
<body>
<c:url var="myAction" value="CustReportBycustNum.obj"></c:url>
<form:form action="${myAction}" method="post" modelAttribute="customer">
<c:if test="${isFirst!=true}">
<c:choose>
<c:when test="${c.optionalPack!=null}">	
<h2>Following are details for Customer Number:&nbsp;<c:out value="${c.customerNumber}"/></h2><br>

Base Pack:&nbsp;<c:out value="${c.basePack}"/><br>
OptionalPack:&nbsp;<c:out value="${c.optionalPack}"/>
</c:when>
<c:otherwise>
<h2>Following are details for Customer Number:&nbsp;<c:out value="${c.customerNumber}"/></h2><br>

Base Pack:&nbsp;<c:out value="${c.basePack}"/><br>
OptionalPack:&nbsp;<c:out value="None"/>
</c:otherwise>
</c:choose>
</c:if>
</form:form>
</body>
</html>