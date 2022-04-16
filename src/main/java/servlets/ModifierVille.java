package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VilleDaoImpl;
import dto.Ville;

/**
 * Servlet implementation class ModifierVille
 */
@WebServlet("/ModifierVille")
public class ModifierVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VilleDaoImpl villeDaoImpl = new VilleDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierVille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String villeModifCode = request.getParameter("codeCommuneInsee");
		Ville ville =villeDaoImpl.VilleAvecCode(villeModifCode);
		
		System.out.println("le parametre est :" + villeModifCode);
		
		request.setAttribute("codeCommuneInsee", villeModifCode);
		request.setAttribute("ville", ville);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierVille.jsp").forward(request, response);
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
		
		Ville villeNonModif =villeDaoImpl.VilleAvecCode(codeCommune);
		request.setAttribute("villeNonModif", villeNonModif);
		
		VilleDaoImpl villeDaoImpl = new VilleDaoImpl();
		villeDaoImpl.ModifierVille(nom, codeCommune, codePostal, ligne5, libelle, longitude, latitude);
		
		Ville villeModif =villeDaoImpl.VilleAvecCode(codeCommune);
		request.setAttribute("villeModif", villeModif);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/villeModifiee.jsp").forward(request, response);	
	}


}
