package fr.akharroub.pizzeria.pizza.repository;

import java.util.ArrayList;

import fr.akharroub.pizzeria.pizza.bean.Pizza;

public interface IRepositoryPizza {

	public ArrayList<Pizza> findAll();
	
	public Pizza findone (int id);
	
	public void supprimerpizz (int id);
	
	public boolean ajouterpizza(int numero, String libelle, String reference, Double prix, String description, String urlImage ); 

	public boolean modifierpizza(int id ,int numero, String libelle, String reference, Double prix, String description, String urlImage );

}
