package nas.xoledas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nas.xoledas.beans.SpeedTest;
import nas.xoledas.service.NasService;

public class AccueilServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//PrintWriter out = response.getWriter();
		
		List<SpeedTest> listST = NasService.getInstance().getSpeedtestList();
		request.setAttribute("listTests", listST);
		
		System.out.println("passage dans accueil servlet");
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueilNas.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    }
	

}
