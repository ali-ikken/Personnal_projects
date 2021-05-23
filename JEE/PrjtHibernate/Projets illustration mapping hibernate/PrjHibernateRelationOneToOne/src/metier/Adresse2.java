package metier;

import java.io.Serializable;
import java.util.Date;

public class Adresse2 implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id ;
	private String ligne1;
	private String ligne2;
	private String cp;
	private String ville;
	private String ligne3;
	private Personne2 personne;
	
	public Adresse2() {
	}
	
	public Adresse2(String ligne1, String ligne2, String cp, String ville, String ligne3) {
		this.ligne1 = ligne1;
		this.ligne2 = ligne2;
		this.cp = cp;
		this.ville = ville;
		this.ligne3 = ligne3;

	}


	public String getLigne1() {
		return ligne1;
	}
	public void setLigne1(String ligne1) {
		this.ligne1 = ligne1;
	}
	public String getLigne2() {
		return ligne2;
	}
	public void setLigne2(String ligne2) {
		this.ligne2 = ligne2;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getLigne3() {
		return ligne3;
	}
	public void setLigne3(String ligne3) {
		this.ligne3 = ligne3;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Personne2 getPersonne() {
		return personne;
	}

	public void setPersonne(Personne2 personne) {
		this.personne = personne;
	}
  
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", ligne1=" + ligne1 + ", ligne2=" + ligne2 + ", cp=" + cp + ", ville=" + ville
				+ ", ligne3=" + ligne3 + ", personne=" + personne + "]";
	}
	
	
	
	
	
}
