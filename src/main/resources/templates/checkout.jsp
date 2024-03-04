<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">

<title>Document</title>
</head>
<body>


	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				th:src="@{/images/logo.png}" src="../static/images/logo.png"
				width="auto" height="40" class="d-inline-block align-top" alt="" />
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto"></ul>
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" th:href="@{/}"
						href="#">home</a></li>
					<li class="nav-item active"><a class="nav-link"
						th:href="@{/shop}" href="#">shop</a></li>
					<li class="nav-item active"><a class="nav-link"
						sec:authorize="isAnonymous()" th:href="@{/login}" href="#">login</a>
					</li>
					<li class="nav-item active"><a class="nav-link"
						sec:authorize="isAuthenticated()" th:href="@{/logout}" href="#">logout</a>
					</li>
					<li class="nav-item active"><a class="nav-link"
						th:href="@{/cart}" href="#">cart</a></li>
					<li class="nav-item active"><span class="nav-link"
						th:text="${cartCount}">0</span></li>
				</ul>

			</div>
		</div>
	</nav>
	<div class="container">

		<!--Section: Block Content-->
		<section class="mt-5 mb-4">

			<!--Grid row-->
			<div class="row">

				<!--Grid column-->
				<div class="col-lg-8 mb-4">

					<!-- Card -->
					<div class="card wish-list pb-1">
						<div class="card-body">

							<h5 class="mb-2">Billing details</h5>

							<!-- Grid row -->
							<div class="row">

								<!-- Grid column -->
								<div class="col-lg-6">

									<!-- First name -->
									<div class="md-form md-outline mb-0 mb-lg-4">
										<label for="firstName">First name</label> <input type="text"
											id="firstName" name="Firstname" required class="form-control mb-0 mb-lg-2">
									</div>

								</div>
								<!-- Grid column -->

								<!-- Grid column -->
								<div class="col-lg-6">

									<!-- Last name -->
									<div class="md-form md-outline">
										<label for="lastName">Last name</label> <input type="text"
											id="lastName" required name = "Lastname" class="form-control">
									</div>

								</div>
								<!-- Grid column -->

							</div>
							<!-- Grid row -->



							<!-- Country -->
							<div class="d-flex flex-wrap">
								<div class="select-outline position-relative w-100">
									<label>Country - <strong>Pakistan</strong></label>


								</div>
							</div>

							<!-- Address Part 1 -->
							<div class="md-form md-outline mt-2">
								<label for="form14">Address (Line 1)</label> <input type="text"
									required id="form14" placeholder="House number and street name"
									class="form-control">
							</div>

							<!-- Address Part 2 -->
							<div class="md-form md-outline mt-2">
								<label for="form15">Address (Line 2)</label> <input type="text"
									id="form15"
									placeholder="Apartment, suite, unit etc. (optional)"
									class="form-control">
							</div>

							<!-- Postcode / ZIP -->
							<div class="md-form md-outline mt-3">
								<label for="form16">Postcode / ZIP</label> <input type="text"
									maxlength="6" minlength="6" required id="form16"
									class="form-control">
							</div>

							<!-- Town / City -->
							<div class="md-form md-outline mt-2">
								<label for="form17">Town / City</label> <input type="text"
									required id="form17" class="form-control">

							</div>

							<!-- Phone -->
							<div class="md-form md-outline mt-2">
								<label for="form18">Phone</label> <input type="number"
									minlength="10" maxlength="10" required id="form18"
									class="form-control">
							</div>

							<!-- Email address -->
							<div class="md-form md-outline mt-2">
								<label for="form19">Email address</label> <input type="email"
									required id="form19" class="form-control">
							</div>

							<!-- Additional information -->
							<div class="md-form md-outline mt-2">
								<label for="form76">Additional information</label>
								<textarea id="form76" class="md-textarea form-control" rows="4"></textarea>
							</div>



						</div>
					</div>
					<!-- Card -->

				</div>
				<!--Grid column-->

				<!--Grid column-->
				<div class="col-lg-4">

					<!-- Card -->
					<div class="card mb-4">
						<div class="card-body">

							<h5 class="mb-3">The total amount</h5>

							<ul class="list-group list-group-flush">
								<li
									class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
									Amount Payable <span>Rs<span th:text="${total}"></span></span>
								</li>
								<li
									class="list-group-item d-flex justify-content-between align-items-center px-0">
									Shipping <span>Gratis</span>
								</li>
								<li
									class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
									<div>
										<strong>The total amount of</strong> <strong>
											<p class="mb-0">(including VAT)</p>
										</strong>
									</div> <span><strong>Rs<span th:text="${total}"></span></strong></span>
								</li>
							</ul>

							<form action="" method="post" th:action="@{/payNow}">
								<button type="submit"
									class="btn btn-primary btn-block waves-effect waves-light">Pay
									Now</button>
							</form>

						</div>
					</div>
					<!-- Card -->

					<!-- Card -->
					<div class="card mb-4">
						<div class="card-body">

							<a class="dark-grey-text d-flex justify-content-between"
								data-toggle="collapse" href="#collapseExample"
								aria-expanded="false" aria-controls="collapseExample"> Add a
								discount code (optional) <span><i
									class="fas fa-chevron-down pt-1"></i></span>
							</a>

							<div class="collapse" id="collapseExample">
								<div class="mt-3">
									<div class="md-form md-outline mb-0">
										<input type="text" id="discount-code"
											class="form-control font-weight-light"
											placeholder="Enter discount code">
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Card -->

				</div>
				<!--Grid column-->

			</div>
			<!--Grid row-->

		</section>
		<!--Section: Block Content-->


	</div>





	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>