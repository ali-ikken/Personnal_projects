package Metier;

import java.util.ArrayList;

public class User {
	private String email ; 
	private String nomPr ; 
	private String password ; 
	private boolean statut = true ; 
	private static ArrayList<User> users 
	                    = new ArrayList<User>() ;
	public User() {
		users.add(this) ; 
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomPr() {
		return nomPr;
	}
	public void setNomPr(String nomPr) {
		this.nomPr = nomPr;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public static ArrayList<User> getUsers() {
		return users;
	}
	public static void setUsers(ArrayList<User> users) {
		User.users = users;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", nomPr=" + nomPr + ", password=" + password + ", statut=" + statut + "]";
	}
	public void setStatut(String statut) {
		if (statut.equals("Etudiant"))
		this.statut = false;
		else this.statut = true ; 
	}
	
    
    public boolean estProf(){ return statut ; }
    public boolean estEtudiant(){ return !statut ; }
    public static User getUser(String email , String password) {
    	for(User user : users)  {
    		if(user.getEmail().equals(email) && user.getPassword().equals(password))
    			return user;
    	}
		return null;  		
    	}
    public static User getUser(String email ) {
    	for(User user : users)  {
    		if(user.getEmail().equals(email))
    			return user;
    	}
		return null;  		
    	}
    public boolean equals(User user) {
    	for (User usr : users) {
    		if (user.getEmail().equals(usr.getEmail())) {
    			return true ;
    		}
			
		}
    	return false ;
    	
    	
    }
}
