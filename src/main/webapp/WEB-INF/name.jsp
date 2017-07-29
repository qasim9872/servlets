<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="servlets.User" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display name</title>
</head>
<body>

	 
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
	
	

	<form action="home" method="post">
		Name: <input type="text" name="name"> 
		<br><br>
		Email: <input type="text" name="email"> 
		<br><br>
		<input type="submit" value="send">
	</form>
</body>
</html>