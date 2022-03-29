<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<html>
<head>
<title>Order Processor</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<link rel="shortcut icon" href="icon.ico?" type="image/x-icon" />
	

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css" />
    
    <script type="text/javascript" src="js/retrieve.js"></script>

<style type="text/css">
    <%@include file ="/WEB-INF/views/css/home.css"%>
    <%@include file="/WEB-INF/views/scss/style.scss"%>
    <%@ include file="/WEB-INF/views/css/retrievestyle.css"%>
</style>


<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/update.js"></script>



<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

  
    <title>Bootstrap 5 Modal</title>
    	
    
</head>
<body onload="loadProductDetails(${productDetails[0].id})">
	<%@ include file="header.jsp"%>
	<div class="wrapper d-flex align-items-stretch" id="body-margin">
		<div id="sidebar-body">
			<%@ include file="navbar.jsp" %>	
			</div>
		<!-- Page Content  -->


		<div id="content" class="p-4 p-md-5 pt-5">
			<!-- The form -->
			<!--  form class="example" action="search" method="post">
				<input type="text" placeholder="Search By Order Number"
					name="search">
				<button type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form-->

			<table id="myTable" class="styled-table">
				<thead>
					<tr>
					
						<th>Order Number</th>
						<th>Customer Name</th>
						<th>Order Date</th>
						<th>Delivery Date</th>
						<th>Total Price</th>
						<th>Order Status</th>
						<th>View</th>
						<th>Update</th>
						<th>Delete</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allOrders}" var="order">
						<tr>
							<td>${order.orderNumber}</td>
							<td>${order.customerName}</td>
							<td>${order.createdOn}</td>
							<td>${order.deliveryDate}</td>
							<td>${order.totalPrice}</td>
							<td class="status" value="${OrderStatusEnum.values()[order.statusId-1]}">${OrderStatusEnum.values()[order.statusId-1]}</td>
	                         
	                         <!-- VIEW MODAL -->
                           <td>
                           		<a href="viewproducts?id=${order.id}" class="view"
								><i class="material-icons" 
									data-bs-toggle="tooltip" title="View">&#xE417;</i></a>
                           </td> 
	                        <!-- -- UPDATE -->
							<td><c:if test="${order.statusId == 3}">
								<a href="#" class="edit" data-target="editOrderModal-${order.id}" style="cursor:default"
								data-bs-toggle="modal"><i class="material-icons" style="color:#c1c1c1"
									data-toggle="tooltip" title="Edit">&#xE254;</i></a>
							</c:if>
							<c:if test="${order.statusId!=3}">
								<a href="#editOrderModal-${order.id}" class="edit" data-target="editOrderModal-${order.id}"
								data-bs-toggle="modal"><i class="material-icons" style="color:#dda703"
									data-toggle="tooltip" title="Edit">&#xE254;</i></a>
							</c:if>
                           <!-- UPDATE MODAL -->
                           	<div class="modal" id="editOrderModal-${order.id}">
									<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Update Order</h5>
	
				<button type="button" class="btn-close" data-bs-dismiss="modal" id="close-btn"></button>
			</div>
			<form action="updateorder" method="post" modelAttribute="updateOrderDto">
				<div class="modal-body">
					<input type="hidden" name="id" value="${order.id}"/>
					<div class="mb-3">
						<label class="form-label required">Order Number</label> <input
							type="text" class="form-control" id="order number"
							name="orderNumber" value="${order.orderNumber}" readonly />
					</div>
					<div class="mb-3">
						<label class="form-label required">Customer Name</label> <input
							type="text" class="form-control" id="customerName"
							name="customerName" value="${order.customerName}" readonly />
					</div>
					<div class="mb-3">
						<label class="form-label required">Total Price</label> <input
							type="text" class="form-control" id="totalPrice" name="totalPrice"
							value="${order.totalPrice}" readonly />
					</div>
					<div class="mb-3">
						<label class="form-label required">Contact Number</label> <input
							type="text" class="form-control" id="contactNumber${order.id}"
							name="customerPhoneno" value="${order.customerPhoneno}" required />
							<p id="contactMsg${order.id}"></p>
					</div>
	
					<div class="mb-3">
						<label class="form-label required">Shipping Address</label> <input
							type="text" class="form-control" id="shippingAddress${order.id}"
							name="shippingAddress" value="${order.shippingAddress}" required />
					        <p id="addMsg${order.id}"></p>
					</div>
				</div>
	
				<div class="modal-footer">
					<button type="submit" class=" btn btn-primary" onclick="return validate(${order.id})">Submit</button>
					<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancel</button>
					<input type="hidden" id="id" name="id">
				</div>

		</form>

	</div>
</div>
								</div>
								</td>

							<!-- DELETE MODAL -->
							<td><c:if test="${order.statusId == 3}">
							<a href="#"
								data-target="#delorderModal-${order.id}" class="delete" style="cursor:default"
								data-bs-toggle="modal"><i class="material-icons" style="color:#c1c1c1;"
									data-toggle="tooltip" title="Delete">&#xE872;</i></a>
							</c:if>
							<c:if test="${order.statusId!=3}">
							<a href="#delorderModal-${order.id}"
								data-target="#delorderModal-${order.id}" class="delete"
								data-bs-toggle="modal"><i class="material-icons" style="color:#dc1d1d"
									data-toggle="tooltip" title="Delete">&#xE872;</i></a>
							</c:if>
								<div class="modal" id="delorderModal-${order.id}">

									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title">Delete Order</h5>
												<button type="button" class="btn-close" id="close-btn"
													data-bs-dismiss="modal"></button>
											</div>
											<div class="modal-body">

												<form>
													<p>Are you sure you want to delete this record?</p>
													<p class="text-warning">
														<small>This action cannot be undone.</small>
													</p>


													<div class="modal-footer">
														<a href="deleteorder?id=${order.id}" class="btn btn-danger">Confirm</a>
														<button type="button" class="btn btn-primary"
															data-bs-dismiss="modal">Cancel</button>
													</div>

												</form>
											</div>
										</div>
									</div>


								</div></td>


						</tr>
					</c:forEach>

				</tbody>
			</table>


		</div>
	</div>

	<!-- VIEW MODAL -->
	
<div class="modal fade" id="viewModal" tabindex="-1" aria-labelledby="viewModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header float-right">
                <h5>#Product Details</h5>
                <div class="text-right"> <i data-bs-dismiss="modal" aria-label="Close" class="fa fa-close"></i> </div>
            </div>
            <div class="modal-body">
                <div>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Price</th>
                                <th scope="col">Quantity</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${productDetails}" var="product">
                        	 <tr>
                                <td>${product.productName}</td>
                                <td>${product.productPrice}</td>
                                <td>${product.quantity}</td>
                            </tr>
                        </c:forEach>                  
                       </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer"> <button type="button" class="btn btn-primary"
															data-bs-dismiss="modal">Cancel</button> </div>
        </div> 
	</div>
</div>
<script type="text/javascript" src="js/update2.js"></script>


</body>
</html>