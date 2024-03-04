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
					<!--                <li class="nav-item active">-->
					<!--                    <span class="nav-link" th:text="${cartCount}">0</span>-->
					<!--                </li>-->
				</ul>

			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div
				class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
						<strong th:text="${result}"></strong> <br>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6 text-right">
						<p>
							<em>Receipt #: 34522677W</em>
						</p>
					</div>
				</div>
				<div class="text-center">
					<h1>Receipt</h1>
				</div>

				<table class="table table-hover">
					<thead>
						<tr>


							<th scope="col">S.No</th>
							<th scope="col">Product Name</th>
							<th scope="col">Price</th>
						</tr>


					</thead>
					<tbody>


						<tr th:each="entry, iStat : ${parameters}">
							<th id="counterDisplay" scope="row" th:text="${iStat.index + 1}"></th>
							<td th:text="${entry.productName}">test</td>
							<td th:text="${entry.price}"></td>

							
						</tr>
						
					</tbody>

				</table>
				<span>YOUR TOTAL AMOUNT IS: <span th:text="${total}"></span>

			</div>











		</div>
	</div>
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
	<script>
		// JavaScript code to increase loop counter and display it in the HTML element
		var counterDisplay = document.getElementById("counterDisplay");

		// Loop from 1 to 10 and display the loop counter in the HTML element
		for (var i = 1; i <= 5; i++) {
			// Create a text node with the loop counter value
			var counterText = document.createTextNode(entry);

			// Append the text node to the counterDisplay element
			counterDisplay.appendChild(counterText);

			// Add a line break after each loop counter value
			counterDisplay.appendChild(document.createElement("br"));
		}
	</script>

</body>
</html>