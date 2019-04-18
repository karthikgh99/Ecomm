<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "f"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<c:url value="InsertProduct"  var="addproduct" />
<f:form action="${addproduct}" enctype="multipart/form-data" method="post" modelAttribute="p">

<table cellspacing="2" align="center">
	<tr bgcolor="orange"><td colspan="2"><center>Enter Product Detail</center></td></tr>
	<tr>
	<td><f:hidden path="productid"  /></td>
	</tr>
	<tr>
		<td>Product Name</td>
		<td><f:input path="productname" type="text" name="proName" id="proName"/></td>
	</tr>
	<tr>
		<td>Product Desc</td>
		<td><f:input path="productdesc" type="text" name="proDesc" id="proDesc"/></td>
	</tr>
	<tr>
	<td>Price</td>
		<td><f:input path="productprice" type="text" name="price" id="price"/></td>
	</tr>
	<tr>
			<td>Product Image</td>
			<td><f:input type="file" path="image" name="pimage" /></td>
	</tr>
	<tr>
		<td colspan="2">
		<center><input type="submit" value="Insert Product"/></center>
		</td>
	</tr>
</table>
</f:form>

<table align="center" cellspacing="2" border="1">
	<tr bgcolor="orange">
		<td colspan="5"><center>Product Details</center></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Product ID</td>
		<td>Product Name </td>
		<td>Product Desc </td>
		<td>Price </td>
		<td>Operations</td>
	</tr>
	<c:forEach items="${product}" var="product">
	<tr>
		<td>${product.productid}</td>
		<td>${product.productname}</td>
		<td>${product.productdesc}</td>
		<td>${product.productprice}</td>
		<td>
		
			<a href="<c:url value="/editProduct-${product.productid}"/>" >Edit</a>
			<a href="<c:url value="/deleteProduct/${product.productid}" />"> Delete</a>
		</td>
	</tr>	
	</c:forEach>
	
</table>


</body>
</html>