<header>
	<nav
		class="navbar navbar-expand-md navbar-dark fixed-top navbar-background">
		<div class="container-fluid">
			<a class="navbar-brand" href="/myebay/home"> <img
				src="https://img.icons8.com/external-icongeek26-linear-colour-icongeek26/50/000000/external-panda-animal-head-icongeek26-linear-colour-icongeek26.png" />
				<b><i>My Ebay</i></b>
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
				aria-controls="navbarCollapse" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li class="nav-item"><a class="nav-link link-navbar" href="#"><b>Link</b></a>
					</li>
					<li class="nav-item"><a class="nav-link link-navbar" href="#"
						tabindex="-1" aria-disabled="true"><b>Link</b></a></li>
					<li class="nav-item"><a class="nav-link link-navbar" href="#"
						tabindex="-1" aria-disabled="true"><b>Link</b></a></li>
					<li class="nav-item dropdown "><a
						class="nav-link dropdown-toggle dropdown-navbar" href="#"
						id="dropdown07" data-bs-toggle="dropdown" aria-expanded="false"><b>Dropdown</b></a>
						<ul class="dropdown-menu dropdown-menu-navbar"
							aria-labelledby="dropdown07">
							<li><a class="dropdown-item dropdown-navbar-item" href="#">Link</a></li>
							<li><a class="dropdown-item dropdown-navbar-item" href="#">Link</a></li>
							<li><a class="dropdown-item dropdown-navbar-item" href="${pageContext.request.contextPath}/user/ExecuteGestioneAnnunciServlet">Gestione Annunci</a></li>
							<li><a class="dropdown-item dropdown-navbar-item" href="${pageContext.request.contextPath}/user/PrepareInsertAnnuncioServlet">Inserisci Annuncio</a></li>
						</ul></li>
				</ul>
				<div class="col-md-3 text-end">
					<p class="navbar-text" style="color: black">
						Utente: ${userInfo.username }(${userInfo.nome } ${userInfo.cognome })
						<a class="btn btn-navbar " href="login.jsp"><b>Login</b></a>
						<a class="btn btn-navbar" href="${pageContext.request.contextPath}/LogoutServlet"><b>Logout</b></a>
					</p>
				</div>

			</div>
		</div>
	</nav>
</header>