<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>


<h1 style="color:red;text-align:center">Register Employee</h1>

<frm:form modelAttribute="emp" >
<table align="center" border="1" bgcolor="cyan">
<tr>
	<td>Employee name</td>
	<td> <frm:input type="text" path="ename"/></td>
</tr>
<tr>
	<td>Employee Job</td>
	<td> <frm:input type="text" path="job"/></td>
</tr>
<tr>
	<td>Employee salary</td>
	<td> <frm:input type="text" path="sal"/></td>
</tr>
<tr>
	<td> <input type="submit" value="Add Employee"/></td>
	<td> <input type="reset" value="Cancel"/></td>
</tr>
</table>
</frm:form>