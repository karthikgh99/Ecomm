
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>  
<html lang="en">  
<head>  
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Example of Bootstrap 3 Responsive Navbar</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	.navbar{
		
	}
</style> 
</head>  
<body>  
  
<nav class="navbar navbar-defualt-expand">  
  <div class="container-fluid">  
    <div class="navbar-header">  
      <a class="navbar-brand" href="<c:url value="/home" />"><img src="<c:url value="/resources/images/Capture2.png" />" width="150 px" height="90 px"/></a>  
    </div>  
    <div class="nav navbar-expand-lg">  
      <li class="active"><a href="<c:url value="/home" />">Home</a></li>  
      <li><a href="<c:url value="/category" />" >Categories</a></li>  

      <c:if test="${pageContext.request.userPrincipal.name=='k@a'}">
      <li><a href="<c:url value="/admin" />" >Admin</a></li>  
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name!=null}">
      <c:if test="${pageContext.request.userPrincipal.name!='k@a'}">
      <li><a href="<c:url value="/cart" />">MyCart</a></li> 
      </c:if> 
      </c:if>
    </div>  
    <ul class="nav navbar-nav navbar-right"> 
     <c:if test="${pageContext.request.userPrincipal.name!=null}">
    <li><a href="">Welcome, ${Username}</a></li>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name==null}">
      <li><a href="signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>  
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>  
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name!=null}">
      <c:url value="/j_spring_security_logout" var="logoutUrl" />
      <a href="${logoutUrl}"><span class="glyphicon glyphicon-log-out"></span>Log Out</a>
      </c:if>

    </ul>  
  </div>  
</nav>  
    
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
</body>  
</html>  

 