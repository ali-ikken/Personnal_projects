import java.util.Date;

import org.hibernate.Session;

import metier.*;
import dao.HibernateUtil;
import dao.PersonneDAO;

public class Test {

	public static void main(String[] args) {


		System.out.println(("Debut"));
		
		// test  one-to-one : une table
		/*
		for (int index = 1;index<=5;index++){
			Adresse adresse = new Adresse("ligne1_" + index, "ligne2_" + index, "cp_"
		     + index, "ville" + index, "ligne3_" + index);
		    Personne personne = new Personne("nom_" + index,"prenom_" + index, new Date(), adresse);
		    PersonneDAO.addPersonne(personne);
		}
	    */
		
		
		/*
		// test  one-to-one : clé primaire partagée
			
		for (int index = 1;index<=5;index++){
			Adresse2 adresse = new Adresse2("ligne1_" + index, "ligne2_" + index, "cp_"
		     + index, "ville" + index, "ligne3_" + index);
		    Personne2 personne = new Personne2("nom_" + index,"prenom_" + index,new Date(), adresse);
		    PersonneDAO.addPersonne2(personne);
		}
		*/
	
		
		
		for (int index = 1;index<=5;index++){
			Adresse3 adresse = new Adresse3("ligne1_" + index, "ligne2_" + index, "cp_"
		     + index, "ville" + index, "ligne3_" + index);
		    Personne3 personne = new Personne3("nom_" + index,"prenom_" + index,new Date(), adresse);
		    PersonneDAO.addPersonne3(personne);
	 	    System.out.println(("Fin"));
		}
		
		
		

	}

}
