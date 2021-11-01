package it.prova.myebay.web.servlet.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.model.Utente;
import it.prova.myebay.service.MyServiceFactory;
import it.prova.myebay.utility.UtilityForm;

@WebServlet("/ExecuteInsertUtenteServlet")
public class ExecuteInsertUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// estraggo input
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");
		String confirmPassworddParam = request.getParameter("confirmPassword");
		
		// preparo un bean (che mi serve sia per tornare in pagina
		// che per inserire) e faccio il binding dei parametri
		Utente utenteInstance = UtilityForm.createUtenteFromParams(nomeParam, cognomeParam, usernameParam,
				passwordParam);

		try {
			// se la validazione non risulta ok
			if (!UtilityForm.validateUtenteBean(utenteInstance)) {
				request.setAttribute("insert_utente_attr", utenteInstance);
			
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.getRequestDispatcher("/insertUtente.jsp").forward(request, response);
				return;
			}
			
			if (!passwordParam.equals(confirmPassworddParam)) {
				request.setAttribute("insert_utente_attr", utenteInstance);			
				// questo mi serve per la select di ruoli in pagina
				request.setAttribute("errorMessage", "Attenzione le due password non sono uguali");
				request.getRequestDispatcher("/insertUtente.jsp").forward(request, response);
				return;
				}
	
				MyServiceFactory.getUtenteServiceInstance().inserisciNuovo(utenteInstance);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/insertUtente.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		// uso il sendRedirect con parametro per evitare il problema del double save on
		// refresh
		response.sendRedirect("home");
	}

}
