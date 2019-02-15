package fr.akharroub.pizzeria.pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.akharroub.pizzeria.pizza.busniess.impl.PizzaBusniess;

/**
 * Servlet implementation class SupprimerPizza
 */
@WebServlet(name = "supprimer_pizza", urlPatterns = { "/supprimer_pizza" })
public class SupprimerPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PizzaBusniess pzz =new PizzaBusniess();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerPizza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		
		pzz.supprimerpizz(id);
		
		response.sendRedirect("pizzas");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
