<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome 
<c:choose>
<c:when test="${!empty userBean.name}">
${ userBean.name } with Email ${ userBean.email }
</c:when>
<c:otherwise>
new user
</c:otherwise> 
</c:choose>

</h1>

<form action="uploadFile" method="post" enctype="multipart/form-data">

<table>
<tr>
<td> Name: </td> <td> <input type="text" name="name"> </td>
</tr>

<tr>
<td> Email: </td> <td> <input type="text" name="email"> </td>
</tr>

<tr>
<td colspan="2"> <input type="file" name="file" size="60"> </td>
</tr>

<tr>
<td> <input type="submit" name="submitBtn" value="upload"> </td>
</tr>
</table>

</form>

</body>
</html>