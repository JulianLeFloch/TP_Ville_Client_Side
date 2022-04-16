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
    	String choosenVilleToDel = request.getParameter("ville");

		if (choosenVilleToDel != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("ChangedVille", choosenVilleToDel);

			Ville ville = villeDaoImpl.VilleAvecCode(choosenVilleToDel);

			request.setAttribute("villeToDel", choosenVilleToDel);
			request.setAttribute("nom", ville.getNomCommune());
			request.setAttribute("cc", ville.getCodeCommuneInsee());
			request.setAttribute("cp", ville.getCodePostal());
			request.setAttribute("lat", ville.getLatitude());
			request.setAttribute("lon", ville.getLongitude());
			request.setAttribute("libelle", ville.getLibelleAcheminement());
			request.setAttribute("ligne", ville.getLigne5());
			
			
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String villeToDel = (String)request.getSession().getAttribute("ChangedVille");
		String nom = request.getParameter("nom");
		String cc = request.getParameter("cc");
		String cp = request.getParameter("cp");
		String lat = request.getParameter("lat");
		String lon = request.getParameter("lon");
		String libelle = request.getParameter("libelle");
		String ligne = request.getParameter("ligne");

	
		
		System.out.println("QJNFJDGNSGUS9DHGUSHU : *-----" + villeToDel+ "-------" );
		villeDaoImpl.modifierVille(nom, cc, cp, ligne, libelle,lon, lat);
		doGet(request, response);
	}


}
