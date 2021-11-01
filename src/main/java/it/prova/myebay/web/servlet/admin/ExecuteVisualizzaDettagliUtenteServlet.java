package it.prova.myebay.web.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.myebay.model.Utente;
import it.prova.myebay.service.MyServiceFactory;


@WebServlet("/admin/ExecuteVisualizzaDettagliUtenteServlet")
public class ExecuteVisualizzaDettagliUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idUtenteParam = request.getParameter("idUtente");

		if (!NumberUtils.isCreatable(idUtenteParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		try {
			Utente utenteInstance = MyServiceFactory.getUtenteServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idUtenteParam));

			if (utenteInstance == null) {
				request.setAttribute("errorMessage", "Elemento non trovato.");
				request.getRequestDispatcher("ExecuteAnnunciServlet?operationResult=NOT_FOUND").forward(request,
						response);
				return;
			}

			request.setAttribute("dettagli_utenti_attr", utenteInstance);
		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore nel caricamento dei dettagli.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/admin/dettagliUtente.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}