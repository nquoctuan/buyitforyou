<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true" %>
<html>
<head>
	<title>Security Section</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/flick/jquery-ui.css" />
	<link rel="stylesheet" href='<spring:url value="/resources/main.css" />' />
	<script>
		// Shorthand for $( document ).ready()
		$(function() {
			$("#submitButton").button({
				icons: {
				    primary: "ui-icon-play"
				  }
			}).click(function(event){
				$("#loginForm").submit();
			});
			
			$("#signupButton").button({
				icons: {
				    primary: "ui-icon-person"
				  }
			});
		});
	</script>
</head>
<body>
	<h1 class="centerTitle">
		We do customize for your favorite shirts
	</h1>
	<div align="center">
		<form id="loginForm" action='<spring:url value="j_spring_security_check" />' method="post">
			<fieldset>
				<legend class="ui-icon-person">Login</legend>
				<p><label for="username" class="field">User name:</label><input type="text" name="username"></p>
				<p><label for="password" class="field">Password:</label><input type="password" name="password"></p>
				<p>
					<small><a id="submitButton" href="#">Login</a></small>
					<small><a id="signupButton" href='<spring:url value="/signup.htm" />'>Sign up</a></small>
				</p>
			</fieldset>
		</form>
	</div>	
	
</body>
</html>
