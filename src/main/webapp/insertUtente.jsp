<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="./header.jsp" />
	   
	   <title>Inserisci Nuovo Utente</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="./navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Inserisci nuovo elemento</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteInsertUtenteServlet" class="row g-3" novalidate="novalidate">
							
							
								<div class="col-md-6">
									<label>Nome</label>
									<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome" value="${insert_user_attr.nome }">
								</div>
								
								<div class="col-md-6">
									<label>Cognome</label>
									<input type="text" name="cognome" id="cognome" class="form-control" placeholder="Inserire il cognome" value="${insert_user_attr.cognome }">
								</div>
	
								<div class="col-md-6">
									<label>Username</label>
									<input type="text" name="username" id="username" class="form-control" placeholder="Inserire l'username" value="${insert_user_attr.username }">
								</div>
	
								<div class="col-md-6">
									<label>Password</label>
									<input type="password" name="password" id="password" class="form-control" placeholder="Inserire la password" value="${insert_user_attr.password }">
								</div>
	
								<div class="col-md-6">
									<label>Conferma Password</label>
									<input type="password" name="confirmPassword" id="confirmPassword" class="form-control" placeholder="Conferma la password">
								</div>
	
								<div class="col-12">
									<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
								</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
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