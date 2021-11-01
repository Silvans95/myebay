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

			<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
			  <symbol id="people-circle" viewBox="0 0 16 16">
			    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
			    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
			  </symbol>
			  <symbol id="collection" viewBox="0 0 16 16">
			    <path d="M2.5 3.5a.5.5 0 0 1 0-1h11a.5.5 0 0 1 0 1h-11zm2-2a.5.5 0 0 1 0-1h7a.5.5 0 0 1 0 1h-7zM0 13a1.5 1.5 0 0 0 1.5 1.5h13A1.5 1.5 0 0 0 16 13V6a1.5 1.5 0 0 0-1.5-1.5h-13A1.5 1.5 0 0 0 0 6v7zm1.5.5A.5.5 0 0 1 1 13V6a.5.5 0 0 1 .5-.5h13a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-.5.5h-13z"/>
			  </symbol>
			  <symbol id="toggles2" viewBox="0 0 16 16">
			    <path d="M9.465 10H12a2 2 0 1 1 0 4H9.465c.34-.588.535-1.271.535-2 0-.729-.195-1.412-.535-2z"/>
			    <path d="M6 15a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm0 1a4 4 0 1 1 0-8 4 4 0 0 1 0 8zm.535-10a3.975 3.975 0 0 1-.409-1H4a1 1 0 0 1 0-2h2.126c.091-.355.23-.69.41-1H4a2 2 0 1 0 0 4h2.535z"/>
			    <path d="M14 4a4 4 0 1 1-8 0 4 4 0 0 1 8 0z"/>
			  </symbol>
			  <symbol id="chevron-right" viewBox="0 0 16 16">
			    <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
			  </symbol>
			</svg>

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
						<form method="post" action="ExecuteCercaAnnunciServlet" class="row g-3"
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
			
			 <div class="container px-4 py-5" id="featured-3">
			    <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
			    
			    <c:if test="${userInfo.isUser() || userInfo.isAdmin()}" >
			      <div class="feature col">
			        <div class="feature-icon bg-primary bg-gradient" style="background-color: #6d7174 !important">
			          <svg class="bi" width="1em" height="1em" ><use xlink:href="#collection"/></svg>
			        </div>
			        <h2>Gestione Annunci</h2>
			        <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
			        <a href="${pageContext.request.contextPath}/user/ExecuteGestioneAnnunciServlet" class="icon-link">
			          Vai alla funzionalità
			          <svg class="bi" width="1em" height="1em"><use xlink:href="#chevron-right"/></svg>
			        </a>
			      </div>
			    </c:if>  
			      
			    <c:if test="${userInfo.isUser() || userInfo.isAdmin()}" >
			      <div class="feature col">
			        <div class="feature-icon bg-primary bg-gradient" style="background-color: #6d7174 !important">
			          <svg class="bi" width="1em" height="1em"><use xlink:href="#people-circle"/></svg>
			        </div>
			        <h2>Gestione Acquisti</h2>
			        <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
			        <a href="${pageContext.request.contextPath}/user/ExecuteVisualizzaAcquistiServlet" class="icon-link">
			          Vai alla funzionalità
			          <svg class="bi" width="1em" height="1em"><use xlink:href="#chevron-right"/></svg>
			        </a>
			      </div>
			   </c:if>
			   
			     <c:if test="${userInfo.isAdmin() }" >
			      
			      <div class="feature col">
			        <div class="feature-icon bg-primary bg-gradient" style="background-color: #6d7174 !important">
			          <svg class="bi" width="1em" height="1em"><use xlink:href="#toggles2"/></svg>
			        </div>
			        <h2>Ricerca Utente</h2>
			        <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
			        <a href="${pageContext.request.contextPath}/admin/PrepareCercaUtenteServlet" class="icon-link">
			          Vai alla funzionalità
			          <svg class="bi" width="1em" height="1em"><use xlink:href="#chevron-right"/></svg>
			        </a>
			      </div>
			      </c:if>
			    
			    
			    </div>
			  </div>
		</div>
	</main>

	<!-- Footer -->
	<jsp:include page="./footer.jsp" />
</body>
</html>