package it.prova.myebay.web.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrepareVisualizzaUtenteServlet
 */
@WebServlet("/admin/PrepareCercaUtenteServlet")
public class PrepareCercaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/admin/cercaUtente.jsp").forward(request, response);
	}

}
