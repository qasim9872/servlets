<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="servlets.User" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display name</title>
</head>
<body>

	<c:out value="This is using simple scripting"></c:out>	 
	<%
		User user = (User)request.getAttribute("userBean");
		if(user != null){
			%>
				<p>Welcome 	<%= user.getName()%> with the email: <%= user.getEmail() %></p>		
			<%
		}
		else {
			%>
				<p>Welcome new user, please input your details below</p>		
			<%
		}
	%> 
	
	<span style="color:red"><c:out value="This is using if tags of jstl"></c:out></span>
	<c:if test="${!empty userBean.name }">
		<p>Welcome  ${ userBean.name } with the email: ${ userBean.email } %></p>
	</c:if>
	<c:if test="${empty userBean.name }">
		<p>Welcome new user, please input your details below</p>
	</c:if>
	
	<c:out value="This is using choose, when and otherwise tag"></c:out>
	<c:choose>
		<c:when test="${!empty userBean.name }">
			<p>Welcome  ${ userBean.name } with the email: ${ userBean.email } %></p>
		</c:when>
		<c:otherwise>
			<p>Welcome new user, please input your details below</p>
		</c:otherwise>
	</c:choose>
	
	<h1>Welcome  ${ userBean.name } </h1>
	
	Server Version: <%= application.getServerInfo() %><br>
	Servlet Version: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %> <br>
	JSP Version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %> <br>
	

	<form action="home" method="post">
		Name: <input type="text" name="name"> 
		<br><br>
		Email: <input type="text" name="email"> 
		<br><br>
		<input type="submit" value="send">
	</form>
</body>
