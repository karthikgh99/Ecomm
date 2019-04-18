<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "f"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>


<f:form action="InsertUser" method="post" modelAttribute="u">
<table cellspacing="3" align="center">
	<tr bgcolor="orange"><td colspan="2"><center>Enter User Detail</center></td></tr>
	<tr>
		<td>Name</td>
		<td><f:input path="name" type="text" name="Name" id="Name"/></td>
	</tr>
	<tr>
		<td>UserAddress</td>
		<td><f:input path="useraddress" type="text" name="useradd" id="useradd"/></td>
	</tr>
	
	<td>Phoneno</td>
		<td><f:input path="userphoneno" type="text" name="phoneno" id="phoneno"/></td>
	</tr>
	</tr>
	
	<td>Email</td>
		<td><f:input path="email" type="text" name="email" id="email"/></td>
	</tr>
		<tr>
	
	<td>Password</td>
		<td><f:input path="password" type="password" name="password" id="password"/></td>
	</tr>
	
	<tr>
		<td colspan="2">
		<center><input type="submit" value="Insert User"/></center>
		</td>
	</tr>
</table>
</f:form>



</body>
</html>