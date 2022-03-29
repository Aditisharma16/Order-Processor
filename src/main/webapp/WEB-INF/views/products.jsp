<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page  import="java.util.ArrayList"%>
<%@ page  import="com.orderprocessor.model.dto.cart.Cart"%>
<%
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if(cart_list !=null){
		request.setAttribute("cart_count",cart_list );
	}
%>
<!DOCTYPE html>
<html>
<head>
	<title>Order Processor</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="shortcut icon" href="icon.ico?" type="image/x-icon" />

<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	charset="utf-8"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
<%@include file ="/WEB-INF/views/css/home.css"%>
<%@include file="/WEB-INF/views/scss/style.scss"%>
<%@ include file="/WEB-INF/views/css/retrievestyle.css"%>
</style>
	
</head>
<!-- product name product price qnty -->
<body>
<%@ include file="header.jsp" %>
	<div class="wrapper d-flex align-items-stretch" id="body-margin">	
		<div id="sidebar-body">
			<%@ include file="navbar.jsp" %>	
			</div>
		<!-- Page Content  -->
		
		<div id="content" class="p-4 p-md-5 pt-5">
		<c:if test="${orderplaced && orderplaced!=null}">
		<div class="alert alert-success">  
    	       <strong>Order successfully placed</strong> Go checkout recent orders..  
            </div> 
		</c:if>
		<c:if test="${cart_empty && cart_empty!=null}">
			<div class="alert alert-danger">  
    		   <strong>Cart is empty!!</strong> Please add a product.  
			</div>
		</c:if>
		<c:if test="${product_exists}">
			<div class="alert alert-danger">  
    		   <strong>Product already added!!</strong> To checkout, go to order.  
			</div>
		</c:if>
		<c:if test="${!product_exists && product_exists!=null}">
		<div class="alert alert-success">  
    	       <strong>Product added!!</strong> To checkout, go to order.  
            </div> 
		</c:if>
			<div class="container">
				<div class="card-header my-3">All Products</div>
				<div class="row row-centered pos">
					<c:forEach items="${products}" var="product">
					<div class="col-lg-4 col-md-6 col-xs-12 col-centered mb-5">
						<div class="card" >
						<img class="card-img-top"  src="${product.path}"/>
							<div class="card-body" >
								<h5 class="card-title">${product.productName}</h5>
								<p class="card-text">${product.productPrice}</p>
								<a href="add-to-cart?id=${product.id}" class="btn btn-primary" id="add-to-cart">Add</a>
							</div>
						</div>
					</div>
					</c:forEach>
				</div>
					
			</div>
		</div>
		</div>
	
</body>
</html>