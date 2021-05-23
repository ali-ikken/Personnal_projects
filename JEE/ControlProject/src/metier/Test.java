package metier;

import dao.ServiceDao;

public class Test {
  public static void main(String[] args) {
	   
	  for(int i =10 ; i<40 ; i++) {
	   Etudiant e = new Etudiant("nom"+i, "prenom" +i, "motPasse"+i, "FFcne"+i) ;
	   Livre liv = new Livre("titre" +2*i) ;
	   Exemplaire ex =new Exemplaire("code"+i, true, liv) ;
	   ServiceDao.addEtudiant(e);
	   ServiceDao.addLivre(liv) ;
	   ServiceDao.addExemplaire(ex); 
	  }  

	 
}
}
