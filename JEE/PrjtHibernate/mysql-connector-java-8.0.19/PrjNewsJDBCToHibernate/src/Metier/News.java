package Metier;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;



public class News implements Serializable {
	
	private static final long serialVersionUID = -5316888178005877528L;
	
	private static SimpleDateFormat formatter = 
            new SimpleDateFormat ("dd-MM-yyyy", Locale.FRANCE);
	private static SimpleDateFormat formatter2 = 
            new SimpleDateFormat ("yyyy-MM-dd", Locale.FRANCE);
		
	private String url;
	private String titre;
	private Date dateInsertion;
	private User createur;
	
	
	public News() { dateInsertion =new Date();	}
	public String getUrl() {return url;	}
	public void setUrl(String url) {this.url = url;	}
	public String getTitre() {return titre;	}
	public void setTitre(String titre) {this.titre = titre;	}
	public Date getDateInsertion() {return dateInsertion;}
	public void setDateInsertion(Date dateNews) {this.dateInsertion = dateNews;}
	public String getDateInsertionString() {
		return (String) formatter.format (dateInsertion.getTime());
	}
	public String getDateInsertionString2() {
		return (String) formatter2.format (dateInsertion.getTime());
	}
	public User getCreateur() {	return createur;}
	public void setCreateur(User createur) { this.createur = createur;}
	@Override
	public String toString() {
		return "News [url=" + url + ", titre=" + titre + ", dateNews=" + getDateInsertionString() + ", createur=" + createur.getNomPrenom() + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		News other = (News) obj;
		if (url == null) {
			if (other.url != null) 	return false;
		} else if (!url.equals(other.url)) return false;
		return true;
	}

}
