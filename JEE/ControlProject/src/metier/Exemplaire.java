package metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Exemplaire implements Serializable{
  private String code ; 
  private boolean disponible ;
  private Livre livre ; 
  private Set<Personne> personnes = new HashSet<Personne>();
  
  
public Set<Personne> getPersonnes() {
	return personnes;
}
public void setPersonnes(Set<Personne> personnes) {
	this.personnes = personnes;
}
public Livre getLivre() {
	return livre;
}
public void setLivre(Livre livre) {
	this.livre = livre;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public boolean isDisponible() {
	return disponible;
}
public void setDisponible(boolean disponible) {
	this.disponible = disponible;
}
public Exemplaire() {
	super();
	// TODO Auto-generated constructor stub
}
public Exemplaire(String code, boolean disponible, Livre livre) {
	super();
	this.code = code;
	this.disponible = disponible;
	this.livre = livre;
	
}
  
  
  
}
