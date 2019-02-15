package fr.akharroub.pizzeria.pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.akharroub.pizzeria.pizza.bean.Pizza;
import fr.akharroub.pizzeria.pizza.busniess.impl.PizzaBusniess;

/**
 * Servlet implementation class ModifierPizzaServlet
 */
@WebServlet(name = "Modifier_pizza", urlPatterns = { "/Modifier_pizza" })
public class ModifierPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PizzaBusniess mp = new PizzaBusniess();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierPizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		
		Pizza pizza = mp.findone(id);
		request.setAttribute("pizza", pizza);
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/modifier_pizza.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString); 
		
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
		
	boolean yes = mp.modifierpizza(id, numero, libelle, reference, prix, description, urlImage);
	if(yes) {
		response.sendRedirect("info_pizza?id=" +id);
	}else {
		response.sendRedirect("Modifier_pizza?id=" +id);
	}
		
	}

}
