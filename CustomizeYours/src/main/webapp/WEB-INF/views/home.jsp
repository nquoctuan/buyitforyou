<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page session="true" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
    
	<p align="right">  
		<small>
			<sec:authorize access="!isAuthenticated()">
				<a href='<spring:url value="/login.htm"/>'>Login</a>
			</sec:authorize>
		</small>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<small><a href='<spring:url value="/admin/dashboard.htm"/>'>Admin Dashboard</a></small>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<small><a href='<spring:url value="/j_spring_security_logout"/>'>Logout</a></small>
		</sec:authorize>
	</p>
	<h1 class="centerTitle">
		Welcome to our online store
	</h1>
	
  </tiles:putAttribute>
</tiles:insertDefinition>