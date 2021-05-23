import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.Session;

import metier.*;
import dao.HibernateUtil;
import dao.ServiceDAO;

public class Test {

	public static void main(String[] args) {


		System.out.println(("Debut"));
		HibernateUtil.getSessionFactory().openSession();
		
		// test  many to many
		
		for ( int index = 1; index<=5; index++) {
			Personne personne = new Personne("ENSA","FI_" + index,new Date());
			ServiceDAO.addPersonne(personne);
			
		}
		for ( int index = 1; index<=5; index++) {
			Reunion reunion = new Reunion(new Date(), "ENSA_Reunion"+index);
			ServiceDAO.addReunion(reunion);
			
		}
			
		
		
	    for ( int index = 1; index<=5; index++) {
	    	ServiceDAO.addReunionToPersonne(index, index) ;
			ServiceDAO.addReunionToPersonne(index, 6-index) ;	
		}
			
			
	    HibernateUtil.getSessionFactory().close();
	    System.out.println(("Fin"));
	    
	}

}
