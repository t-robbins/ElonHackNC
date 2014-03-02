<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<c:import url="header.jsp">
	<c:param name="title" value="Login to your account" />
</c:import>

   
<h1> How embarrassing...we can't find the page you're looking for!</h1>

<br />
<img src ="<%=request.getContextPath()  + "/images/404.jpg" %>"/>
    
<c:import url="footer.jsp" />