<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "f"%>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/4.0.0/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

</head>
<body>

<div class="container">
<c:url value="/admin/InsertProduct"  var="addproduct" />
<div class="row">
<div class="col-md-8">
<f:form role="form" action="${addproduct}" enctype="multipart/form-data" method="post" modelAttribute="p">

	<tr bgcolor="orange"><h3><td colspan="2"><b><center>Enter Product Details</center></b></h3></td></tr>
	<div class="form-group">
	<f:hidden path="productid" class="form-control" />
	</div>
	<div class="form-group">
		<label>Product Name</label>
		<f:input path="productname" type="text" class="form-control " />
	</div>
	<div class="form-group">
		<label>Product Desc</label>
		<f:input path="productdesc" type="text" class="form-control"/>
	</div>
	<div class="form-group">
	<label>Price</label>
		<f:input path="productprice" type="text" class="form-control"/>
	</div>
	<div class="form-group">
			<label>Product Image</label>
			<f:input type="file" path="image"  class="form-control"/>
	</div>
	
		<div class="col-md-4"></div>
		<button type="submit" class="btn btn-primary">Insert Product</button>
		</td>
	</tr>

</f:form>
</br>
</div>
		<div class="col-md-4">
		</div>
	</div>
</div>

<div class="container">
<table class="table" align="center" cellspacing="2" border="1">
	<tr bgcolor="orange">
		<td colspan="8"><center>Product Details</center></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Product ID</td>
		<td>Product Name </td>
		<td>Product Desc </td>
		<td>Price </td>
		<td>Image</td>
		<td>Operations</td>
	</tr>
	<c:forEach items="${product}" var="product">
	<tr>
		<td>${product.productid}</td>
		<td>${product.productname}</td>
		<td>${product.productdesc}</td>
		<td>${product.productprice}</td>
		<td><img src="<c:url value="/resources/images/${product.productid}.jpg"  />" width="100 px" height="100 px" /></td>
		<td>
		
			<a href="<c:url value="/admin/editProduct-${product.productid}"/>" >Edit</a>
			<a href="<c:url value="/admin/deleteProduct/${product.productid}" />"> Delete</a>
		</td>
	</tr>	
	</c:forEach>
	
</table>
</div>
</body>
</html>