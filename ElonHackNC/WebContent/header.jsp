<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<!--
* Copyright (c) Thomas Robbins, Schuyler Goodwin, Miles Camp, Evan Walmer March 1, 2014
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${param.title}</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/style.css">
</head>
<body>

<c:set var="currentPage" value="${ pageContext.request.requestURI }" scope="session" />
	<div class="header">
		<img src="${pageContext.request.contextPath}/images/hackthis_logo.png" height="35px"/>
		<div class="headerRight">
		<c:choose>
			<c:when test="${ sessionScope.user.username == null}">
					<a
						href="${pageContext.request.contextPath}/Controller?action=login">
						Login</a> | <a
						href="${pageContext.request.contextPath}/Controller?action=createaccount">
						Create Account</a>
				
			</c:when>
			<c:otherwise>
			
				Welcome <a href="${pageContext.request.contextPath}/Controller?action=userprofile"> ${ sessionScope.user.username }</a>!
				
				| <a href="${pageContext.request.contextPath}/logout.jsp"> Logout</a>
			</c:otherwise>
			
		</c:choose>
		</div>
	</div>

	<div class="content">