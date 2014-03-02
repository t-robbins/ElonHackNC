<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp">
        <c:param name="title" value="Bubble" />
</c:import>

<h2>Title of Bubble</h2>

<c:forEach var="bubble" items="" varStatus="row">

</c:forEach>

<form method="post" action='<%=request.getContextPath() + "/Controller?action=subtopic"%>'>
                
                <input type="hidden" name="action" value="subtopic" />
                
                <h3>Have some thing to add to this Project?</h3>
                <p>
                You are welcome to add an idea or new direction to this project! 
                Fill out the form below!
                </p>
                
               <table>
          <tr>
            <td><input type="text" name="title" value="" placeholder="Title of new idea"/></td>
          </tr>
          <tr>
            <td><textarea name="summary" rows="4" cols="50" placeholder="Please type your idea here"></textarea></td>
          </tr>
          <tr>
            <td><input type="submit" name="Submit your idea"></td>
          </tr>
        </table>
                
</form> 
 
 

<c:import url="footer.jsp" />