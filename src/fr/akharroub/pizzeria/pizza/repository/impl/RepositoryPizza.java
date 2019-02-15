package fr.akharroub.pizzeria.pizza.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.akharroub.pizzeria.pizza.bean.Pizza;
import fr.akharroub.pizzeria.pizza.repository.IRepositoryPizza;

public class RepositoryPizza implements IRepositoryPizza{

	@Override
	public ArrayList<Pizza> findAll() {
		ArrayList<Pizza> TtLesPizza = new ArrayList<>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/bizzeria", "root", "");

			Statement st = cnx.createStatement();
			ResultSet resultat = 
					st.executeQuery("SELECT id,numero,libelle,reference,prix,description,urlImage FROM pizza");

			while (resultat.next()) {
				int id = resultat.getInt("id");
				int numero = resultat.getInt("numero");
				String libelle = resultat.getString("libelle");
				String reference = resultat.getString("reference");
				double prix = resultat.getDouble("prix");
				String description = resultat.getString("description");
				String urlImage = resultat.getString("urlImage");
				
				Pizza pz = new Pizza (id, numero, libelle, reference, prix, description, urlImage);
				TtLesPizza.add(pz);
				
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TtLesPizza;
	}

	@Override
	public Pizza findone(int id) {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bizzeria", "root", "");
			Statement st = cnx.createStatement();
			ResultSet resultat = st.executeQuery("SELECT id,numero,libelle,reference,prix,description,urlImage FROM pizza where id =" + id);
			while (resultat.next()) {
				int idii = resultat.getInt("id");
				int numero = resultat.getInt("numero");
				String libelle = resultat.getString("libelle");
				String reference = resultat.getString("reference");
				double prix = resultat.getDouble("prix");
				String description = resultat.getString("description");
				String urlImage = resultat.getString("urlImage");
				Pizza pzz = new Pizza (idii, numero, libelle, reference, prix, description, urlImage);
				return pzz;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void supprimerpizz(int id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bizzeria", "root", "");
			Statement st = cnx.createStatement();
			st.executeQuery("DELETE FROM pizza WHERE id = " + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean ajouterpizza( int numero, String libelle, String reference, Double prix, String description,
			String urlImage) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bizzeria", "root", "");
			PreparedStatement ps = cnx.prepareStatement("Insert into pizza (numero,libelle,reference,prix,description,urlImage) values (?,?,?,?,?,?) ");
			
			ps.setInt(1,numero);
			ps.setString(2,libelle );
			ps.setString(3,reference );
			ps.setDouble(4, prix);
			ps.setString(5, description);
			ps.setString(6,urlImage );
			
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modifierpizza(int id, int numero, String libelle, String reference, Double prix, String description,
			String urlImage) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bizzeria", "root", "");
			PreparedStatement ps = cnx.prepareStatement("update pizza set numero = ?,libelle = ? ,reference = ? ,prix = ? ,description = ? ,urlImage = ? where id= ?");
			ps.setInt(1, numero);
			ps.setString(2,libelle );
			ps.setString(3,reference );
			ps.setDouble(4, prix);
			ps.setString(5, description);
			ps.setString(6, urlImage);
			ps.setInt(7, id);
			
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
