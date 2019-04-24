<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "f"%>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/4.0.0/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>

<title>Order Details</title>
</head>
<body>

<div class="container-wrapper">
    <div class="container">
    
        <div class="row">

<div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">

<div >
<h1 align="center">My orders</h1>
</div>
                        
                  
                       

<div class="row">
<table class="table table-hover" border="1">

<tr>
<td class="text-center">Order Id</td>
                                        
<td class="text-center">Purchase Date</td>
<td class="text-center">Grand Total</td>
</tr>

                                
                              
                                 
<c:forEach var="o" items="${orderlist}">
<tr>
                                   
<td class="col-md-1" style="text-align: center">${o.orderId}</td>
                                        
<td class="col-md-1" style="text-align: center">${o.purchaseDate}</td>
<td class="col-md-1" style="text-align: center">${o.grandTotal}</td>
</tr>
</c:forEach>
                          
                                
</table>
</div>
</div>
</div>
</div>
</div>
        
</body>
</html>