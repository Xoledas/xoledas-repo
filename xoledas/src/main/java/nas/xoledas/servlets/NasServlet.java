package nas.xoledas.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nas.xoledas.service.NasService;

public class NasServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
		//this.getServletContext().getRequestDispatcher("/WEB-INF/accueilNas.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("ping :"+request.getParameter("ping"));
		//récupération paramètres
		Integer ping = Integer.parseInt(request.getParameter("ping"));
		Integer upl = Integer.parseInt(request.getParameter("up"));
		Integer dow = Integer.parseInt(request.getParameter("do"));
		
		boolean retour = NasService.getInstance().insertData(ping,upl,dow);
		
		if (retour) {
			out.println("OK");
		} else {
			out.println("KO");
		}
    }
	

}
