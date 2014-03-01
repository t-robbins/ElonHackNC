<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<c:import url="header.jsp">
	<c:param name="title" value="Create an Account" />
</c:import>
 
   
 
 <h2> Create your Account</h2>
 <br />
<form method="post"
			action="<%=request.getContextPath() + "/Controller?action=createaccount"%>">
			<input type="hidden" name="action" value="createaccount" />
			<table>
				<tr>
					<td class="align-right">Email Address:</td>
					<td><input type="text" name="email" 
						value="<%=request.getAttribute("email") == null ? "" : request.getAttribute("email")%>"/></td>
				</tr>
				<tr>
					<td class="align-right">Username:</td>
					<td><input type="text" name="username" 
						value="<%=request.getAttribute("username") == null ? "" : request.getAttribute("username")%>"/></td>
				</tr>
				<tr>
					<td class="align-right">Password:</td>
					<td><input type="password" name="password"
						value="<%=request.getAttribute("password") == null ? "" : request.getAttribute("password")%>"/></td>
				</tr>
				<tr>
					<td class="align-right">Repeat Password:</td>
					<td><input type="password" name="repeat"
						value="<%=request.getAttribute("repeat") == null ? "" : request.getAttribute("password")%>"/></td>
				</tr>
				<tr>
					<td class="align-right" colspan="2"><input type="submit"
						value="Create Account" /></td>
				</tr>
			</table>

			<p class="login-error">
				<%=request.getAttribute("message") == null ? "" : request.getAttribute("message") %> </p>
		</form>

   
    
<c:import url="footer.jsp" />