<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TE|Twitter: MENU</title>
<script type="text/javascript">
	function ValidateMenuForm() {
		var text = document.MenuForm.text;
		if (text.value == "") {
			window.alert("Please enter a text term to search specific tweets.");
			text.focus();
			return false;
		}
		return true;
	}
</script>


</head>
<body>
</br></br>
<div align="Right"> 
<a href="/Twitter_API/">LogOut</a> 

</div>

<br><br>
<div align="center"><h1>Welcome @${userName} </h1>
<br><br><h3>${name}<br>${email} </h3>
<br><br>

<%-- <p>	<form action="readTweets?userId=${userID}">
<input type="text" name="userId" value="${userId}"/>
<input type="submit" value="Get Tweets" />
</form> 
 --%>

<a href="readTweets?userId=${userID}">Tweets</a> &nbsp;&nbsp;
<!-- <p>	<form action="readSpecificTweets"><input type="submit" value=" Get specific Tweets" /></form>  -->
<%-- <a href="readSpecificTweets/?userId=${userID}">Get specific Tweets</a> --%>
<!-- <p>	<form action="listfollowers"><input type="submit" value=" Get followers" /></form> -->
<a href="listfollowers?userId=${userID}">Followers</a>&nbsp;&nbsp;
<!-- <p>	<form action="listfollowing"><input type="submit" value=" Get your followed" /></form>  -->
<a href="listfollowing?userId=${userID}">Following</a>&nbsp;&nbsp;
<!-- <p>	<form action="listpeople"><input type="submit" value=" View People to follow" /></form> -->
<a href="listpeople?userId=${userID}">Follow People</a>&nbsp;&nbsp;
<a href="listpeople1?userId=${userID}">UnFollow People</a>&nbsp;&nbsp;

<br>
<p>
	<form name="MenuForm" action="readSpecificTweets" onsubmit="return ValidateMenuForm();">
	<input type="text"  name="text" placeholder="SearchTerm" >
	<input type="hidden"  name="userId" value = "${userID}" >	
	<input type="submit" value=" Get specific Tweets" >
	</form>
</p>		
</div>	
</body>
</html>