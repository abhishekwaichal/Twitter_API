<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<!-- 

VIEW
Menu.jsp:

Menu Screen.
 
-->
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
<br>
<div align="Right"> 
<a href="/Twitter_API/">LogOut</a> 

</div>

<br>
<div align="center"><h1>Welcome @${userName} </h1>
<br><br><h3>${name}<br>${email} </h3>
<br><br>

<form method = "POST" action="readTweets/?${token}">
<input  type="hidden"  name="userId" value = "${userID}" />
<input type="submit" name= "submit" value="Tweets" />
</form>
&nbsp;&nbsp;

<form method = "POST" action="listfollowers/?${token}">
<input  type="hidden"  name="userId" value = "${userID}" />
<input type="submit" name= "submit" value="Followers" />
</form>
&nbsp;&nbsp;

<form method = "POST" action="listfollowing/?${token}">
<input  type="hidden"  name="userId" value = "${userID}" />
<input type="submit" name= "submit" value="Following" />
</form>
&nbsp;&nbsp;

<form method = "POST" action="listpeople/?${token}">
<input  type="hidden"  name="userId" value = "${userID}" />
<input type="submit" name= "submit" value="Follow People" />
</form>
&nbsp;&nbsp;

<form method = "POST" action="listpeople1/?${token}">
<input  type="hidden"  name="userId" value = "${userID}" />
<input type="submit" name= "submit" value="UnFollow People" />
</form>
&nbsp;&nbsp;

<%-- 
<a href="readTweets?userId=${userID}">Tweets</a> &nbsp;&nbsp;
<a href="listfollowers?userId=${userID}">Followers</a>&nbsp;&nbsp;
<a href="listfollowing?userId=${userID}">Following</a>&nbsp;&nbsp;
<a href="listpeople?userId=${userID}">Follow People</a>&nbsp;&nbsp;
<a href="listpeople1?userId=${userID}">UnFollow People</a>&nbsp;&nbsp;
 --%>
 
<br>
<p>
	<form  method = "POST" name="MenuForm" action="readSpecificTweets/?${token} " onsubmit="return ValidateMenuForm();">
	<input type="text"  name="text" placeholder="SearchTerm" >
	<input type="hidden"  name="userId" value = "${userID}" >	
	<input type="submit" value=" Get specific Tweets" >
	</form>
</p>		
</div>	
</body>
</html>