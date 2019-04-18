<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class="container-fluid">
	<div class="row">
		<div class="col-md-4">
		<div>
			<img alt="Bootstrap Image Preview" src="<c:url value="/resources/images/${p.productid}.jpg" />" width="250 px" height="250 px" style="display:block" />
			<a href="<c:url value="/InsertCart/${p.productid}" />" ><button type="button" class="btn btn-success ">
				Add to cart
			</button></a>
			<a href="<c:url value="/payment/${p.productid}" />" >
			<button type="button" class="btn btn-success ">
				Buy now
			</button>
			</a>
		</div>
		</div>
		<div class="col-md-8">
			<h3>
				Model: ${p.productname}
			</h3>
			<p>
		Price: Rs.${p.productprice}/-
			</p>
			<dl>
				<dd>
					Description: ${p.productdesc}
				</dd>
				
			</dl>
		</div>
	</div>
</div>




</body>
</html>