<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="beans.*"%>
<c:import url="header.jsp">
	<c:param name="title" value="Elon HackNC Homepage" />
</c:import>

<sql:setDataSource var="ds" dataSource="jdbc/elonhackdb" />

<!--  c:set scope="page" var="user" value="${session.user}" /-->
<c:set scope="page" var="user" value="<%User user = new User("ewalmer",
		"ewalmer@elon.edu", "password", "git.hub/ewalmer", "", "www.elon.edu")%>" />
<c:choose>
	<c:when test="${not empty user }">
		<table class="userTable">
			<tr>
				<td width="300"><img src="./images/userPicture.png"
					alt="./images/userPicture.png" width="200"></td>

				<td>
					<table>
						<tr>
							<td><c:out value="${user.username}"/></td>
						</tr>
						<tr>
							<td>Email: <ahref""><c:out value="${user.email}"/></a></td>
						</tr>
						<tr>
							<td>Github: <ahref""><c:out value="${user.github}"/></a></td>
						</tr>
						<tr>
							<td>Website: <ahref""><c:out value="${user.personalWeb}"/></a></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<p>
			<strong>About Me:</strong>
		</p>
		<p>insert user about me here</p>

		<table class="userTable">
			<tr>
				<td width="300">
					<table>
						<tr>
							<td>Hackathons Attended</td>
						</tr>

					</table>

				</td>

				<td></td>
			</tr>
		</table>

	</c:when>
	<c:otherwise>
		<%
			request.getRequestDispatcher("/Controller").forward(
								request, response);
		%>
	</c:otherwise>
</c:choose>
<br />
<c:import url="footer.jsp" />