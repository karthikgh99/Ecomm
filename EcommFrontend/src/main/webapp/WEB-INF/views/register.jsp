<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "f"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<table class="table" align="center" cellspacing="2" border="3">
	<tr bgcolor="orange">
		<td colspan="8"><center><b><i><h3>Register</center></h3></i></b></td>
	</tr>
</table>
	
<f:form action="InsertUser" method="post" modelAttribute="u">

	<div class="form-group">
		<label>Name</label>
		<f:input path="name" type="text" class="form-control "/>
		</div>
	<div class="form-group">
		<label>UserAddress</label>
		<f:input path="useraddress" type="text" class="form-control "/>
	</div>
	<div class="form-group">
	<label>Phoneno</label>
		<f:input path="userphoneno" type="text" class="form-control "/>
	</div>
	<div class="form-group">
	<label>Email</label>
		<f:input path="email" type="text" class="form-control "/>
	</div>
	<div class="form-group">
	<label>Password</label>
		<f:input path="password" type="password" class="form-control "/>
	</div>
	
	<div class="col-md-4"></div>
		<center><button type="submit" class="btn btn-primary">Insert User</button></center>
		
</f:form>



</body>
</html>