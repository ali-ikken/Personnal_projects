
package services;

import fichiersHibernate.HibernateUtil;
import java.util.List;
import metier.Etudiant;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class EtudiantServices {
    /*  CreateEtudiant(Etudiant et) : int
b. UpdateEtudiant (Etudiant et) : boolean
c. deleteEtudiant((Etudiant et) :boolean
d. findById(int id) : Etudiant
e. findAll() : List : List<Etudiant> */
    
    public static int createEtudiant(Etudiant et){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        Transaction tx = session.beginTransaction() ; 
        int i = (int) session.save(et) ;
       tx.commit(); 
     
       return i ;
    }
    public static boolean updateEtudiant(int id, String etablissment){
     Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
     session.beginTransaction() ;
     Etudiant e = (Etudiant) session.load(Etudiant.class, id) ;
     e.setEtablissement(etablissment);
     session.getTransaction().commit();
    return true ;
    }
    public static boolean deleteEtudiant(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
        session.beginTransaction() ;
        Etudiant e =  (Etudiant) session.load(Etudiant.class, id);
        session.delete(e); 
        session.getTransaction().commit();
    return true ;}
    
    
    public static Etudiant findById(int id) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
    session.beginTransaction() ;
    return (Etudiant) session.load(Etudiant.class, id) ;
    
    
    }
    public static List<Etudiant> findAll() {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
    session.beginTransaction() ;
    return session.createQuery("from Etudiant").list() ;
    }
    public static List<Etudiant> findEtudiantByFirstLetter(char c){
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession() ;
        ss.beginTransaction() ;
        Criteria criteria = ss.createCriteria(Etudiant.class);
        Criterion critere = Restrictions.like("nom" , "%"+c); 
        criteria.add(critere );
        return criteria.list() ;
    }
}
