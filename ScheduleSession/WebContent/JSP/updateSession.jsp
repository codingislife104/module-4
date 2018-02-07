<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Update Session</h1>
<form action="update1.obj">
<input type="hidden" name="id" value="${schedule.id}"/>
Session name: <input type="text" name="name" value="${schedule.name}" readonly/>
Duration : <input type="text" name="duration" value="${schedule.duration}"/>
Faculty : <input type="text" name="faculty" value="${schedule.faculty}" />
Role : <select name="mode">
<option value="ILT">ILT</option>
<option value="VC">VC</option>
<option value="WBT">WBT</option>
</select>
<input type="submit" value="Update"/>
</form>
</body>
</html>