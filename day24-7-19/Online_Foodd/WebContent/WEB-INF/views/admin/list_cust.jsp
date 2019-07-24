<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- import JSTL supplied formatting tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${requestScope.status}</h3>
	<h4>Hello , ${sessionScope.cust_dtls.name}</h4>
	<h3>Customer List</h3>
	<table style="background-color: cyan; margin: auto;" border="1">


		<c:forEach var="c" items="${requestScope.cust_list}">
			<tr>
				<td>${c.name}</td>
				<td>${c.email}</td>
				<td>${c.address}</td>
			
				<td><a href="<spring:url value='/admin/delete?vid=${c.id}'/>">Delete</a></td>
				
			</tr>
			
		</c:forEach>
		<h3 align="center"><a href="<spring:url value='/admin/list_product'/>"> Product Details</a></h3>
		<h3 align="center"><a href="<spring:url value='/admin/list_restaurant'/>"> Restaurant Details</a></h3>
	</table>
	<%-- <h2>
		<a href="<spring:url value='/customer/register'/>">Register New Customer</a>
	</h2> --%>
</body>
</html>