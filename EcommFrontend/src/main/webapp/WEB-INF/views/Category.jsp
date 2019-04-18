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


<div class="container-fluid">
<c:url value="/admin/InsertCategory" var="addcat" />
	<div class="row">
		<div class="col-md-8">
			<f:form role="form" action="${addcat}" method="post" modelAttribute="cat">
			
			<div class="form-group">
    <f:hidden path="categoryId"  class="form-control" />
  </div>
			
				<div class="form-group">
					 <label >Category Name</label>
					 <f:input path="categoryName" type="text"   class="form-control " />
				</div>
				
				<div class="form-group">
					<label >Category Desc</label>
					<f:input path="categoryDesc" type="text"  class="form-control" />
				</div>
				
				
				<div class="col-md-4"></div>
				<button type="submit" class="btn btn-primary">Insert Category</button>
				
			</f:form>
		</div>
		<div class="col-md-4">
		</div>
	</div>
</div>


<br/><br/>

<table class="table" align="center" cellspacing="2" border="1">
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
		
			<a href="<c:url value="/admin/editCategory/${category.categoryId}"/>" >Edit</a>
			<a href="<c:url value="/admin/deleteCategory/${category.categoryId}" />"> Delete</a>
		</td>
	</tr>	
	</c:forEach>
	
</table>
</div>

</body>
</html>