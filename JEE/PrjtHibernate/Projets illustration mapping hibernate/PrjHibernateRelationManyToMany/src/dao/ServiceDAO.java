package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import metier.*;



public class ServiceDAO {
   
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
	public static boolean addReunion(Reunion reunion)  {
	    try {
	      Session session=HibernateUtil.getSessionFactory().getCurrentSession();
	      session.beginTransaction();
	      session.save(reunion);  
	      session.getTransaction().commit();
	    } catch (Exception e) {      
	    		System.out.println(e.getMessage());
	    } 
	    return true;
    }
	public static boolean addReunionToPersonne(long idPersonne, long idReunion) {
		try {
			  Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		      session.beginTransaction();
		      
		      // Charger la personne et la réunion
		      Personne personne = (Personne) session.load(Personne.class, idPersonne);
		      Reunion reunion = getReunion(idReunion);
		      
		      
		      reunion.addPersonne(personne);
		      
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
	public static Reunion getReunion(long idReunion) {
		try {
			  Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		      session.beginTransaction();
		      // Charger la personne et la réunion
		      return (Reunion) session.load(Reunion.class, idReunion);
		} catch (Exception e) {      
		    		System.out.println(e.getMessage());
        }
		    
		return null;
	}
	
	

}

	
	
	
	


