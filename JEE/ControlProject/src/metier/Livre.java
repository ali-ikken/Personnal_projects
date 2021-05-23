package metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Livre implements Serializable {
   
	private Long num ; 
	private String titre  ;
	private Set<Exemplaire> exemplaires =new HashSet<Exemplaire>() ; 
	
	
	
	public Set<Exemplaire> getExemplaires() {
		return exemplaires;
	}
	public void setExemplaires(Set<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}
	
	public void setNum(Long num) {
		this.num = num;
	}
	public Long getNum() {
		return num;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Livre(String titre) {
		super();
		this.titre = titre;
		
	}
	
	
	
}
