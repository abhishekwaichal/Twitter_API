<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TE|Twitter: MENU</title>
</head>
<body>


<br><br>
<div align="center"><h1>Welcome @username</h1>
<br><br><h3>@userid @name @email </h3>
<br><br>

<p>	<form action="readTweets?userId=${userID}">
<%-- <input type="text" name="userId" value="${userId}"/> --%>
<input type="submit" value="Get Tweets" />
</form> 


<%-- <a href="readTweets/?userId=${userID}">GetTweets</a> --%>
<!-- <p>	<form action="readSpecificTweets"><input type="submit" value=" Get specific Tweets" /></form>  -->
<a href="readSpecificTweets/?userId=${userID}">Get specific Tweets</a>

<!-- <p>	<form action="listfollowers"><input type="submit" value=" Get followers" /></form> -->
<a href="listfollowers/?userId=${userID}">Get followers</a>

<!-- <p>	<form action="listfollowing"><input type="submit" value=" Get your followed" /></form>  -->
<a href="listfollowing/?userId=${userID}">Get your followed</a>

<!-- <p>	<form action="listpeople"><input type="submit" value=" View People to follow" /></form> -->
<a href="listpeople/?userId=${userID}">View People to follow</a>
		
</div>	
</body>
</html>