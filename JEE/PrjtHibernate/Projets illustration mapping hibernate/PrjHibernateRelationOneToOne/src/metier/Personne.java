package metier;

import java.io.Serializable;
import java.util.Date;

public class Personne implements Serializable{
	private static final long serialVersionUID = 1L;

	private long id ;
	private String nom;
	private String prenom;
	private Date dateNais;
	private Adresse adresse;
	
	public Personne() {
	}
	
	

	public Personne(String nom, String prenom, Date dateNais, Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
		this.adresse = adresse;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public Date getDateNais() {
		return dateNais;
	}
	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}
	
   
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}



	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNais=" + dateNais + ", adresse="
				+ adresse.toString() + "]";
	}
  
	
	
	
	
	

}
