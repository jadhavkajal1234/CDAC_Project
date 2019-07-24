<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
	
	<table style="background-color: pink; margin: auto;" border="2">

            <h3>Product List</h3>
		< <c:forEach var="p" items="${requestScope.product_list}">
			<tr>
			
				<td>${p.name}</td>
				<td>${p.description}</td>
				<td>${p.price}</td>
				<td>${p.type}</td>
				
				
			
				<td><a href="<spring:url value='/customer/addToCart/${p.id}'/>">add to cart</a></td>

		
		
				
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













<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRODUCTS</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/productList.css" media="all">
</head>
<body>
<div class="navbar">
  <a href="index.jsp">FOODIE</a>
  <div class="nav-item">
	<a href="<spring:url value='/customer/login'/>">LOGIN</a>
	<a href="<spring:url value='/customer/logout'/>">LOGOUT</a>
	<a href="<spring:url value='/customer/restro_list'/>">RESTAURANT LIST</a>
	<a href="<spring:url value='/customer/cart'/>">CART</a>
    <a href="#">FAQs</a>
  </div>
 </div>
<div class="box">
<h2>${requestScope.cart_info }</h2>
	<table border="2" class="prodList">
		<thead>
			<th colspan="3">MENU : </th>
		</thead>
		<tbody>
			<c:forEach var="prod" items="${sessionScope.product_list}">
			<tr >
				<td colspan="2">${prod.name}</td>
				<td colspan="1"><a href="<spring:url value='/customer/addToCart?cartProductId=${prod.pid}'/>">Add to cart</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>



 --%>











