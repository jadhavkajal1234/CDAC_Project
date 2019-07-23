<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>

</title>
</head>
<body>
<table cellpadding="2" cellpadding="2"  border="2">
<tr>
<th>ID</th>
<th>name</th>
<th>Price</th>
<th>Quantity</th>
<th>sub-total</th>


</tr>
<c.set var="s" value="0"></c.set>
		  <c:forEach var="it" items="${sessionScope.cart}">\
		  <c.set var="s" value="${ s +it.product.price *it.quantity}"></c.set>
		  <tr>
		  <td align="center"><a href="${pageContext.request.contextPath }/shoppingcart/delete/${it.product.id}.html"></a>Delete</a></td>
				<td>${it.product.name}</td>
				<td>${it.product.description}</td>
				<td>${it.product.price}</td>
				<td>${it.product.quantity}</td>
				<td>${it.product.price *it.quantity}</td>
				 <td align="center">Delete</td>
			
		
				
			</tr>
		  </c:forEach>
		  <tr> 
		  <td colspan="5" align="right">Sum</td>
		  <td>"${s}"</td>
		  
		   </tr>
		

</table>


<a href="${pageContext.request.contextPath }/customer/product_list">Continue Shopping</a>

</body>
</html>