<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to SharePrice</h1>
<form action="orderConfirm.obj">
<input type="hidden" name="quote" value="${stock.quote}"/>
<input type="hidden" name="stockName" value="${stock.stockName}"/>
<table border="1">
<tr>
<td>Stock</td><td>${stock.stockName }</td></tr>
<tr><td>Quote</td><td>${stock.quote}</td></tr>
<tr><td>Select Action</td><td><input type="radio" name="selectAction" value="Buy">BUY</td>
<td><input type="radio" name="selectAction" value="sell">SELL</td></tr>
<tr><td>quantity</td><td><input type="text" name="quantity"></td>
</tr>
<tr><td><input type="submit" value="Order"></td></tr>


</table>
</form>
</body>
</html>