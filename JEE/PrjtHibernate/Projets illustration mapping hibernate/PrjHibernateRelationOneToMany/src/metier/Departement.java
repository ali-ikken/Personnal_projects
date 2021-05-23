package metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Departement implements Serializable{

	private long idDept ;
	private String intitule;
	private Set<Personne> personnes= new HashSet<Personne>();
	
	public Departement( String intitule) {
		
		this.intitule = intitule;
		
	}
	public Departement() {
	}
	public long getIdDept() {
		return idDept;
	}
	public void setIdDept(long idDept) {
		this.idDept = idDept;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public Set<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}
	@Override
	public String toString() {
		return "Departement [idDept=" + idDept + ", intitule=" + intitule + "]";
	}
	
	
	
	

}
