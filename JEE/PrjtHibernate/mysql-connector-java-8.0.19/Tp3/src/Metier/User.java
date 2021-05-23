package Metier;

import java.io.Serializable;
import java.sql.SQLException;

public class User implements Serializable{
  
	private static final long serialVersionUID = 1L;
	private String email ; 
    private String nomPrenom ; 
    private String motPasse ;
	public User() throws SQLException {
		ServiceMetier.getListUsers().add(this) ;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomPrenom() {
		return nomPrenom;
	}
	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	} 
    public boolean equals(User user) throws SQLException {
    	for(User ur : ServiceMetier.getListUsers()) {
    		if(ur.getEmail().equals(user.getEmail())) return true ; 
    	}
    	return false ; 
    }
    public static User getUser(String email) throws SQLException {
  	  for(User user : ServiceMetier.getListUsers()) 
  	  {
  		  if(user.getEmail().equals(email))
  			  return user ; 
  	  }
  	  return null ;
    } 
   
}
