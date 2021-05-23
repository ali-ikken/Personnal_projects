import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;

import metier.*;
import dao.HibernateUtil;
import dao.PersonneModel;

public class Test {

	public static void main(String[] args) {


		Session session=HibernateUtil.getSessionFactory().openSession();
	     
	    //int index = 1;
	    for (int index=1; index<6;index++) {
		    BigDecimal solde=new BigDecimal(1000*index) ;
			Compte compte = new Compte("numero-"+index, solde);
		    PersonneModel.addCompte(compte);
		    CompteCourant compteCourant= new CompteCourant(compte, index*100);
		    PersonneModel.addCompte(compteCourant);
		    compte= new CompteEpargne(compte, new BigDecimal((double) index/10));
		    PersonneModel.addCompte(compte);
	    }
	    for (Compte compte: PersonneModel.getListComptes()) {
	    	System.out.println((compte.toString()));
	    }



	    

	}

}
