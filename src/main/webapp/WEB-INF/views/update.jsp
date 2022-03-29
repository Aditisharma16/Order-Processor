<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Update</title>
 <script type="text/javascript" src="js/update.js"></script>	
</head>
<body>

 
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<h5 class="modal-title">Update Project</h5>

			<button type="button" class="btn-close" data-dismiss="modal"></button>
		</div>
		<form action="updateOrder" method="post"
			modelAttribute="updateOrderDto" autocomplete="off">
			<div class="modal-body">
				<div class="mb-3">
					<label class="form-label required">Order Number</label> <input
						type="text" class="form-control" id="order number"
						name="projectName" value="" readonly />
				</div>
				<div class="mb-3">
					<label class="form-label required">Customer Name</label> <input
						type="text" class="form-control" id="customerName"
						name="customerName" value="" readonly />
				</div>
				<div class="mb-3">
					<label class="form-label required">Total Price</label> <input
						type="date" class="form-control" id="totalPrice" name="totalPrice"
						value="" readonly />
				</div>
				<div class="mb-3">
					<label class="form-label required">Contact Number</label> 
					<input
						type="text" class="form-control" id="contactNumber" -
						name="contactNumber" autocomplete="off" value="" maxlength="10" size="10" required/>
					<p id="contactMsg"></p>
				</div>

				<div class="mb-3">
					<label class="form-label required">Shipping Address</label> <input
						type="date" class="form-control" id="shippingAddress"
						name="shippingAddress" autocomplete="off" value="" required maxlength="50" />
						<p id="addMsg"></p>
				</div>
			</div>

			<div class="modal-footer">
				<button type="submit" class="btn btn-primary" onclick="return validate()">Submit</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal"
					aria-hidden="true">Cancel</button>
				
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button> -->
				<input type="hidden" id="id" name="id">
			</div>

		</form>

	</div>
	
</div>

</body>

</html>