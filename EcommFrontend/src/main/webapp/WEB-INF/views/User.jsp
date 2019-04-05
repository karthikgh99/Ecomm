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
		<td><f:input path="Name" type="text" name="Name" id="Name"/></td>
	</tr>
	<tr>
		<td>UserAddress</td>
		<td><f:input path="useradd" type="text" name="useradd" id="useradd"/></td>
	</tr>
	
	<td>Phoneno</td>
		<td><f:input path="phoneno" type="text" name="phoneno" id="phoneno"/></td>
	</tr>
	</tr>
	
	<td>Email</td>
		<td><f:input path="email" type="text" name="email" id="email"/></td>
	</tr>
		</tr>
	
	<td>Password</td>
		<td><f:input path="password" type="text" name="password" id="password"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<center><input type="submit" value="Insert User"/></center>
		</td>
	</tr>
</table>
</f:form>

<table align="center" cellspacing="3" border="1">
	<tr bgcolor="orange">
		<td colspan="6"><center>User Details</center></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Name</td>
		<td>User Address </td>
		<td>Userphoneno </td>
		<td>Email</td>
		<td>password</td>
		<td>Operations</td>
	</tr>
	<c:forEach items="${userlist}" var="user">
	<tr>
		<td>${user.name}</td>
		<td>${user.useraddress}</td>
		<td>${user.userphoneno}</td>
		<td>${user.email}</td>
		<td>${user.password}</td>
		<td>
		
			<a href="<c:url value="/edituser/${user.email}= "/>" >Edit</a>
			<a href="<c:url value="/deleteUser/${user.email}" />"> Delete</a>
		</td>
	</tr>	
	</c:forEach>
	
</table>


</body>
</html>