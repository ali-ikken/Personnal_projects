package Metier;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	private String email;
	private String nomPrenom;
	private String motPasse;
	
	public User() {	}
	public String getEmail() {	return email;	}
	public void setEmail(String email) { this.email = email;}
	public String getNomPrenom() { 	return nomPrenom;}
	public void setNomPrenom(String nomPrenom) { this.nomPrenom = nomPrenom;}
	public String getMotPasse() { return motPasse; }
	public void setMotPasse(String motPasse) { 	this.motPasse = motPasse; }
    @Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null) return false;
		} else if (!email.equals(other.email)) return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", nomPrenom=" + nomPrenom + ", motPasse=" + motPasse + "]";
	}
}
