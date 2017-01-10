package nas.xoledas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import nas.xoledas.service.NasService;

public class GraphiquesServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	/** Log4j **/
	final static Logger log = Logger.getLogger(GraphiquesServlet.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
		PrintWriter out = response.getWriter();
		try {
			HashMap<String,Object> formattedSpeedTMap = NasService.getInstance().getSpeedtestList(null,null);
			request.setAttribute("formattedMap", formattedSpeedTMap);
			log.info("Fin traitement métier graphiqueservlet");
			this.getServletContext().getRequestDispatcher("/WEB-INF/graphiques-details.jsp").forward(request, response);
		} catch (Exception e) {
			log.error("Erreur lors du chargement de la page. Error : " + e.getMessage());
			out.println("Oups... Une erreur est survenue.");
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			// on récpère les paramètres du formulaires
			String dateD = request.getParameter("dated");
			String dateF = request.getParameter("datef");
			dateD = (dateD != null && !dateD.isEmpty()) ? dateD : null;
			dateF = (dateF != null && !dateF.isEmpty()) ? dateF : null;
			log.info("début affichage des tests. Paramètres : " + dateD + " & " + dateF);
			//on appelle la méthode de traitement métier
			HashMap<String,Object> formattedSpeedTMap = NasService.getInstance().getSpeedtestList(dateD,dateF);
			//on set la map de retour
			request.setAttribute("formattedMap", formattedSpeedTMap);
			//on set les paramètres pour les afficher
			request.setAttribute("datede", dateD);
			request.setAttribute("datefi", dateF);
			
			log.info("Fin traitement métier graphiqueservlet avec paramètres de recherche");
			//appelle de la jsp view de retour
			this.getServletContext().getRequestDispatcher("/WEB-INF/graphiques-details.jsp").forward(request, response);
		} catch (Exception e) {
			log.error("Erreur lors du chargement de la page. Error : " + e.getMessage());
			out.println("Oups... Une erreur est survenue.");
		}
    }
	

}
