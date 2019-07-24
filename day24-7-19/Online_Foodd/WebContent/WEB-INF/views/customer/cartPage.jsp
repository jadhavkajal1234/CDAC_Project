<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <body>
<h2>Cart page</h2>
<table>
<tr>
	<th>Added Product in Cart : </th>
</tr>
<c:forEach var="cart" items="${sessionScope.cart_dtls}">
<tr>
 <td>${cart.pid.id}</td> 
<td>${cart.oid.id}</td>
<td>${cart.pid.name }</td>
</tr>
</c:forEach>
<tr>
<a href="<spring:url value='/customer/product_list?restaurantId=${r.rid }'/>">Product List</a>
</table> --%>


<table style="background-color: cyan; margin: auto; border=1" >
	<thead>
	    <tr>
	      <th>Product Id</th>
	      <th >orderId</th>
	      <th >Product name </th>
	    </tr>
	  </thead>
	<c:forEach var="cart" items="${sessionScope.cart_dtls}">
			<tr> 
				<td>${cart.pid.id} </td>
				<td>${cart.oid.id}</td>
				<td>${cart.pid.name}</td>
				
				
				
			</tr>
	</c:forEach>
	
	
</table>
<a href="backlist ">Back To Page</a> </td>
<td> <a href="<spring:url value='/customer/bill?pid=${cart.orderDetailsId}'/>" ><span class="glyphicon glyphicon-log-in"></span>Pay</a> </td>
<td><a href="<spring:url value='/customer/product_list?restaurantId=${r.rid }'/>">Product List</a></td>
</body>
</html>