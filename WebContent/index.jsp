<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- 

VIEW
index.jsp:

Login screen.
 
-->


 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TE|Twitter: LOGIN</title>
<script type="text/javascript">
	function ValidateLoginForm() {
		var id = document.LoginForm.userId;
		var pass = document.LoginForm.password;

		if (id.value == "") {
			window.alert("Please enter a user ID.");
			id.focus();
			return false;
		}

		if (pass.value == "") {
			window.alert("Please enter a user password.");
			id.focus();
			return false;
		}

		return true;
	}
	
	
</script>

</head>
<br><br>
<div align="center"><h1>TE TWITTER API</h1></div>
<br><br>

<body>
	<p>${errMsg}</p>
	<div align="center">
	<form method = "POST" name="LoginForm" action="login" onsubmit="return ValidateLoginForm();" >
		<br/><b>Username:<b><p><input type="text" name="userId" placeholder="User name"/></p>
		<br/><b>Password:<b><p><input  type="password"  name="password" placeholder="Password"/></p>
		<br/><p><input type="submit" name= "submit" value="Log In" /></p>
	</form>
	</div>
</body>
</html>