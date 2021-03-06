package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VilleDaoImpl;
import dto.Ville;

/**
 * Servlet implementation class AjouterVille
 */
@WebServlet("/AjouterVille")
public class AjouterVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterVille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String codeCommune = request.getParameter("codeCommune");
		String codePostal = request.getParameter("codePostal");
		String libelle = request.getParameter("libelle");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String ligne5 = request.getParameter("ligne5");
		
		VilleDaoImpl villeDaoImpl = new VilleDaoImpl();
		villeDaoImpl.ajouterVille(nom, codeCommune, codePostal, ligne5, libelle, longitude, latitude);
		
		Ville ville =villeDaoImpl.VilleAvecCode(codeCommune);
		request.setAttribute("ville", ville);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/villeAjoutee.jsp").forward(request, response);	
	}

}
