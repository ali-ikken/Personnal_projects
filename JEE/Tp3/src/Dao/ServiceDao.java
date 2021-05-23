package Dao;
import Metier.*;
import Dao.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
public class ServiceDao {

	public static void addUserDao(User user) {
  try {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
	     session.beginTransaction() ; 
	     session.save(user) ; 
	     session.getTransaction().commit();
	     
	     
} catch (Exception e) {
	System.out.println("error : " +e.getMessage());
	// TODO: handle exception
}
	}
	
	public static void addReactionDao(Reaction reaction) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		     session.beginTransaction() ; 
		     session.save(reaction) ; 
		     session.getTransaction().commit();
		     
		} catch (Exception e) {
			System.out.println("error : " +e.getMessage());
			// TODO: handle exception
		}
		
	}
 
	public static void addNewsDao(News news)  {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		     session.beginTransaction() ; 
		     session.save(news) ; 
		     session.getTransaction().commit();
		    
		} catch (Exception e) {
			System.out.println("error : " +e.getMessage());
			// TODO: handle exception
		}
	
	}
	public static void updateReaction(Reaction react , int num) {
		try {

			Session ss = HibernateUtil.getSessionFactory().getCurrentSession() ; 
			ss.beginTransaction() ; 
			Reaction r = (Reaction) ss.load(Reaction.class, num) ;
			r.setReaction(react.getReaction());
			ss.update(r);
			ss.getTransaction().commit();
			
			
		} catch (Exception e) {
			System.out.println("error : " +e.getMessage());
			// TODO: handle exception
		}
	
	}
	
	public static List<Reaction> getAllReaction() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
	        session.beginTransaction() ; 
	        return session.createQuery("from Reaction ").list() ;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null ;
	}
	
	public static List<User> getAllUsers(){ 
		try {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ; 
        return session.createQuery("from User").list() ;
	   }catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
       return null ;
	}
 
	public static List<News> getAllNews() {
		try {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ; 
        return session.createQuery("from News ").list() ;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
        return null ;
	} 
 
}
