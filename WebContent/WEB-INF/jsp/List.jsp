<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 

VIEW
list.jsp:

Lists the records that can be followed/unfollowed.
 
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TE | People to Follow</title>

</head>
<body>
</br></br></br>
<div align="center">
<c:if test="${empty uList}">
   <p>No users to ${uf} ! <p>
</c:if>

	<table>
		<c:forEach var="ob" items="${uList}">
			<form action="${act}">
			<tr>
					<c:set var = "uID" value="${ob.userid}"></c:set>
					<td><c:out value="${ob.username}" /></td>
					<td><c:out value="|${ob.name}" /></td>
					<td><c:out value="|${ob.email}" /></td>
					<input type="hidden" name="userId1" value="${UID}"/>
					<input type="hidden" name="userId2" value="<c:out value="${uID}"/>"/>
					<td><input type="submit" value="${uf}" /></td>
				</tr>
			</form>
		</c:forEach>
	</table>
</div>
</body>
</html>