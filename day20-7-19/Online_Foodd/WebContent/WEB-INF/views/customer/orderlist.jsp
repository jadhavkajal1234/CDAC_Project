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
<title>Welcome......!!!!1</title>
</head>
<body>
	<h4>Hello , ${sessionScope.cust_dtls.name}</h4>
	<h3>Product List</h3>
	<table style="background-color: pink; margin: auto;" border="2">


		<c:forEach var="o" items="${requestScope.order}">
			<tr>
				<td>${o.name}</td>
				<td>${o.description}</td>
				<td>${o.price}</td>
				<td>${o.type}</td>
				
				
			
				<td><a href="<spring:url value='/customer/orderplaced?rid=${p.id}'/>">placed order</a></td>

		
				
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>