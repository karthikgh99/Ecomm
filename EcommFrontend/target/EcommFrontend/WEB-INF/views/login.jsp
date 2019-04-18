<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<c:url value="/j_spring_security_check" var="loginurl" />
<form action="${loginurl}" method="post" modelAttribute="l">
<table cellspacing="3" align="center">
	<tr bgcolor="orange"><td colspan="2"><center>Enter Login Details</center></td></tr>
	<tr>
		<td>Email Id</td>
		<td><input type="text" name="Name" id="Name"/></td>
	</tr>
	<tr>
		<td>password</td>
		<td><input  type="password" name="password" id="password"/></td>
	</tr>
	
	<td colspan="2">
		<center><input type="submit" value="LOGIN"/></center>
		</td>
	</tr>
</table>
</form>



		
		</body>
</html>
		