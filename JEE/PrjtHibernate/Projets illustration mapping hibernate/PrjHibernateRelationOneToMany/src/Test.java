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
		
		for ( int index = 1; index<=3; index++) {
			Departement departement = new Departement("Dept_" + index);
			ServiceDAO.addDepartement(departement);
		}
		
		for ( int index = 1; index<=5; index++) {
			Departement dept=ServiceDAO.getDepartement(index/2+1);
			Personne personne = new Personne("ENSA","FI_" + index,new Date(), dept);
			ServiceDAO.addPersonne(personne);
		}
			
	
	
		
		for (Departement dept:ServiceDAO.getAllDepartements()) {
			System.out.println("=========================================================");
			System.out.println((dept.toString()));
			System.out.println("=====Les employes de departement =======");
			for (Personne p: dept.getPersonnes()) {
				System.out.println("     " + p.toString());
			}
			
		}
	    
	    System.out.println(("Fin"));

	}

}
