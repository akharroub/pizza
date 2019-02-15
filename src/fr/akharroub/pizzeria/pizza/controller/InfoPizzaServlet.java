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
 * Servlet implementation class InfoPizzaServlet
 */
@WebServlet(name = "info_pizza", urlPatterns = { "/info_pizza" })
public class InfoPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PizzaBusniess pzz = new PizzaBusniess();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoPizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idi = request.getParameter("id");
		int id = Integer.parseInt(idi);
		
		Pizza pizza = pzz.findone(id);
		request.setAttribute("pizza", pizza);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/pizza_info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
