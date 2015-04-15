<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="menu">
Menu
    <ul>
        <li>
            <spring:url value="/" var="homeUrl" htmlEscape="true"/>
            <a href="${homeUrl}">Home</a>
        </li>
        <li>
            <spring:url value="/login.htm" var="loginUrl" htmlEscape="true"/>
            <a href="${loginUrl}">Login</a>
        </li>
    </ul>
</div>