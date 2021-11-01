<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
					
					<c:if test="${userInfo.isUser() || userInfo.isAdmin() }" >
					<li class="nav-item dropdown "><a
						class="nav-link dropdown-toggle dropdown-navbar" href="#"
						id="dropdown07" data-bs-toggle="dropdown" aria-expanded="false"><b>My User</b></a>
						<ul class="dropdown-menu dropdown-menu-navbar"
							aria-labelledby="dropdown07">
							<li><a class="dropdown-item dropdown-navbar-item" href="${pageContext.request.contextPath}/user/ExecuteGestioneAnnunciServlet">Gestione Annunci</a></li>
							<li><a class="dropdown-item dropdown-navbar-item" href="${pageContext.request.contextPath}/user/PrepareInsertAnnuncioServlet">Inserisci Annuncio</a></li>
							<li><a class="dropdown-item dropdown-navbar-item" href="${pageContext.request.contextPath}/user/PrepareSearchAnnuncioServlet">Cerca tra gli Annunci</a></li>
							<li><a class="dropdown-item dropdown-navbar-item" href="${pageContext.request.contextPath}/user/ExecuteVisualizzaAcquistiServlet">Visualizza Acquisti</a></li>
							</ul></li></c:if>
							
							
					<c:if test="${userInfo.isAdmin() }" >
					<li class="nav-item dropdown "><a
						class="nav-link dropdown-toggle dropdown-navbar" href="#"
						id="dropdown07" data-bs-toggle="dropdown" aria-expanded="false"><b>Admin</b></a>
						<ul class="dropdown-menu dropdown-menu-navbar"
							aria-labelledby="dropdown07">
							<li><a class="dropdown-item dropdown-navbar-item" href="${pageContext.request.contextPath}/admin/PrepareCercaUtenteServlet">Cerca Utente</a></li>
							<li><a class="dropdown-item dropdown-navbar-item" href="${pageContext.request.contextPath}/admin/PrepareInsertUtenteServlet">Inserisci Utente</a></li>
							</ul></li></c:if>
				</ul>
				<div class="col-md-3 text-end">
					<p class="navbar-text" style="color: black">
						Utente: ${userInfo.username }(${userInfo.nome } ${userInfo.cognome })
						<c:if test="${!userInfo.isUser() }" >
						<a class="btn btn-navbar " href="${pageContext.request.contextPath}/login.jsp"><b>Login</b></a>
						</c:if>
						<a class="btn btn-navbar" href="${pageContext.request.contextPath}/LogoutServlet"><b>Logout</b></a>
					</p>
				</div>
  
          
			</div>
		</div>
	</nav>
</header>