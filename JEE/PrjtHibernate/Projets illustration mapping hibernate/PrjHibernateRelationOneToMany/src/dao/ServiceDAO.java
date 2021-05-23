package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import metier.*;



public class ServiceDAO {
   
	public static boolean addDepartement(Departement departement)  {
    	try {
	      Session session=HibernateUtil.getSessionFactory().getCurrentSession();
	      session.beginTransaction();
	      session.save(departement);  
	      session.getTransaction().commit();
	    } catch (Exception e) {      
	    		System.out.println(e.getMessage());
	    } 
	    return true;
    }
	public static Departement getDepartement(long idDept) {
		try {
			  Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		      session.beginTransaction();
		      // Charger la personne et la réunion
		      return ((Departement) session.load(Departement.class, idDept));
		} catch (Exception e) {      
		    		System.out.println(e.getMessage());
        }
		return null;
	}
	public static boolean addPersonne(Personne personne)  {
    	try {
	      Session session=HibernateUtil.getSessionFactory().getCurrentSession();
	      session.beginTransaction();
	      session.save(personne);  
	      session.getTransaction().commit();
	    } catch (Exception e) {      
	    		System.out.println(e.getMessage());
	    } 
	    return true;
    }
	
	public static Personne getPersonne(long idPersonne) {
		try {
			  Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		      session.beginTransaction();
		      // Charger la personne et la réunion
		      return ((Personne) session.load(Personne.class, idPersonne));
		} catch (Exception e) {      
		    		System.out.println(e.getMessage());
        }
		return null;
	}
	
	public static List<Personne> getAllPersonnes() {
		try {
			  Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		      session.beginTransaction();
   			  Query req=session.createQuery("from Personne");
			  return  req.list()  ;

		} catch (Exception e) {      
		    		System.out.println(e.getMessage());
        }
		return null;
	}
	public static List<Departement> getAllDepartements() {
		try {
			  Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		      session.beginTransaction();
   			  Query req=session.createQuery("from Departement");
			  return req.list();

		} catch (Exception e) {      
		    		System.out.println(e.getMessage());
        }
		return null;
	}
	
	

	

}

	
	
	
	


