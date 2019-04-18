<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<h1 style="color:green">${logout}</h1>
<p style="color:red">${error}</p>
<c:url value="/j_spring_security_check" var="loginurl" />
<form action="${loginurl}" method="post" modelAttribute="l">
<table class="table" align="center" cellspacing="2" border="3">
	<tr bgcolor="orange">
		<td colspan="8"><center><b><i><h3>Login</center></h3></i></b></td>
	</tr>
</table>
	<div class="form-group">
		<label>Email Id</label>
		<input type="text" name="Name" class="form-control"/>
	</div>
<div class="form-group">
		<label>Password</label>
		<input  type="password" name="password" class="form-control"/>
</div>
	
	<div class="col-md-4">
		<button type="submit" class="btn btn-primary"/>LOGIN</button>
		</div>
		
</form>



		
		</body>
</html>
		