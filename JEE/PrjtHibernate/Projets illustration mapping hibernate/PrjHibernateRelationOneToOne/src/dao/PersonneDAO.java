package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import metier.*;



public class PersonneDAO {
   
	public static boolean addPersonne(Personne personne)  {
    	Session session=null;
	    try {
	      session=HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(personne);  
	      session.getTransaction().commit();
	    } catch (Exception e) {      
	    		System.out.println(e.getMessage());
	    } finally { if (session!=null) session.close();    }
	    return true;
    }
	public static boolean addPersonne2(Personne2 personne)  {
    	Session session=null;
	    try {
	      session=HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      personne.getAdresse().setPersonne(personne);//Hibernate ne prend pas en charge automatique les liens bidirectionnels 
	      session.save(personne);  
	      session.getTransaction().commit();
	    } catch (Exception e) {      
	    		System.out.println(e.getMessage());
	    } finally { if (session!=null) session.close();    }
	    return true;
    }
	
	public static boolean addPersonne3(Personne3 personne)  {
    	Session session=null;
	    try {
	      session=HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(personne);  
	      session.getTransaction().commit();
	    } catch (Exception e) {      
	    		System.out.println(e.getMessage());
	    } finally { if (session!=null) session.close();    }
	    return true;
    }
	

}
