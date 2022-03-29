<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.orderprocessor.model.dao.orderstatus.OrderStatusEnum" %>
<%@ page  import="java.util.ArrayList"%>
<%@ page  import="com.orderprocessor.model.dto.cart.Cart"%>
<%
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if(cart_list !=null){
		request.setAttribute("cart_count",cart_list );
	}
%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Order Processor</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="shortcut icon" href="icon.ico?" type="image/x-icon" />
<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" charset="utf-8"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" ></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css" />


<style type="text/css">
	<%@include file ="/WEB-INF/views/css/home.css"%>
	<%@include file="/WEB-INF/views/scss/style.scss"%>
</style>


</head>

<body>

	<%@ include file="header.jsp" %>
	<div class="wrapper d-flex align-items-stretch" id="body-margin">
			<div id="sidebar-body">
			<%@ include file="navbar.jsp" %>	
			</div>
		<!-- Page Content  -->
		<div id="content" class="p-4 p-md-5 pt-5">
			<h2 class="mb-4">Welcome</h2>
			<div>
				<div class="flex-container">
					<div class="card flex-card" >
						<div class="card-body">
							<span >
								<h5 class="card-title">Total Orders</h5>
								<h6 class="card-subtitle mb-2 text-muted">${totalOrder}</h6>
							</span>
						</div>
					</div>
					<div class="card flex-card" >
						<div class="card-body">
							<span>
								<h5 class="card-title">Orders in Processing</h5>
								<h6 class="card-subtitle mb-2 text-muted">${inProcessingOrder}</h6>
							</span>
						</div>
					</div>
					<div class="card flex-card" >
						<div class="card-body">
							<span >
								<h5 class="card-title">Placed Orders</h5>
								<h6 class="card-subtitle mb-2 text-muted">${placedOrder}</h6>
							</span>
						</div>
					</div>
				</div>
				
				<div id="latest-orders" >
					<div class="card" >
						<div class="card-body">
							<span >
								<h5 class="card-title">Most Recent Orders</h5>
								<table id="myTable" class="styled-table">
									<thead>
										<tr>
										
										<th>Order Number</th>
										<th>Customer Name</th>
										<th>Order Date</th>
										<th>Delivery Date</th>
										<th>Total Price</th>
										<th>Order Status</th>
										
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${orders}" var="order">
											<tr>
												<td>${order.orderNumber}</td>
												<td>${order.customerName}</td>
												<td>${order.createdOn}</td>
												<td>${order.deliveryDate}</td>
												<td>${order.totalPrice}</td>
												<td class="status" value="${OrderStatusEnum.values()[order.statusId-1]}">${OrderStatusEnum.values()[order.statusId-1]}</td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
							</span>
						</div>
					</div>
				</div>
			</div>

</div>
		</div>
	
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="js/home.js"></script>


		
</body>

</html>