package Web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Metier.Message;
import Metier.User;





@WebServlet("/ServletOperation")
public class ServletOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("user", null);
		getServletContext().getRequestDispatcher("/login.jsp").forward(request,  response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session= request.getSession();  
	    String page= (String) session.getAttribute("page");
	    User user;    
	     
	    if (page.equals("inscription")) {
	    	String email=request.getParameter("email");
	    	if (User.getUser(email)==null) {
		    	user= new User();
		    	user.setEmail(email);
		    	user.setNomPr(request.getParameter("nomPr"));
		    	user.setPassword(request.getParameter("password"));
		    	user.setStatut(request.getParameter("statut"));
		    	doGet(request,response);
	    	}
	    	else {
	    		request.setAttribute("erreur", "email deja existant");
	    		getServletContext().getRequestDispatcher("/inscription.jsp").forward(request,  response);
	    	}
	    }
	    else 
	    if (page.equals("login")) {
	    	
	    	String email=request.getParameter("email");
	    	String passWord=request.getParameter("password");
	    	user=User.getUser(email, passWord);
	    	if (user!=null) {
	    		session.setAttribute("user",user );
	    		getServletContext().getRequestDispatcher("/ajoutMessage.jsp").forward(request,  response);
	    	}
	    	else {
	    		request.setAttribute("erreur", "email ou mot de passe incorrect");
	    		doGet(request,response);
	    	}
	    	
	    }
	    else 
		    if (page.equals("ajoutMessage")) {
		    	
		    	String action= (String) request.getParameter("action") ;
		    	user=(User)session.getAttribute("user");
		    	    	
		    	if (action.equals("envoi")) {
		        			
		    		Message message=new Message();
		    		message.setUser(user);
		    		message.setMessage(request.getParameter("message"));
		    		getServletContext().getRequestDispatcher("/ajoutMessage.jsp").forward(request,  response);

		    	}
		    	else 
		    		if (action.equals("visualiser")){
		    		session.setAttribute("messages",Message.getMessageByUser(user));
		    		getServletContext().getRequestDispatcher("/visualisation.jsp").forward(request,  response);
		    			
		    		}
		
		    }
	    
	    
	}

}