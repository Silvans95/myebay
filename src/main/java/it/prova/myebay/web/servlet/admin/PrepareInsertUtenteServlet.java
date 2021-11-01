package it.prova.myebay.web.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.model.Utente;

@WebServlet("/admin/PrepareInsertUtenteServlet")
public class PrepareInsertUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//metto un bean 'vuoto' in request perché per la pagina risulta necessario
			request.setAttribute("insert_user_attr", new Utente());
			// questo mi serve per la select di ruoli in pagina
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/admin/insertUtente.jsp").forward(request, response);
	}

}
