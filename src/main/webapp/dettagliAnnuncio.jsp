<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="it" class="h-100">
<head>

<!-- Common imports in pages -->
<jsp:include page="./header.jsp" />

<title>Visualizza Elemento</title>

</head>
<body class="d-flex flex-column h-100">

	<!-- Fixed navbar -->
	<jsp:include page="./navbar.jsp"></jsp:include>


	<!-- Begin page content -->
	<main class="flex-shrink-0">
		<div class="container">

			<div class='card'>
				<div class='card-header'>
					<h5>Visualizza dettaglio</h5>
				</div>


				<div class='card-body'>
					<dl class="row">
						<dt class="col-sm-3 text-right">Id:</dt>
						<dd class="col-sm-9">${dettagli_annunci_attr.id}</dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Annuncio:</dt>
						<dd class="col-sm-9">${dettagli_annunci_attr.testoAnnuncio}</dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Prezzo:</dt>
						<dd class="col-sm-9">${dettagli_annunci_attr.prezzo}</dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Proprietario Annuncio:</dt>
						<dd class="col-sm-9">${dettagli_annunci_attr.utenteInserimento}</dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Stato Annuncio:</dt>
						<dd class="col-sm-9">${dettagli_annunci_attr.aperto}</dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Data Pubblicazione:</dt>
						<dd class="col-sm-9">
							<fmt:formatDate type="date"
								value="${dettagli_annunci_attr.dataAnnuncio}" />
						</dd>
					</dl>

				</div>
				<!-- end card body -->



				<div class='card-footer'>
					<c:choose>
						<c:when test="${userInfo.isUser() || userInfo.isAdmin() }">
							<c:set value="${pageContext.request.contextPath}/user/ExecuteEffettuaAcquistoServlet" var="address"></c:set>
						</c:when>
						<c:otherwise>
							<c:set value="${pageContext.request.contextPath}/PrepareLoginServlet"
								var="address"></c:set>
						</c:otherwise>
					</c:choose>
					
					<form method="post" action="${address }" class="row g-3"
						novalidate="novalidate">
						
						<input type="hidden" name="idAnnuncio" value="${dettagli_annunci_attr.id}">
						<input type="hidden" name="prezzo" value="${dettagli_annunci_attr.prezzo}">
						
						
						<div class="col-12">
							
							<button type="submit" name="submit" value="submit" id="submit"
								class="btn btn-outline-success">Compra</button>
							
							<a href="ExecuteCercaAnnunciServlet"
								class='btn btn-outline-secondary'> 
							<i class='fa fa-chevron-left'></i> Back
							</a>
						</div>
					</form>
				</div>
				<!-- end card -->
			</div>


			<!-- end container -->
		</div>

	</main>

	<!-- Footer -->
	<jsp:include page="./footer.jsp" />
</body>
</html>