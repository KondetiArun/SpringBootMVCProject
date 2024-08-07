<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${!empty empsData}">

	<table border="1" bgcolor="cyan" align="center">
	<tr style=" color:red; bgcolor:yellow">
		<th>empno</th><th>emp Name</th><th>emp Job</th><th>emp sal</th><th>Operations</th>
	</tr>
	<c:forEach var="emp" items="${empsData}">
	
	<tr>
		<td>${emp.empno}</td>
		<td>${emp.ename }</td>
		<td>${emp.job}</td>
		<td>${emp.sal}</td>
		
		<td><a href="edit?no=${emp.empno}"><img src="images/edit.jpg" width="40px" height="40px"/></a>
		&nbsp;&nbsp;<a href="delete?no= ${emp.empno}" onclick="return confirm('Do you want to delete')"><img src="images/delete.jpg" width="40px" height="40px"/></a></td>
	</tr>
	
	</c:forEach>
	
	</table>
</c:when>
<c:otherwise>
	<h1 style="text-align:center;color:red">Records Not Found</h1>

</c:otherwise>
</c:choose>
<h1 style="color:green;text-align:center">${resultMsg}</h1>
<h1 style="text-align:center; margin-left:100px">
	<a href="./"><img src="images/home1.jpg" width=80px height=100px/></a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="register"><img src="images/register.jpg" width=150px height=100px/></a>
</h1>