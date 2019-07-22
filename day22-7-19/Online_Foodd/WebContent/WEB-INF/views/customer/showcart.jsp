<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<h5> ${sessionScope.cust_dtls.name}</h5> --%>
	<h4>Cart Contents</h4>
	<table style="background-color: cyan; margin: auto;" border="1">
		<c:forEach var="pd" items="${sessionscope.cart}">
			<tr>
				<td>${pd.name}</td>
				<td>${pd.description}</td>
				<td>${pd.price}</td>
			</tr>
		</c:forEach>
		<tr>
			<td>Total Cart Value</td>
			<td>${sessionScope.total}</td>
		</tr>
	</table>
	
	<h5>You have logged out....</h5>
	<a href="/customer/login">Visit Again</a>

</body>
</html>