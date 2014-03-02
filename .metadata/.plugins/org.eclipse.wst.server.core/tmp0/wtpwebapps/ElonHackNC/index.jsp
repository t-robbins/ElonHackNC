<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="./scripts/home.js"></script>


<c:import url="header.jsp">
	<c:param name="title" value="Elon HackNC Homepage" />
</c:import>


<sql:setDataSource var="ds" dataSource="jdbc/elonhackdb" />

<sql:query dataSource="${ds}" sql="select * from hackathon" var="results" />


 <h2><img src="./images/hackthis_logo.png" /></h2>

<div class="screenshot">

</div>

<br>

<div id="accordion">
 <c:forEach var="name" items="${results.rows}" varStatus="row">
   <c:if test="${row.first}">
     <h3>Next 4 Hackathons</h3>
     <div>
   </c:if>
 
     <p><a href="<c:url value="/Controller?hackathon=${name.name}"/>">${name.name}</a><p>
     
   <c:if test="${row.index == 3}" >
     </div>
     <h3>Future Hackathons</h3>
     <div>
   </c:if>
 
   <c:if test="${row.last}">
     </div>
   </c:if>

</c:forEach>
  
</div>

<br>


<div id="footer">

<p>Copyright &copy; ElonHackNC </p>

</div>

</body>
</html>
