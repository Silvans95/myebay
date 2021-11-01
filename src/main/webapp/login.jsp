<!doctype html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Accedi</title>

<!-- Common imports in pages -->
<jsp:include page="./header.jsp" />


<!-- Custom styles for login -->
<link href="assets/css/signin.css" rel="stylesheet">

</head>


<body class="text-center login-background">

	<main class="form-signin custom-form-signin">


		<div class="p-5  custom-index">

			<div
				class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }"
				role="alert">
				${errorMessage}
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>

			<form action="LoginServlet" method="post" novalidate="novalidate">

				<img class="mb-4 custom-signin-img" src="./assets/img/panda.svg"
					alt="">
				<h1 class="h3 mb-3 fw-normal">Please sign in</h1>

				<div class="form-floating ">
					<input type="text" name="inputUsername"
						class="form-control custom-form-box" id="inputUsername"
						placeholder="username"> <label for="inputUsername">Username</label>
				</div>
				<br>
				<div class="form-floating ">
					<input type="password" name="inputPassword"
						class="form-control custom-form-box" id="inputPassword"
						placeholder="Password"> <label for="inputPassword">Password</label>
				</div>

				<div class="checkbox mb-3">
				
					<label> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
				<button class="w-100 btn btn-lg btn-navbar" type="submit">Sign
					in</button>
					
					<a class="nav-link" href="PrepareInsertUtenteServlet"
						tabindex="-1" aria-disabled="true" style="color:white!important">Registrati</a>
				<p class="mt-5 mb-3 text-muted">&copy; 2020-2021</p>
			</form>
		</div>
	</main>


</body>


</html>