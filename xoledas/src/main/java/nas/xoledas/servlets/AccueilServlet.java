package nas.xoledas.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nas.xoledas.service.NasService;

public class AccueilServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		PrintWriter out = response.getWriter();
		
		//String name = request.getParameter("name"); recupère depuis l'url
		request.setAttribute("name", "hugo"); 
		//curl -X POST -F 'ping=10' -F 'up=111' -F 'do=555' http://localhost:8080/insertdata
		
		System.out.println("passage dans accueil servlet");
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueilNas.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    }
	

}
