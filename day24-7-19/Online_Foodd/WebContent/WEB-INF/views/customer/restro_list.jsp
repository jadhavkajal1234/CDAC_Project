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
	<h3>Restaurant List</h3>
	<table style="background-color: pink; margin: auto;" border="2">


		<c:forEach var="r" items="${requestScope.restro_list}">
			<tr>
				<td>${r.name}</td>
				
				<td>${r.address}</td>
			
				<td><a href="<spring:url value='/customer/product_list?rid=${r.name}'/>">add product</a></td>

			<%-- 	<td><a href="<spring:url value='/customer/product_list?cid=${r.id}'/>">add product</a></td> --%>
				
			</tr>
				
		</c:forEach>
		<a href="<spring:url value='/customer/update?cid=${sessionScope.cust_dtls.id}'/>">Update Customer</a>
		
	</table>
	
</body>
</html>