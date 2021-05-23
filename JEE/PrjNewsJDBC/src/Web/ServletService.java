package Web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Metier.*;
import Dao.*;


@WebServlet("/ServletService")
public class ServletService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (getServletContext().getAttribute("urls")==null) {
			getServletContext().setAttribute("urls",ServiceMetier.getAllUrl());
		}
		if (getServletContext().getAttribute("listNews")==null) {
			getServletContext().setAttribute("listNews",ServiceMetier.getListNews() );
		}
		if ( getServletContext().getAttribute("listReactions")== null ) {
			getServletContext().setAttribute("listReactions", ServiceMetier.getListReactions() );
		}
		
		request.getSession().setAttribute("user", null);
		getServletContext().getRequestDispatcher("/login.jsp").forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession();
	    String page= (String) session.getAttribute("page");
	    
	    User user;    
	    	    	
	    if (page.equals("inscription")) {
	    	
    	  	user= new User();
	    	user.setEmail(request.getParameter("email"));
	    	user.setNomPrenom(request.getParameter("nomPrenom"));
	    	user.setMotPasse(request.getParameter("motPasse"));
    	  	
	    	try {
				ServiceMetier.addUser(user);
			} catch (UserExistant e) {
				request.setAttribute("erreur", e.getMessage());
	    		getServletContext().getRequestDispatcher("/inscription.jsp").forward(request,  response);
			} catch (SQLException e) {
				request.setAttribute("erreur", "Pb Ajout : "+ e.getMessage());
	    		getServletContext().getRequestDispatcher("/inscription.jsp").forward(request,  response);
			}

	    	session.setAttribute("user", null);
			getServletContext().getRequestDispatcher("/login.jsp").forward(request,  response);
        }
	    else
	    	if (page.equals("login")) {
	    	
	    	String email=request.getParameter("email");
	    	String passWord=request.getParameter("motPasse");
	    		    	
	    	user=ServiceMetier.getUser(email, passWord);
	    	
	    	if (user!=null) {
	    		session.setAttribute("user",user );	    		
	    		getServletContext().getRequestDispatcher("/AjoutReaction.jsp").forward(request,  response);
	    	}
	    	else {
	    		request.setAttribute("erreur", "email ou mot de passe incorrect");
	    		getServletContext().getRequestDispatcher("/login.jsp").forward(request,  response);

	    	}
	    	
	    }
	    	
	    else
	   	    if (page.equals("AjoutReaction")) {
		   	    
	   	    	String action=request.getParameter("action");
		    	user=(User)session.getAttribute("user");
	    		
		    	if (action.equals("Valider")) {
		    		
		    		Reaction  reaction= new Reaction();
		    		reaction.setUser(user);
		    		reaction.setNews(ServiceMetier.getNewsByUrl(request.getParameter("listUrl")));
		    		
		    		if ( ((String) request.getParameter ("reaction")).equals("Jaime") ) 
		    			reaction.setReaction(true);
		    		else 
		    			reaction.setReaction(false);
		    		
		    		try {
			    		ServiceMetier.addReaction(reaction);
			    		//mise à jour de l'attribut  listReactionsws
						getServletContext().setAttribute("listReactions", ServiceMetier.getListReactions() );

					} catch (SQLException e) {
						request.setAttribute("erreur", "Pb Ajout : "+ e.getMessage());
					}
					
		    		getServletContext().getRequestDispatcher("/AjoutReaction.jsp").forward(request,  response);
		    	    	
		    	}
		    	else 
		    		if (action.equals("Ajout news")) {
		    			getServletContext().getRequestDispatcher("/AjoutNews.jsp").forward(request,  response);
		    		}
		    		if (action.equals("Affichage news")) {    			
		    			getServletContext().getRequestDispatcher("/AfficheNews.jsp").forward(request,  response);
		    		}
		    		if (action.equals("Affichage Reactions")) {    			
		    			getServletContext().getRequestDispatcher("/AfficheReactions.jsp").forward(request,  response);
		    		}
		    		
		    		
		    		
		
		}
	    
	    else 
	    	if (page.equals("AjoutNews")) {
	    		
	    		String action=request.getParameter("action");
		    	user=(User)session.getAttribute("user");
		    	    	
		    	if (action.equals("Valider")) {
		    		
		    	  	News news= new News();
			    	news.setCreateur(user);
			    	news.setUrl(request.getParameter("url"));
			    	news.setTitre(request.getParameter("titre"));
			    	
			    	try {
						ServiceMetier.addNews(news);
						//mise à jour des attributs URLs et listNews
						request.getServletContext().setAttribute("urls",ServiceMetier.getAllUrl() );
			    		request.getServletContext().setAttribute("listNews",ServiceMetier.getListNews() );
					} catch (NewsExistant e) {
			    		request.setAttribute("erreur", "News deja existante");
					}
			    	catch (SQLException  e) {
				    	request.setAttribute("erreur", "Pb Ajout : "+ e.getMessage());
					}
			    	getServletContext().getRequestDispatcher("/AjoutNews.jsp").forward(request,  response);
		    	}
		    	else 
		    		if (action.equals("Ajout reaction")) {
		    			getServletContext().getRequestDispatcher("/AjoutReaction.jsp").forward(request,  response);
		    		}
		    		if (action.equals("Affichage news")) {
		    			getServletContext().getRequestDispatcher("/AfficheNews.jsp").forward(request,  response);
		    		}
		

	    	}
	    
	    
	}
}
