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
				<td>Product Name</td>
				<td><sf:input path="name" /></td>
			</tr>
			<tr>
				<td>Enter Description</td>
				<td><sf:input path="description" /></td>
			</tr>
			<tr>
				<td>price </td>
				<td><sf:input path="price"  /></td>
			</tr>
			
			<tr>
				<td>Enter type</td>
				<td><sf:input path="type"  /></td>
			</tr>
			
			
			
			

			<tr>
				<td><input type="submit" value="Update Details" /></td>


			</tr>
		</table>
	</sf:form>

</body>
</html>