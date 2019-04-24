<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>

<div class="container">
<c:if test="${not empty cartlist}">
	<table class="table" align="center" cellspacing="2" border="2">
	<tr bgcolor="orange">
<td colspan="8"><center><b>Cart Details</center></td></b>

<tr bgcolor="cyan">
		<td><b>ProductName</td></b>
		<td><b>Quantity</td></b>
		<td><b>Total Price</td></b>
		<td><b>Operations</td></b>
		
	</tr>
	
	<c:forEach items="${cartlist}" var="cart">
	<form action="<c:url value='/cart/updatecart'></c:url>">
	<tr>
	<input type="hidden" name="cartId" value="${cart.cartId }">
		<td>${cart.product.productname}</td>
	<td><input type="number" name="quantity" value='${cart.quantity }' onchange="this.form.submit()" min="1"></td>	
		
		<td>Rs:${cart.totalprice}/-</td>
		
	<td>	
		<a href="<c:url value="/editCart-${cart.cartId}"/>" >Edit</a>
			<a href="<c:url value="/deleteCart/${cart.cartId}" />"> Delete</a></td>
		
		</tr>
		</form>
		</c:forEach>
		<tr>
		<td colspan="2" align="right"><b>GrandTotal</td></b>
		<td>Rs:${GrantTotal }/-</td><td></td>
		</tr>
		</table>
		<center><a  href="<c:url value="/payment" />" ><button type="button" class="btn btn-success ">
				Buy Now
			</button></a></center>
			</c:if>
			
			<c:if test="${empty cartlist}">
			<h1>Your cart is empty!!!</h1>
			</c:if>
			
			<a  href="<c:url value="/home" />" ><button type="button" class="btn btn-success ">
				Continue Shopping
			</button></a>
		
		</div>
</body>
</html>