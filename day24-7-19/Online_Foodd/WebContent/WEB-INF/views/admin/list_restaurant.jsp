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
	
	<h3>Restaurant List</h3>
	<table style="background-color: cyan; margin: auto;" border="1">


		<c:forEach var="r" items="${requestScope.restaurant_list}">
			<tr>
			<td>${r.restaurantId}</td>
				<td>${r.name}</td>
				<td>${r.address}</td>
				
			
				<td><a href="<spring:url value='/admin/restro_delete?rid=${r.restaurantId}'/>">Delete</a></td>
				<td><a href="<spring:url value='/admin/update_restro?rid=${r.restaurantId}'/>">update</a></td>
				<td><a href="<spring:url value='/admin/add_prod?rid=${r.restaurantId}'/>">Add product</a></td>
				
			</tr>
			
		</c:forEach>
		
	</table>
	
	<%-- <h2>
		<a href="<spring:url value='/customer/register'/>">Register New Customer</a>
	</h2> --%>
</body>
</html>