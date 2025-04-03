<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login JSP</title>
</head>
<body>
<%-- My First JSP ${name} --%>
My First JSP ${name}
<%-- <%
System.out.println("Java From JSP");
Date date = new Date();
%>
<div>Current Date is <%=date%></div>
 --%>

<form action="/spring-mvc/login" method="post">
<p><font color="red">${errorMessage}</font></p>
UserName: <input type="text" name="name" /> Password: <input type="password" name="password" /> <input type="submit" name="login" value="Login" /> 
</form>
</body>
</html>