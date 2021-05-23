package web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import dao.HibernateUtil;
import metier.Etudiant;
import metier.Exemplaire;
import metier.ServiceMetier;

public class ServiceAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Exemplaire> listExemplaires ;
	private static List<String> listcodes ;
	
	
	
	public  List<String> getListcodes() {
		return listcodes;
	}
	public ArrayList<Exemplaire> getListExemplaires() {
		return listExemplaires;
	}

	// for login  
	private String cne ; 
	private String motPasse ;
	// for inscription
	private String nom  ;
	private String prenom  ;
	
	//for Emprunt 
	private String codeE ;
	
	
	
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
	public String getCodeE() {
		return codeE;
	}
	public void setCodeE(String codeE) {
		this.codeE = codeE;
	}
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	public ServiceAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String validerInscription() {
		if(motPasse.equals("")) {
			addFieldError("motPasse", "mot de passe  obligatoire !! ");
			return INPUT ;
			
		}
		if(cne.equals("")) {
			addFieldError("cne", "cne  obligatoire !! ");
			return INPUT ;
			
		}
		if(nom.equals("")) {
			addFieldError("nom", "nom  obligatoire !! ");
			return INPUT ;
			
		}
		if(prenom.equals("")) {
			addFieldError("prenom", "prenom  obligatoire !! ");
			return INPUT ;
			
		}
		if(ServiceMetier.getEtudiant(cne, motPasse)!=null) {
			
			addFieldError("cne", "cne  exist deja !! ");
			return INPUT ;
			
		}
		Etudiant et = new Etudiant() ;
		et.setCne(cne);
		et.setMotPasse(motPasse);
		et.setNom(nom);
		et.setPrenom(prenom);
		ServiceMetier.addEtudiant(et);
		cne=null ;
		motPasse=null ;
		return SUCCESS ;
	}
	  
	public String validerLogin() {
		
			if(cne.equals("")) {
				addFieldError("cne", "cne obligatoire !! ");
				return INPUT ;
			}

			if(motPasse.equals("")) {
				addFieldError("motPasse", "mot de passe  obligatoire !! ");
				return INPUT ;
			}
			
		    Etudiant etudiant = ServiceMetier.getEtudiant(cne, motPasse) ;
			if(etudiant!=null) {
				ServletActionContext.getRequest().getSession().setAttribute("etud", etudiant);
			  listExemplaires=  (ArrayList<Exemplaire>) ServiceMetier.getExemplaireDispo() ;
				return SUCCESS ; 
			}
			return INPUT;
	}
	
	public String emprunter() {
      HttpSession session = ServletActionContext.getRequest().getSession() ;
      Etudiant e = (Etudiant) session.getAttribute("etud") ;
      listcodes = ServiceMetier.getCodeExemplaireDispo();
      if(ServiceMetier.addEmprunt( e.getId(), codeE)) return SUCCESS;
      return INPUT ;
      
	}
	public String getCodes() {
		    listcodes = ServiceMetier.getCodeExemplaireDispo();
	     
          return SUCCESS ;
	}
	public String getList() { 
		listExemplaires = (ArrayList<Exemplaire>) ServiceMetier.getExemplaireDispo() ;
		return SUCCESS ; 
	}
	

}
