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

	<div class="headerWrapper">
		<div class="header">
			<img src="${pageContext.request.contextPath}/images/logo.png" />

			<c:if test="${ sessionScope.user.username == null}">
				<a href="${pageContext.request.contextPath}/Controller?action=login">Click
					here to login</a>
				<br />
				<a
					href="${pageContext.request.contextPath}/Controller?action=createaccount">Click
					here to create an account</a>

			</c:if>

		</div>
	</div>

	<div class="content">