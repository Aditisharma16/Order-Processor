<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.orderprocessor.model.dto.cart.Cart"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_count", cart_list);
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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<style type="text/css">
<%@include file ="/WEB-INF/views/css/home.css"%>
<%@include file="/WEB-INF/views/scss/style.scss"%>
<%@ include file="/WEB-INF/views/css/createorder.css"%>
</style>

<script type="text/javascript" src="js/createorder.js"></script>	
</head>
<body>

<!-- NAME, PRICE, ADD, CANCEL -->

<%@ include file="header.jsp" %>
	<div class="wrapper d-flex align-items-stretch" id="body-margin">	
		<div id="sidebar-body">
			<%@ include file="navbar.jsp" %>	
			</div>
		<div id="content" class="p-4 p-md-5 pt-5">
		<div class="container">
			<div class="d-flex py-3"><h3>Total Price: Rs. ${(totalPrice>0)?totalPrice:0}</h3></div>
			<table class="table table-loght">
			<thead>
			<tr>
			<th scope="col">Name</th>
	         <th scope="col">Price</th>
	      <div id="add" >  <th scope="col">Add</th></div>
	         <th scope="col">Cancel</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${checkProducts}" var="product">
				<tr>
					<td>${product.productName}</td>
					<td>${product.productPrice*product.quantity}</td>
					<td>
						
							<input type="hidden" name="id" value="${product.id}" class="form-input">
							<div class="form-group d-flex justify-content-between" id="incre-decre-btn">
							<a class="btn btn-sm btn-decre" href="quantity-dec?action=dec&id=${product.id}"><i class="fas fa-minus-square"></i></a>
							<input type="text" name="quantity" class="form-control" value="${product.quantity}" readonly>
							<a class="btn btn-sm btn-incre" href="quantity-inc?action=inc&id=${product.id}"><i class="fas fa-plus-square"></i></a>
							</div>
					
					</td>
					<td>
						<a class="btn btn-sm btn-danger" href="remove-from-cart?id=${product.id}">Remove</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
		
		<!-- shipping address, customer name, customer phoneno, total price, created on -->
		<div class="container">
		<form:form action="place-order" method="post" modelAttribute="addOrderForm">
		<br><br>
  <div class="form-group">
    <label for="customer_name" class="control-label">Customer Name</label>
    <form:input path="customerName" type="text" class="form-control" id="customer_name" placeholder="Enter customer name" required="required" />
    <p id="nameMsg"></p>
    
  </div>
  <div class="form-group">
    <label for="shipping_address">Shipping Address</label>
    <form:input path="shippingAddress" type="text" class="form-control" id="shipping_address" placeholder="Enter shipping address" required="required"/>
    <p id="addressMsg"></p>
  </div>
  <div class="form-group">
    <label for="contact_number">Contact Number</label>
    <form:input path="customerPhoneno" type="text" class="form-control" id="customer_contact" placeholder="Enter contact number" required="required"/>
    <p id="contactMsg"></p>
  </div>
  <button type="submit" class="btn btn-primary" onclick="return validate()">Order Now</button>
</form:form>
		</div>
		</div>
		
	</div>
	
	
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	charset="utf-8"></script>
	
</body>
</html>