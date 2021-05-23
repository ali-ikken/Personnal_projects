package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.sun.org.apache.regexp.internal.recompile;

import metier.*;

public class ServiceDao {
	
	/*   getEtudiant(CNE: long, motPasse:String) : Etudiant //verifie l’existance d’un etudiant dans la BD
+ addEtudiant(etudiant : Etudiant) : boolean // ajout d’un nouveau etudiant à la BD
+ getExemplaireDispo() : list<Object> // liste des codes et titres des exemplaires disponibles
+ getCodeExemplaireDispo() : list<String> // liste des codes des exemplaires disponibles
+ addEmprunt(CNE : String, codeExemplaire: String) : boolean*/
	public static boolean addEtudiant(Etudiant e) {
		try {
		Session session =  HibernateUtil.getSessionFactory().getCurrentSession() ;
		session.beginTransaction() ; 
		session.save(e) ; 
		session.getTransaction().commit();
		return true ;
		} catch (Exception ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}
		return false ;
		}
	public static boolean addLivre(Livre liv) {
		try {
		Session session =  HibernateUtil.getSessionFactory().getCurrentSession() ;
		session.beginTransaction() ; 
		session.save(liv) ; 
		session.getTransaction().commit();
		return true ;
		} catch (Exception ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}
		return false ;
		}
   public static Etudiant getEtudiant(String cne , String motPasse) {
	   try {
	   Session ss = HibernateUtil.getSessionFactory().getCurrentSession() ; 
	   ss.beginTransaction() ; 
	   Criteria criteria = ss.createCriteria(Etudiant.class) ;
	   Criterion critere = Restrictions.like("cne", cne) ; 
	   criteria.add(critere);
	   critere = Restrictions.like("motPasse", motPasse) ;
	   criteria.add(critere) ;
	   if(criteria.list().size()==0) return null ;
	   else return (Etudiant) criteria.list().get(0) ;
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	} return null ;
   }
   public static List<Exemplaire> getExemplaireDispo(){
	   try {
	   Session ss = HibernateUtil.getSessionFactory().getCurrentSession() ;
	   ss.beginTransaction() ;
	   //select ex.code , liv.titre from Exemplaire ex JOIN ex.livre liv where ex.disponible = true
	   return ss.createQuery("from Exemplaire ").list() ;
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	}return null ;
	   }
   public static List<String> getCodeExemplaireDispo(){
	   try {
	   Session ss = HibernateUtil.getSessionFactory().getCurrentSession() ;
	   ss.beginTransaction() ;
	   
	   return ss.createSQLQuery("select code from Exemplaire where Exemplaire.disponible = true ").list();
	   } catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	} 
	   return null ;
	   }
   public static boolean addEmprunt(Long cne , String codeExemplaire) {
	   try {
	   Session ss = HibernateUtil.getSessionFactory().getCurrentSession() ;
	   ss.beginTransaction(); 
	   Etudiant e = (Etudiant) ss.load(Etudiant.class, cne) ;
	   Exemplaire ex = (Exemplaire) ss.load(Exemplaire.class, codeExemplaire);
	   e.getExemplaires().add(ex);
	   ex.setDisponible(false);
       ss.getTransaction().commit();	 
	   return true ;
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	} return false ;
	   }
	public static boolean addExemplaire(Exemplaire e) {
		try {
		Session session =  HibernateUtil.getSessionFactory().getCurrentSession() ;
		session.beginTransaction() ; 
		session.save(e) ; 
		session.getTransaction().commit();
		return true ;
		} catch (Exception ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}
		return false ;
		}
   
}
