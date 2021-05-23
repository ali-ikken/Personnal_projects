package metier;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Personne implements Serializable{
	private static final long serialVersionUID = 1L;

	private long id ;
	private String nom;
	private String prenom;
	private Date dateNais;
	
	private Departement dept;
	
	public Personne(String nom, String prenom, Date dateNais, Departement dept) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
		this.dept = dept;
	}

	public Personne() {
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
	
   
	
	
	public Departement getDept() {
		return dept;
	}

	public void setDept(Departement dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNais=" + dateNais + "]";
	}
  
	
	
	
	
	

}
