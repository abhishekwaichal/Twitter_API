<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TE | People to Follow</title>
</head>
<body>

	<table>
		<c:forEach var="ob" items="${uList}">
			<form action="followuser">
			<tr>
					<td><c:out value="${ob.username}" /></td>
					<td><c:out value="|${ob.name}" /></td>
					<td><c:out value="|${ob.email}" /></td>
					<input type="hidden" name="userId1" value="${UID}"/>
					<input type="hidden" name="userId2" value="4"/>
					<td><input type="submit" value="Follow" /></td>
				</tr>
			</form>
		</c:forEach>
	</table>

</body>
</html>