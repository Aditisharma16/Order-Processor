<!-- DELETE ORDER MODAL -->

<div class="modal" id="delorderModal">

	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Delete Order</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			</div>
			<div class="modal-body">

				<form>
					<p>Are you sure you want to delete this record?</p>
					<p class="text-warning">
						<small>This action cannot be undone.</small>
					</p>


					<div class="modal-footer">
						<a href="delorder?id=${order.id}" class="btn btn-primary">Submit</a>
						
						<button type="button" class="btn btn-danger" data-dismiss="modal"
							aria-hidden="true"
							onclick="document.getElementById('myModal').style.display='none'">Cancel</button>
										</div>

				</form>
			</div>
		</div>
	</div>


</div>
