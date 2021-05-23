package metier;


import java.io.Serializable;
import java.util.HashSet;

import java.util.Set;

public class Personne {
  
	protected Long id ; 
	protected String nom ; 
	protected String prenom ; 
	protected String motPasse ;
	
	protected Set<Exemplaire> exemplaires = new HashSet<Exemplaire>() ; 
		
	
	public Set<Exemplaire> getExemplaires() {
		return exemplaires;
	}
	public void setExemplaires(Set<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	public Personne() {
		super();
	}
	public Personne(String nom, String prenom, String motPasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.motPasse = motPasse;
	}
	
	
	
}
