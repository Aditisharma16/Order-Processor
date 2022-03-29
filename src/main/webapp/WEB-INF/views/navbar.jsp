<!-- NAVBAR CONTAINS HOME, RETRIEVE ORDER, ADD ORDER -->

  <script type="text/javascript" src="js/navbar.js"></script>
   <nav id="sidebar" class="sticky-sidebar" nav>
			<div class="custom-menu">
				<button type="button" id="sidebarCollapse" class="btn btn-primary" onclick="toggle()">
					<i class="fa fa-bars"></i> <span class="sr-only">Toggle Menu</span>
				</button>
			</div>
			<div class="p-4" id="sidebar-elements">
				<h1>
					<a href="index.html" class="logo"> <span></span>
					</a>
				</h1>
				<c:if test="${orders !=null}">
					<ul class="list-unstyled components mb-5" id="activeElement">
					<li class="active" id="btn1"><a href="home"><span
							class="fa fa-home mr-3"></span>Home</a></li>
					
					<li id="btn2" onclick="activeBtn2()"><a href="orders"><span class="fa fa-sticky-note mr-3"></span>
							Retrieve Orders</a></li>
					<li id="btn3"><a href="products"><span class="fa fa-cart-plus mr-3"></span>
							Add Order</a></li>
				</ul>
				</c:if>
				<c:if test="${allOrders !=null}">
						<ul class="list-unstyled components mb-5" id="activeElement">
					<li class="" id="btn1"><a href="home"><span
							class="fa fa-home mr-3"></span>Home</a></li>
					
					<li class="active" id="btn2" onclick="activeBtn2()"><a href="orders"><span class="fa fa-sticky-note mr-3"></span>
							Retrieve Orders</a></li>
					<li id="btn3"><a href="products"><span class="fa fa-cart-plus mr-3"></span>
							Add Order</a></li>
				</ul>
				</c:if>
				<c:if test="${products!=null}">
					<ul class="list-unstyled components mb-5" id="activeElement">
					<li class="" id="btn1"><a href="home"><span
							class="fa fa-home mr-3"></span>Home</a></li>
					
					<li class="" id="btn2" onclick="activeBtn2()"><a href="orders"><span class="fa fa-sticky-note mr-3"></span>
							Retrieve Orders</a></li>
					<li class="active" id="btn3"><a href="products"><span class="fa fa-cart-plus mr-3"></span>
							Add Order</a></li>
				</ul>
				</c:if>
				<c:if test="${checkProducts!=null}">
					<ul class="list-unstyled components mb-5" id="activeElement">
					<li><a href="home"><span
							class="fa fa-home mr-3"></span>Home</a></li>
					
					<li><a href="orders"><span class="fa fa-sticky-note mr-3"></span>
							Retrieve Orders</a></li>
					<li class="active"><a href="products"><span class="fa fa-cart-plus mr-3"></span>
							Add Order</a></li>
				</ul>
				</c:if>
				



				<div class="footer">
					<p>
						
						Copyright &copy;
						<script>
							document.write(new Date().getFullYear());
						</script>
						All rights reserved | <i class="icon-heart" aria-hidden="true"></i>
						
					</p>
				</div>

			</div>
			
				  
		</nav>
	
