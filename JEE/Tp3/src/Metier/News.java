package Metier;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

 public class News implements Serializable {
 
		private static SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE) ;
		private static SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE) ;
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 private String url ; 
 private String titre ;
 private Date dateNews ;
 private User createur ;
 private int nbrLikes , nbrDislikes ;
 private  Set<Reaction> reactions = new HashSet<Reaction>() ;
 
 




public int getNbrLikes() {
	nbrLikes = 0 ; 
	for(Reaction rt : reactions) {
		if(rt.getReaction()) nbrLikes ++ ;
	}
	
	return nbrLikes;
}

public void setNbrLikes(int nbrLikes) {
	this.nbrLikes = nbrLikes;
}

public int getNbrDislikes() {
	nbrDislikes = 0 ; 
	for(Reaction rt : reactions) {
		if(!rt.getReaction()) nbrDislikes ++ ;
	}
	return nbrDislikes;
}

public void setNbrDislikes(int nbrDislikes) {
	this.nbrDislikes = nbrDislikes;
}

public Set<Reaction> getReactions() {
	return reactions;
}

public void setReactions(Set<Reaction> reactions) {
	this.reactions = reactions;
}



public News() throws SQLException {
	dateNews = new Date() ;
	
}



public Date getDateNews() {
	return dateNews;
}

public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}

public String getDateFormatter1() {
	return (String)formatter1.format(dateNews.getTime());
}


public String  getDateFormatter2() {
	return (String)formatter2.format(dateNews.getTime());
}
public void setDateNews(Date dateNews) {
	this.dateNews = dateNews;
}
public User getCreateur() {
	return createur;
}
public void setCreateur(User createur) {
	this.createur = createur;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
} 
 
 
}
