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
	<h4>Hello , ${sessionScope.user_dtls.name}</h4>
	<h3>Vendor List</h3>
	<table style="background-color: cyan; margin: auto;" border="1">


		<c:forEach var="v" items="${requestScope.vendor_list}">
			<tr>
				<td>${v.name}</td>
				<td>${v.email}</td>
				<td>${v.city}</td>
				<td><fmt:formatDate value="${v.regDate}" pattern="dd-MM-yyyy" />
				</td>
				<td><a href="<spring:url value='/admin/delete?vid=${v.id}'/>">Delete</a></td>

				<td><a href="<spring:url value='/admin/update?vid=${v.id}'/>">Update</a></td>
			</tr>
		</c:forEach>
	</table>
	<h5>
		<a href="<spring:url value='/admin/register'/>">Register New Vendor</a>
	</h5>
</body>
</html>