<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it" class="h-100">
<head>

<!-- Common imports in pages -->
<jsp:include page="./header.jsp" />
<!-- Custom styles per le features di bootstrap 'Columns with icons' -->
<link href="./assets/css/features.css" rel="stylesheet">

<title>Welcome to My Ebay</title>
</head>
<body class="d-flex flex-column h-100">

	<!-- Fixed navbar -->
	<jsp:include page="./navbar.jsp"></jsp:include>


	<!-- Begin page content -->
	<main class="flex-shrink-0">
		<div class="container">


			<div class="p-5 mb-4 bg-light rounded-3 custom-index">
				<div class="container-fluid py-5">
					<div
						class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }"
						role="alert">
						${errorMessage}
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<h1 class="display-5 fw-bold">
						<img
							src="https://img.icons8.com/external-icongeek26-linear-colour-icongeek26/50/000000/external-panda-animal-head-icongeek26-linear-colour-icongeek26.png" />
						Benvenuto su My Ebay
					</h1>
					<p class="col-md-8 fs-4">
						Usa il form qui sotto per cercare tra i nostri annunci. <br>Per
						avere una lista completa lascia tutti i campi vuoti
					</p>
					<hr class="custom-line-index">
					<div>
						<form method="post" action="ExecuteListAnnunci" class="row g-3"
							novalidate="novalidate">

							<div class="col-md-6 custom-div-index">
								<label>Cerca per Keyword:</label> <input type="text"
									name="testoAnnuncio" id="testoAnnuncio"
									class="form-control custom-form-box"
									placeholder="Inserire una parola chiave dell'annuncio"
									value="${annuncio_attr.testoAnnuncio }">

							</div>
							<hr class="custom-line-index">
							<div class="col-md-6 custom-div-index">
								<label>Ricerca per prezzo</label> <input type="number"
									class="form-control custom-form-box" name="prezzo" id="prezzo"
									placeholder="Inserire il prezzo minimo">
							</div>
							<hr class="custom-line-index">
							<div class="checkbox mb-3">
								<c:forEach items="${categoria_list_attribute }"
									var="categoriaItem">
									<label> <input type="checkbox" name="categoriaInput" class="custom-form-box"
										value="${categoriaItem.id}"> ${categoriaItem.descrizione}
									</label>
									<br>
								</c:forEach>
							</div>
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit"
									class="btn btn-navbar">Conferma</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>

	<!-- Footer -->
	<jsp:include page="./footer.jsp" />
</body>
</html>