package metier;

import java.util.List;

import dao.ServiceDao;

public class ServiceMetier {

	

	public static Etudiant getEtudiant(String cne , String motPasse) {
		
		return ServiceDao.getEtudiant(cne, motPasse) ;
	}
	public static boolean addEtudiant(Etudiant e) {
		ServiceDao.addEtudiant(e);
		return true ;
	}
	public static List<Exemplaire> getExemplaireDispo(){
		
		return ServiceDao.getExemplaireDispo() ;
	}
    public static List<String> getCodeExemplaireDispo(){
		
		return ServiceDao.getCodeExemplaireDispo() ;
	}
    public static boolean addEmprunt(Long id, String codeExemplaire) {
    	ServiceDao.addEmprunt(id, codeExemplaire);
    	return true ; 
    }

}
