package Web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Metier.*;
@WebServlet("/ServletService")
public class ServletService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  
    public ServletService() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.getSession().setAttribute("user", null);
	   getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession() ; 
		String page = (String)session.getAttribute("page") ;
		User user ;
		 ArrayList<String> urls  = ServiceMetier.getAllUrl() ;
		 session.setAttribute("urls", urls);
		    ArrayList<Reaction> reactions;
			try {
				reactions = ServiceMetier.getListReactions();
				session.setAttribute("reactions", reactions);
				ArrayList<News> nwss = ServiceMetier.getListNews();
				session.setAttribute("nwss", nwss);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		if(page=="inscription") {
			String email = request.getParameter("email") ; 
			user = ServiceMetier.getUser(email) ;
			if(user==null) {
			 
			try {
				user = new User() ;
				user.setEmail(email);
				user.setMotPasse(request.getParameter("password")) ; 
				user.setNomPrenom(request.getParameter("nomPr"));
				ServiceMetier.addUser(user);
				session.setAttribute("user", user);
				doGet(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
			else {
				request.setAttribute("erreur", "email deja existant !");
				getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
			 }
		}
		else if(page.equals("login")) {
		   String email = request.getParameter("email") ; 
		   String motPasse = request.getParameter("password") ; 
		   user = ServiceMetier.getUser(email, motPasse) ;
		   if (user !=null) {
			 session.setAttribute("user", user);
		
			getServletContext().getRequestDispatcher("/ajoutReaction.jsp").forward(request, response);

			   
			   
		   }else {
			   request.setAttribute("erreur", "email ou password incorrect !! ");
			   doGet(request, response);
			   
		   }
		   
		}

		else if(page.equals("ajoutReaction")) {
			user = (User)session.getAttribute("user");
			String action = request.getParameter("action") ;
			if(action.equals("Valider")) {
				
				try {
			     	Reaction reaction = new Reaction();
					reaction.setUser(user);
					reaction.setNews(ServiceMetier.getNewsByUrl(request.getParameter("url")));
					if(((String)request.getParameter("reaction")).equals("j'aime")) {
						reaction.setReaction(true);
					}
					else {reaction.setReaction(false);}
					ServiceMetier.addReactionDao(reaction);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				getServletContext().getRequestDispatcher("/ajoutReaction.jsp").forward(request, response); 
			}
			else if(action.equals("AjoutNews")) {

				getServletContext().getRequestDispatcher("/AjoutNew.jsp").forward(request, response);
				
			}
			else if(action.equals("Affichage Reaction")) {
				
					getServletContext().getRequestDispatcher("/AfficheReactions.jsp").forward(request, response);
				
	
           }
			
		}
		else if (page.equals("AjoutNews")) {
			String url = request.getParameter("url");
			if(ServiceMetier.getNews(url)==null) {
			try {

				News nw = new News() ;
				nw.setCreateur((User)session.getAttribute("user"));
				nw.setTitre(request.getParameter("titre"));
				nw.setUrl(url);
				ServiceMetier.addNewsDao(nw);
				getServletContext().getRequestDispatcher("/AjoutNew.jsp").forward(request, response) ;
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} }
			else {
				request.setAttribute("err", "news deja exist !!") ;
				getServletContext().getRequestDispatcher("/AjoutNew.jsp").forward(request, response) ;
			}
			
		}
	}

}
