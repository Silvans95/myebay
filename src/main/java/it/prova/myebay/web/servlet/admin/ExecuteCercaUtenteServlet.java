package it.prova.myebay.web.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.model.Utente;
import it.prova.myebay.service.MyServiceFactory;
import it.prova.myebay.utility.UtilityForm;

/**
 * Servlet implementation class ExecuteSearchUtenteServlet
 */
@WebServlet("/admin/ExecuteCercaUtenteServlet")
public class ExecuteCercaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String dataCreatedParam = request.getParameter("dataCreated");

		Utente example = new Utente(usernameParam, nomeParam, cognomeParam,
				UtilityForm.parseDateArrivoFromString(dataCreatedParam));

		try {
			request.setAttribute("utente_list_attr",
					MyServiceFactory.getUtenteServiceInstance().findByExample(example));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/admin/cercaUtente.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/admin/listUtenti.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String dataCreatedParam = request.getParameter("dataCreated");

		Utente example = new Utente(usernameParam, nomeParam, cognomeParam,
				UtilityForm.parseDateArrivoFromString(dataCreatedParam));

		try {
			request.setAttribute("utente_list_attr",
					MyServiceFactory.getUtenteServiceInstance().findByExample(example));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/admin/cercaUtente.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/admin/listUtenti.jsp").forward(request, response);
	}

}
