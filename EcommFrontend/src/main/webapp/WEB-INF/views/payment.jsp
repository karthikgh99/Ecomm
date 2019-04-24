<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/4.0.0/jquery.min.js"></script>
<title>Payment</title>
</head>
<body>


<form action="<c:url value="/order" />" method="post">
<table align="center" class="table table-bordered">
	<tr bgcolor="orange"><td colspan="2">Payment</td></tr>
<tr>
		<td>
		<bgcolor="orange">Payment Mode </bgcolor></td>
		<td>
  		 <input type="radio" class="dropdown" name="payment" >Credit Card
  		 <input type="radio" name="payment" value="COD">Cash On Delivery
  		 <tr bgcolor="cyan">
		<td>Credit Card</td>
		
		<td><input type="text" name="creditcard"/></td>
	</tr>
	
	<tr>
		<td>Expiry Date <input type="text" name="expiry"/></td>
		<td>CVV <input type="text"  name="cvv"/></td>
	</tr>
	
	<tr bgcolor="cyan">
		<td> Name on Card</td>
		<td> <input type="text" name="cname"/></td>
	</tr>
	<tr>
</td>
	</tr>
	
	
	
		<td colspan="2"><center><input type="submit" value="Pay"/></center></td>
	</tr>
	
</table>
</form>
</body>
</html>