<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="it" class="h-100">
<head>

<!-- Common imports in pages -->
<jsp:include page="../header.jsp" />

<title>Inserisci Nuovo Utente</title>
</head>
<body class="d-flex flex-column h-100">

	<!-- Fixed navbar -->
	<jsp:include page="../navbar.jsp"></jsp:include>


	<!-- Begin page content -->
	<main class="flex-shrink-0">
		<div class="container">

			<div
				class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }"
				role="alert">
				${errorMessage}
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>

			<div class="p-5 mb-4 bg-light rounded-3 custom-index">
				<div class="container-fluid py-5">
					
					<p class="col-md-8 fs-4">
						<b>Usa il form qui sotto per modificare il tuo annuncio.</b>
					</p>
					<hr class="custom-line-index">
					<div>
						<form method="post" action="ExecuteModificaAnnuncioServlet" class="row g-3"
							novalidate="novalidate">

						<input type="hidden" name="idAnnuncio" value="${update_annuncio_attr.id}">

							<div class="col-md-6 custom-div-index">
								<label>Inserisci il testo dell'annuncio:</label> <input type="text"
									name="testoAnnuncio" id="testoAnnuncio"
									class="form-control custom-form-box"
									placeholder="Inserisci il testo dell'annuncio"
									value="${update_annuncio_attr.testoAnnuncio }">

							</div>
							<hr class="custom-line-index">
							<div class="col-md-6 custom-div-index">
								<label>Inserisci il prezzo</label> <input type="number"
									class="form-control custom-form-box" name="prezzo" id="prezzo"
									placeholder="Inserire il prezzo"
									value="${update_annuncio_attr.prezzo }">
							</div>
							<hr class="custom-line-index">
							<div class="checkbox mb-3">
							<label>Inserisci le categorie:</label><br>
								<c:forEach items="${categorie_list_attribute }"	var="categoriaItem">
									<label> <input type="checkbox" name="categoriaInput" class="custom-form-box" value="${categoriaItem.id}">
										${categoriaItem.descrizione}</label>
									<br>
								</c:forEach>
							</div>
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit"
									class="btn btn-navbar">Conferma</button>
									 <a href="ExecuteGestioneAnnunciServlet" class='btn btn-navbar'>
					            <i class='fa fa-chevron-left'></i> Indietro
					        </a>
							</div>
							
						</form>
					</div>


					<!-- end card-body -->
				</div>
				<!-- end card -->
			</div>


			<!-- end container -->
		</div>

	</main>

	<!-- Footer -->
	<jsp:include page="../footer.jsp" />
</body>
</html>