<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- import JSTL supplied formatting tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome......!!!!1</title>
</head>
<body>
	<h4>Hello , ${sessionScope.cust_dtls.name}</h4>
	<h3>Product List</h3>
	<table cellpadding="2" cellpadding="2" style="background-color: pink; margin: auto;" border="2" >



	<tr>
				<td>name</td>
				<td>description</td>
				<td>price</td>
				<td>type</td>
				</tr>


		  <c:forEach var="p" items="${requestScope.product_list}">
		 
			<tr>
				<td>${p.name}</td>
				<td>${p.description}</td>
				<td>${p.price}</td>
				<td>${p.type}</td>
				<td align="center"><a href="${pageContext.request.contextPath }/shoppingcart/addnow/${p.id}" }> add now</a></td>
				
			
				<%-- <td><a href="<spring:url value='/customer/order_list?pid=${p.name}'/>">add to cart</a></td> --%>

		
		
				
			</tr>
		</c:forEach>  
	</table>
	<%-- <form:form action="/Online_Foodd/customer/addcart" method="GET"  modelAttribute="products" >
	 <form:checkboxes items="${requestScope.product_list}" itemLabel="name" path="item" delimiter="<br>"/>
		<br/><br/> 
		<input type="submit" value="Add To Cart"/>
	</form:form> --%>
</body>
</html>