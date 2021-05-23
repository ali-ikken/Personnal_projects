package metier;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Reunion implements Serializable{
	private static final long serialVersionUID = 1L;

	private long idReunion;
	private Date dateReunion;
	private String titre;
	private Set<Personne> personnes=new HashSet<Personne>();
		
	public Reunion() {	}
	public Reunion(Date dateReunion, String titre) {
		this.dateReunion = dateReunion;	this.titre = titre;
	}
	public Long getIdReunion() {return idReunion;}
	public void setIdReunion(Long idReunion) {
		this.idReunion = idReunion;
	}
	public Date getDateReunion() {return dateReunion;}
	public void setDateReunion(Date dateReunion) {
		this.dateReunion = dateReunion;
	}
	public String getTitre() {	return titre;}
	public void setTitre(String titre) {this.titre = titre;	}
	
	public Set<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}
	public void addPersonne(Personne personne) {
		personnes.add(personne);
	}
	
	@Override
	public String toString() {
		return "Reunion [ idReunion=" + idReunion + ", titre=" + titre + "  ]";
	}
	
	
}
