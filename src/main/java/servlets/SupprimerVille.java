package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VilleDaoImpl;
import dto.Ville;

/**
 * Servlet implementation class SupprimerVille
 */
@WebServlet("/SupprimerVille")
public class SupprimerVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VilleDaoImpl villeDaoImpl = new VilleDaoImpl();
	Ville villes;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerVille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String villeSupprCode = request.getParameter("codeCommuneInsee");
		Ville ville =villeDaoImpl.VilleAvecCode(villeSupprCode);
		
		villeDaoImpl.SupprimerVille(villeSupprCode);
		System.out.println("le parametre est :" + villeSupprCode);
		
		request.setAttribute("codeCommuneInsee", villeSupprCode);
		request.setAttribute("ville", ville);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/supprimerVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
