package it.prova.myebay.web.servlet.acquisto;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.model.Acquisto;
import it.prova.myebay.model.Annuncio;
import it.prova.myebay.model.Utente;
import it.prova.myebay.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteEffettuaAcquistoServlet
 */
@WebServlet("/user/ExecuteEffettuaAcquistoServlet")
public class ExecuteEffettuaAcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
			String idAnnuncioParam = request.getParameter("idAnnuncio");
			String prezzoParam = request.getParameter("prezzo");
			Integer prezzo = Integer.parseInt(prezzoParam);
			Utente utenteInstance = (Utente) httpRequest.getSession().getAttribute("userInfo");
			
		try {
			Annuncio annuncioInstance = MyServiceFactory.getAnnuncioServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idAnnuncioParam));
			
			if (utenteInstance.getCreditoResiduo() - prezzo < 0) {
				request.setAttribute("dettagli_annunci_attr", annuncioInstance);
				request.setAttribute("errorMessage",
						"Credito Insufficiente.");
				request.getRequestDispatcher("/dettagliAnnuncio.jsp").forward(request, response);
				return;
			}
			
			utenteInstance.setCreditoResiduo(utenteInstance.getCreditoResiduo() - prezzo);
			annuncioInstance.setAperto(false);
			
			Acquisto acquistoInstance = new Acquisto(annuncioInstance.getTestoAnnuncio(), annuncioInstance.getPrezzo(),
					annuncioInstance.getUtenteInserimento(), new Date());
			
			acquistoInstance.setUtente(utenteInstance);
			
			MyServiceFactory.getAcquistoServiceInstance().inserisciNuovo(acquistoInstance);
			MyServiceFactory.getUtenteServiceInstance().aggiorna(utenteInstance);
			MyServiceFactory.getAnnuncioServiceInstance().aggiorna(annuncioInstance);
			response.sendRedirect("ExecuteVisualizzaAcquistiServlet");
			
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}

}
