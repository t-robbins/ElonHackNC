<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logging out</title>
</head>
<body>


<%@page import="beans.User" %>

<% 
	User user = (User) session.getAttribute("user");  
	user.setUsername(null);
	
	String current = (String) session.getAttribute("currentPage");
	
	String redirectURL = current;
	
    response.sendRedirect(redirectURL);
%>

</body>
</html>