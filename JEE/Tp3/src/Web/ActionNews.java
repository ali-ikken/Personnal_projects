package Web;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.ServiceDao;
import Metier.ServiceMetier;
import Metier.*;

public class ActionNews extends ActionSupport {
	//Attributes for User  : 
	private String error ;
	private String email ; 
    private String nomPrenom ; 
    private String motPasse ;

   private   ArrayList<News> listNews ;
   private  ArrayList<Reaction> listReactions ;
 

	// For News  : 
    private String url ; 
    private String titre ;
    private Date dateNews ;
    
    // For Reaction  : 
    private String urlNews ;
    private Date dateReaction  ;
    private String reaction  ; 
   
	
	public String getUrlNews() {
		return urlNews;
	}
	public void setUrlNews(String urlNews) {
		this.urlNews = urlNews;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

	public Date getDateReaction() {
		return dateReaction;
	}
	public void setDateReaction(Date dateReaction) {
		this.dateReaction = dateReaction;
	}
	public String getReaction() {
		return reaction;
	}
	public void setReaction(String reaction) {
		this.reaction = reaction;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDateNews() {
		return dateNews;
	}
	public void setDateNews(Date dateNews) {
		this.dateNews = dateNews;
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
    
   public String inscrire() throws Exception {
	   if(nomPrenom.equals("")) {
		   addFieldError("nomPrenom", "nomPrenom obligatoire !! ");
		   return INPUT ;
	   }
	   if(email.equals("")) {
		   addFieldError("email", "email obligatoire !! ");
		   return INPUT ;
	   } if(motPasse.equals("")) {
		   addFieldError("motPasse", "mot de Passe obligatoire !! ");
		   return INPUT ;
	   }
	   if(ServiceMetier.getUser(email)!=null){
		   addFieldError("email", "ce email exist deja !! ");
		   return INPUT ; 
	   }
	  User user = new User() ;
	  user.setEmail(email);
	  user.setMotPasse(motPasse);
	  user.setNomPrenom(nomPrenom);
	  ServiceMetier.addUser(user);
	  email=null ;
	  motPasse = null ;
	  return SUCCESS ;
	  
   }
   public String valideInscription() throws Exception {
	   if(email.equals("")) {
		   addFieldError("email", "nomPrenom obligatoire !! ");
		   return INPUT ;
	   }
	   if(motPasse.equals("")) {
		   addFieldError("motPasse", "mot de Passe obligatoire !! ");
		   return INPUT ;
	   }
	   User user = ServiceMetier.getUser(email , motPasse) ;
	   if(user!=null) {
		   ServletActionContext.getRequest().getSession().setAttribute("user", user);
			
			List<String>  urls=ServiceMetier.getAllUrl();
			ServletActionContext.getServletContext().setAttribute("urls", urls);
		   return SUCCESS ; 
	   }
	error = "email ou password incorrect !! " ; 
	return INPUT ;
	
   }
   public String def() {
	   return SUCCESS ;
   }
   public String validerReaction() throws Exception {
	   
	   Reaction rn = new Reaction() ;
	   try {
		   HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
	   rn.setUser((User)session.getAttribute("user"));
	   rn.setNews(ServiceMetier.getNewsByUrl(urlNews));
	   if(reaction.equals("like")) {
		   rn.setReaction(true);
	   }
	   else rn.setReaction(false);
	   ServiceMetier.addReactionDao(rn);
	   return SUCCESS ;
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	}
	   return INPUT ;
   }
   public String ajouternews() throws Exception {
	     if(url.equals("")) {
	    	 addFieldError("url", "Ajouter l'URL SVP ! ");
	    	 return INPUT ;
	     }
	     if(titre.equals("")) {
	    	 addFieldError("titre", "Ajouter le titre SVP ! ");
	    	 return INPUT ;
	     }
	     News nw = new News() ;
	     try {
	     HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
	   
	    nw.setCreateur((User)session.getAttribute("user"));
	    nw.setTitre(titre);
	    nw.setUrl(url);
	    if(ServiceMetier.addNewsDao(nw)) {
	    	List<String>  urls=ServiceMetier.getAllUrl();
    		ServletActionContext.getServletContext().setAttribute("urls", urls);
	    }
	    else session.setAttribute("error", "ce News exist deja");
	   return SUCCESS ;
	     }catch (Exception e) {
	    	 e.printStackTrace();
			// TODO: handle exception
		}
	     return INPUT ;
   }
   
   
   // for list of news 
   public ArrayList<News> getListNews() {
	return listNews;
}
public ArrayList<Reaction> getListReactions() {
	return listReactions;
}
public String getNews() {
	   listNews = ServiceMetier.getListNews() ;
	   return SUCCESS ;
   }
public String getReactions() throws Exception {
	listReactions = ServiceMetier.getListReactions() ;
	return SUCCESS ;
}
   
   
   public ActionNews() {
	super();
	// TODO Auto-generated constructor stub
} 
 	

}
