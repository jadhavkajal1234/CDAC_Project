<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<sf:form method="post" modelAttribute="customer">
		<table style="background-color: cyan; margin: auto;" border="1">
		<tr>
				<td>Id</td>
				<td><sf:input type="number" path="id" readonly="true" /> </td>
			</tr>
			<tr>
				<td>Enter Customer Name</td>
				<td><sf:input path="name" /></td>
			</tr>
			<tr>
				<td>Your Email </td>
				<td><sf:input path="email" readonly="true" /></td>
			</tr>
			
			<tr>
				<td>Enter Password</td>
				<td><sf:input type="hidden" path="password" showPassword="true" /></td>
			</tr>
			
			
			<tr>
				<td>Enter Address</td>
				<td><sf:input path="address" /></td>
			</tr>
			
			<tr>
				<td>Enter Mobile No</td>
				<td><sf:input path="phonenumber" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update Details" /></td>


			</tr>
		</table>
	</sf:form>

</body>
</html>