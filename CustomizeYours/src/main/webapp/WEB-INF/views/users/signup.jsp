<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Signup new user</title>
	
	<!-- jquery and its UI -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/flick/jquery-ui.css" />
	
	<!-- jeasyui for using data grid  -->
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
	<link rel="stylesheet" href='<spring:url value="/resources/main.css" />' />
	<script>
		// Shorthand for $( document ).ready()
		$(function() {
			$("#submitButton").button({
				icons: {
				    primary: "ui-icon-plusthick"
				  }
			});
		});
	</script>
</head>
<body>
	<h1 class="centerTitle">
		Register new user
	</h1>
	<div align="center">
		<form id="createUserForm" action='<spring:url value="/createUser.htm"/>' method="post">
			<fieldset>
				<legend>Create new user</legend>
				<p><label for="username" class="field">User name:</label><input type="text" name="username"></p>
				<p><label for="password" class="field">Password:</label><input type="password" name="password"></p>
				<p><label for="fullName" class="field">Full name:</label><input type="text" name="fullName"></p>
				<p><label for="email" class="field">Email:</label><input type="text" name="email"></p>
				<p>
					<label for="role" class="field">Role</label>
					<select name="role">
						<option value="0">Guest</option>
						<option value="1" selected="selected">Simple User</option>
						<option value="10">Administrator</option>
					</select>
				</p>
				<p>
					<small><button id="submitButton" type="submit">Create</button></small>
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>