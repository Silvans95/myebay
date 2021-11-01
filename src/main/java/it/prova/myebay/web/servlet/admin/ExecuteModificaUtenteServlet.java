package it.prova.myebay.web.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.model.StatoUtente;
import it.prova.myebay.model.Utente;
import it.prova.myebay.service.MyServiceFactory;
import it.prova.myebay.utility.UtilityForm;

/**
 * Servlet implementation class ExecuteModificaUtenteServlet
 */
@WebServlet("/admin/ExecuteModificaUtenteServlet")
public class ExecuteModificaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("idUtente");
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");
		String statoParam = request.getParameter("stato");
		
		Utente utenteInstance = new Utente( usernameParam, passwordParam, nomeParam, cognomeParam);
		Long idUtenteParam = Long.parseLong(idParam);
		utenteInstance.setId(idUtenteParam);
		try {
			
			Utente utenteDaAggionare = MyServiceFactory.getUtenteServiceInstance().caricaSingoloElemento(idUtenteParam);
			utenteInstance.setCreditoResiduo(utenteDaAggionare.getCreditoResiduo());
			utenteInstance.setDateCreated(utenteDaAggionare.getDateCreated());
			utenteInstance.setStato(StatoUtente.valueOf(statoParam));
			
			MyServiceFactory.getUtenteServiceInstance().aggiorna(utenteInstance);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}
		response.sendRedirect("ExecuteCercaUtenteServlet?operationResult=SUCCESS");
	}
}
