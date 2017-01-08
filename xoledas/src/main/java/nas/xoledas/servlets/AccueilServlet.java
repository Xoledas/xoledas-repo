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

public class AccueilServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** Log4j **/
	final static Logger log = Logger.getLogger(NasService.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		PrintWriter out = response.getWriter();
		
		try {
		
			HashMap<String,Object> formattedSpeedTMap = NasService.getInstance().getSpeedtestList();
			request.setAttribute("formattedMap", formattedSpeedTMap);
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueilNas.jsp").forward(request, response);
			
		} catch (Exception e) {
			log.error("Erreur lors du chargement de la page. Error : " + e.getMessage());
			out.println("Oups... Une erreur est survenue.");
		}
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    }
	

}
