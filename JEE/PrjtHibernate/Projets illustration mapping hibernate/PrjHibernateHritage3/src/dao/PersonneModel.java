package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import metier.*;



public class PersonneModel {
   
	public static boolean addCompte(Compte compte)  {
    	Session session=null;
	    try {
	      session=HibernateUtil.getSessionFactory().getCurrentSession();
	      session.beginTransaction();
	      session.save(compte);  
	      session.getTransaction().commit();
	    } catch (Exception e) {      
	    		System.out.println(e.getMessage());
	    } 
	    return true;
    }
	public static List<Compte>  getListComptes(){
		Session session=HibernateUtil.getSessionFactory().getCurrentSession() ;
    	session.beginTransaction();
		Query req=session.createQuery("from Compte");
		return req.list();
    }
    
    
}
