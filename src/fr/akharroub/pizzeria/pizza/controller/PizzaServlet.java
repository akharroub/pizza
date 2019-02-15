package fr.akharroub.pizzeria.pizza.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.akharroub.pizzeria.pizza.bean.Pizza;
import fr.akharroub.pizzeria.pizza.busniess.impl.PizzaBusniess;

/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet(name = "pizzas", urlPatterns = { "/pizzas" })
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PizzaBusniess pizza = new PizzaBusniess();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Pizza> pii = pizza.findAll();
		request.setAttribute("pizza", pii);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/pizza.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
