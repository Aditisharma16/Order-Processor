<!-- HEADER WITH ORDER AND LOGOUT BUTTON -->

<div id="header">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a href="#" class="navbar-brand"> <img
				src="images/logo.png" height="60" >
			</a>
			
			<button type="button" class="navbar-toggler"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<div class="navbar-nav ms-auto">
				<div class="nav-item nav-link">
                    <a href="checkout"  class="logout_btn">Orders<span class="badge badge-danger">${cart_count.size()}</span></a>
                    </div>
					<div id="header-logout" class="nav-item nav-link">
						<a href="logout"> <input type="button" class="logout_btn" value="Logout" /></a>
					</div>
				</div>
			</div>
		</div>
	</nav>
</div>