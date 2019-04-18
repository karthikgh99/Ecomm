<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="<c:url value="/resources/images/a.jpg"/>" alt="a" style="width:100%;">
      </div>

      <div class="item">
      <img src="<c:url value="/resources/images/b.jpg"/>" alt="b" style="width:100%;">
      </div>
    
      <div class="item">
       <img src="<c:url value="/resources/images/c.jpg"/>" alt="c" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<!-- End of carousel -->
</br>

<div class="container">
	
			<div class="row">
			<c:forEach items="${plist}" var="product">
				<div class="col-md-3">
					<a href="<c:url value="/viewProduct/${product.productid}" />" >
					<img alt="Bootstrap Image Preview" src="<c:url value="/resources/images/${product.productid}.jpg"/>" width="140 px" height="140 px"/>
					</a>
					<h3>
						${product.productname}
					</h3>
					<p>
						Price:Rs.${product.productprice}/-
						</p>
				</div>
				</c:forEach>
		</div>
</div>
				
</body>
</html>
