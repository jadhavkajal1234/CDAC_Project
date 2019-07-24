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
				<td>Enter User Email</td>
				<td><sf:input path="email" /></td>
				<td><sf:errors path="email" /></td>
			</tr>
			<tr>
				<td>Enter User Name</td>
				<td><sf:input path="name" /></td>
				<td><sf:errors path="name" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><sf:password path="password" /></td>
				<td><sf:errors path="password" /></td>
			</tr>
			
			
			<tr>
				<td>Enter Address</td>
				<td><sf:input  path="address" /></td>
			</tr>
			
			<tr>
				<td>Enter Mobile No</td>
				<td><sf:input  path="phonenumber" /></td>
				<td><sf:errors path="phonenumber" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Register Me" /></td>


			</tr>
			
		</table>
	</sf:form>

</body>
</html>