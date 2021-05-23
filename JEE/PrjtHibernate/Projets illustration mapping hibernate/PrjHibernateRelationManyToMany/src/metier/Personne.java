package metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import metier.Reunion;

public class Personne implements Serializable{
	private static final long serialVersionUID = 1L;

	private long IdPersonne ;
	private String nom;
	private String prenom;
	private Date dateNais;
	
	private Set<Reunion> reunions=new HashSet<Reunion>();
	
	public Personne() {
	}
	public Personne(String nom, String prenom, Date dateNais) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
		
	}
	
	public long getIdPersonne() {
		return IdPersonne;
	}
	public void setIdPersonne(long idPersonne) {
		IdPersonne = idPersonne;
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
	public Date getDateNais() {
		return dateNais;
	}
	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}
   
	public Set<Reunion> getReunions() {
		return reunions;
	}
	public void setReunions(Set<Reunion> reunions) {
		this.reunions = reunions;
	}
	public void addReunion(Reunion reunion) {
		reunions.add(reunion);
	}
	
	@Override
	public String toString() {
		return "Personne [IdPersonne=" + IdPersonne + ", nom=" + nom + ", prenom=" + prenom + ", dateNais=" + dateNais + " ]";
	}
  
	
	
	
	
	

}
