package web;

import com.opensymphony.xwork2.ActionSupport;

public class ServiceAction extends ActionSupport {
  // login 
	private String email ; 
    private String motPasse ;
  
  
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMotPasse() {
	return motPasse;
}
public void setMotPasse(String motPasse) {
	this.motPasse = motPasse;
} 

  public String insc() {
	if(email.equals("")) {
		addFieldError("email", "email Obligatoire !! ");
		return INPUT ;
	}
	if(motPasse.equals("")) {
		addFieldError("motPasse", "saisir un mot de passe !! ");
		return INPUT ; 
	}
	if(email.equals("") && motPasse.equals("")) {
		addFieldError("email", "email Obligatoire");
		addFieldError("motPasse", "saisir un mot de passe !! ");
		return INPUT ;
	}
	return SUCCESS  ; 
	
}
  
}
