<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "f"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<c:url value="InsertCategory" var="addcat" />
<f:form action="${addcat}" method="post" modelAttribute="cat">
<table cellspacing="3" align="center">
	<tr bgcolor="orange"><td colspan="2"><center>Enter Category Detail</center></td></tr>
	<tr>
	<td><f:hidden path="categoryId"  /></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><f:input path="categoryName" type="text"  /></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		<td><f:input path="categoryDesc" type="text" name="catDesc" id="catDesc"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<center><input type="submit" value="Insert Category"/></center>
		</td>
	</tr>
</table>
</f:form>

<table align="center" cellspacing="2" border="1">
	<tr bgcolor="orange">
		<td colspan="4"><center>Category Details</center></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Category ID</td>
		<td>Category Name </td>
		<td>Category Desc </td>
		<td>Operations</td>
	</tr>
	<c:forEach items="${categories}" var="category">
	<tr>
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>
		<td>
		
			<a href="<c:url value="/editCategory-${category.categoryId}"/>" >Edit</a>
			<a href="<c:url value="/deleteCategory-${category.categoryId}" />"> Delete</a>
		</td>
	</tr>	
	</c:forEach>
	
</table>


</body>
</html>