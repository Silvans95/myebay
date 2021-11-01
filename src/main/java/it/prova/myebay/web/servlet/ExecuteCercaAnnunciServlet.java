package it.prova.myebay.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.prova.myebay.model.Annuncio;
import it.prova.myebay.service.MyServiceFactory;
import it.prova.myebay.utility.UtilityForm;

@WebServlet("/ExecuteCercaAnnunciServlet")
public class ExecuteCercaAnnunciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String testoAnnuncioParam = request.getParameter("testoAnnuncio");
		String prezzoParam = request.getParameter("prezzo");
		String[] categoriaInputParam = request.getParameterValues("categoriaInput");

		try {
			
			Annuncio example = UtilityForm.createAnnuncioFromParams(testoAnnuncioParam, prezzoParam);
			request.setAttribute("annunci_list_attribute", MyServiceFactory.getAnnuncioServiceInstance().findByExample(example));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/listAnnunci.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String testoAnnuncioParam = request.getParameter("testoAnnuncio");
		String prezzoParam = request.getParameter("prezzo");
		String[] categoriaInputParam = request.getParameterValues("categoriaInput");

		try {
			
			Annuncio example = UtilityForm.createAnnuncioFromParams(testoAnnuncioParam, prezzoParam);
			request.setAttribute("annunci_list_attribute", MyServiceFactory.getAnnuncioServiceInstance().findByExample(example));
			System.out.println(MyServiceFactory.getAnnuncioServiceInstance().findByExample(example).size());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/listAnnunci.jsp").forward(request, response);
	}


}
