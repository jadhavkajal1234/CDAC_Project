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

	<sf:form method="post" modelAttribute="restaurant">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td> Restaurant name</td>
				<td><sf:input path="name" /></td>
				<td><sf:errors path="name" /></td>
			</tr>
			<tr>
				<td> Address</td>
				<td><sf:input path="address" /></td>
				<td><sf:errors path="address" /></td>
			</tr>
			
			
			

			<tr>
				<td><input type="submit" value="Add" /></td>


			</tr>
			
		</table>
	</sf:form>

</body>
</html>