package metier;

import java.io.Serializable;

public class Etudiant extends Personne implements Serializable {
    
	protected String cne;


	public String getCne() {
		return cne;
	}



	public void setCne(String cne) {
		this.cne = cne;
	}

    public String getNomPrenom(){
    	return nom +"  "+prenom ;  
    }

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Etudiant(String nom, String prenom, String motPasse , String cne) {
		super(nom, prenom, motPasse);
		this.cne = cne ;
		// TODO Auto-generated constructor stub
	}

 




	
	
}
