package fr.akharroub.pizzeria.pizza.busniess.impl;

import java.util.ArrayList;

import fr.akharroub.pizzeria.pizza.bean.Pizza;
import fr.akharroub.pizzeria.pizza.busniess.IPizzaBusniess;
import fr.akharroub.pizzeria.pizza.repository.impl.RepositoryPizza;

public class PizzaBusniess implements IPizzaBusniess{
	RepositoryPizza pz = new RepositoryPizza();

	@Override
	public ArrayList<Pizza> findAll() {
		ArrayList<Pizza> TtLesPizza = pz.findAll();
		return TtLesPizza;
	}

	@Override
	public Pizza findone(int id) {
		Pizza p = pz.findone(id);
		return p;
	}

	@Override
	public void supprimerpizz(int id) {
	pz.supprimerpizz(id);	
		
	}

	@Override
	public boolean ajouterpizza(int numero, String libelle, String reference, Double prix, String description,
			String urlImage) {
		boolean p = pz.ajouterpizza(numero,libelle,reference,prix,description,urlImage);
		return p;
	}

	@Override
	public boolean modifierpizza(int id, int numero, String libelle, String reference, Double prix, String description,
			String urlImage) {
		boolean mopz = pz.modifierpizza(id,numero,libelle,reference,prix,description,urlImage);
		return mopz;
	}

}
