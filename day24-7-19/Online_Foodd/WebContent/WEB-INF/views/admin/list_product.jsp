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
	
	<h3>Product List</h3>
	<table style="background-color: cyan; margin: auto;" border="1">


		<c:forEach var="p" items="${requestScope.product_list}">
			<tr>
				<td>${p.name}</td>
				<td>${p.price}</td>
				<td>${p.type}</td>
			
				<td><a href="<spring:url value='/admin/deleteProduct?vid=${p.id}'/>">Delete</a></td>
				<td><a href="<spring:url value='/admin/update?vid=${p.id}'/>">update</a></td>
				
			</tr>
			
		</c:forEach>
		
	</table>
	
	<%-- <h2>
		<a href="<spring:url value='/customer/register'/>">Register New Customer</a>
	</h2> --%>
</body>
</html>