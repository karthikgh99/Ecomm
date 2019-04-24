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
			<c:if test="${p.stock>0}">
			<a href="<c:url value="/InsertCart/${p.productid}" />" ><button type="button" class="btn btn-primary ">
				Add to cart
			</button></a>
			<a href="<c:url value="/payment/${p.productid}" />" >
			<button type="button" class="btn btn-success ">
				Buy now
			</button>
			</a>
			</c:if>
			<c:if test="${p.stock<=0}">
			
			<button type="button" class="btn btn-danger " disabled>
				Sorry,Out of Stock!!!
			</button>
			<br/><br/>
			<a href="<c:url value="/home" />" >
			<button type="button" class="btn btn-warning ">
				Click here to continue shopping with other products 
			</button>
			</a>
			</c:if>
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
				<dd>
					Stock: ${p.stock}
				</dd>
			</dl>
		</div>
	</div>
</div>




</body>
</html>