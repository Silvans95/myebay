package it.prova.myebay.web.servlet.annuncio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.model.Annuncio;
import it.prova.myebay.model.Utente;
import it.prova.myebay.service.MyServiceFactory;
import it.prova.myebay.utility.UtilityForm;

/**
 * Servlet implementation class ExecuteModificaAnnuncioServlet
 */
@WebServlet("/user/ExecuteModificaAnnuncioServlet")
public class ExecuteModificaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		// estraggo input
		String idParam = request.getParameter("idAnnuncio");
		String testoAnnuncioParam = request.getParameter("testoAnnuncio");
		String prezzoParam = request.getParameter("prezzo");
		String[] idCategorieParam = request.getParameterValues("categoriaInput");

		Annuncio annuncioInstance = UtilityForm.createAnnuncioFromParams(testoAnnuncioParam, prezzoParam);
		Utente utenteExample = (Utente) httpRequest.getSession().getAttribute("userInfo");

		// ora il mio annuncio ha un testo, un prezzo, una data e un booleano tramite il
		// metodo.
		annuncioInstance.setUtenteInserimento(utenteExample.getUsername());
		annuncioInstance.setUtente(utenteExample);
		
		annuncioInstance.setId(Long.parseLong(idParam));
		try {
			// se la validazione non risulta ok
			if (!UtilityForm.validateAnnuncioBean(annuncioInstance)) {
				request.setAttribute("update_annuncio_attr", annuncioInstance);

				// questo mi serve per la select di ruoli in pagina
				request.setAttribute("categorie_list_attribute",
						MyServiceFactory.getCategoriaServiceInstance().listAll());
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.getRequestDispatcher("/user/updateAnnuncio.jsp").forward(request, response);
				return;
			}

			for (String categoriaItem : idCategorieParam) {
				annuncioInstance.getCategorie().add(MyServiceFactory.getCategoriaServiceInstance().caricaSingoloElemento(Long.parseLong(categoriaItem)));
			}
			
			// occupiamoci delle operazioni di business
			MyServiceFactory.getAnnuncioServiceInstance().aggiorna(annuncioInstance);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("ExecuteGestioneAnnunciServlet?operationResult=ERROR");
			return;
		}

		// andiamo ai risultati
		// uso il sendRedirect con parametro per evitare il problema del double save on
		// refresh
		response.sendRedirect("ExecuteGestioneAnnunciServlet?operationResult=SUCCESS");

	}
}
