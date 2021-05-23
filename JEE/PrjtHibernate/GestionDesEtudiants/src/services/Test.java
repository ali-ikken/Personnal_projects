
package services;

import java.util.Iterator;
import java.util.List;
import metier.Etudiant;

public class Test {
    public static void main(String[] args) {
         
        
        //Q1 : Créer cinq étudiants, 
       /* 
     Etudiant e1 = new Etudiant("ikken", "Ali", "ENSAB") ;
     Etudiant e2 = new Etudiant("adel", "karim", "ENSAB") ;
     Etudiant e3 = new Etudiant("ikken", "houda", "ispits") ;
     Etudiant e4 = new Etudiant("ikken", "bouchra", "fsjm") ;
     Etudiant e5 = new Etudiant("ikken", "mohamed", "ARM meknes") ;
     EtudiantServices.createEtudiant(e1) ;
     EtudiantServices.createEtudiant(e2) ;
     EtudiantServices.createEtudiant(e3) ;
     EtudiantServices.createEtudiant(e4) ;
     EtudiantServices.createEtudiant(e5) ;
     
     */
       //Q2 : ▪ Afficher la liste des étudiants,
       /*
      List ets = EtudiantServices.findAll() ;
     for (Iterator it = ets.iterator(); it.hasNext();) {
            Etudiant e = (Etudiant) it.next();
            System.out.println(e.toString());
         }
     
     */
       
       //Q3 : ▪ Afficher les informations de l’étudiant dont id = 2 
       /*
       Etudiant et = EtudiantServices.findById(2) ;
        System.out.println("les infos de l'etuf 2 : " +et.toString());  
       */
        //Q4 : ▪ Supprimer l’étudiant dont id = 3,
        
        /* 
        EtudiantServices.deleteEtudiant(3) ;
       
        */
        //Q5 : Modifier les informations de l’étudiant dont id = 1,
              /*
              EtudiantServices.updateEtudiant(1, "ENSA Berrechid") ;
           */
              
              
        //Q6 : Afficher la liste des étudiants dont le nom commence par « A »
        List ets =  EtudiantServices.findEtudiantByFirstLetter('i') ; 
        Iterator it = ets.iterator() ;
        while(it.hasNext()){
        Etudiant e = (Etudiant) it.next();
        System.out.println("Etudiants dont le nom commence par A :" +e.toString());
        }
         
        
    }
}
