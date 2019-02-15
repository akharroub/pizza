package fr.akharroub.pizzeria.pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.akharroub.pizzeria.pizza.busniess.impl.PizzaBusniess;

/**
 * Servlet implementation class AjouterPizzaServlet
 */
@WebServlet(name = "ajouter-pizza", urlPatterns = { "/ajouter-pizza" })
public class AjouterPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PizzaBusniess ajopz = new PizzaBusniess();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterPizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajouterPizza.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numeroI = request.getParameter("numero");
		int numero = 0;
		
		try {
			numero = Integer.parseInt(numeroI);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("ajouter-pizza");
			return;
		}
		
		String libelle = request.getParameter("libelle");
		String reference = request.getParameter("reference");
		
		String prixI = request.getParameter("prix");
		double prix = 0;
		try {
			prix = Double.parseDouble(prixI);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("ajouter-pizza");
			return;
		}
		
		String description = request.getParameter("description");
		String urlImage = request.getParameter("urlImage");
		
		if( libelle.equals("") || reference.equals("") || description.equals("") || urlImage.equals("")) {
			
			response.sendRedirect("ajouter-pizza");
			return;
		}
		boolean yes = ajopz.ajouterpizza( numero, libelle, reference, prix, description, urlImage);
		if(yes) {
			response.sendRedirect("pizzas");
		}else{
			response.sendRedirect("ajouter-pizza");
		}
	
	}

}
