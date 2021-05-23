package jdbc;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Metier.Emp;

@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 
    protected void doPost(HttpServletRequest request, HttpServletResponse
    		response) throws ServletException, IOException { 
  
    	 int x = Integer.parseInt(request.getParameter("num" )) ;
    	 Emp emp = new Emp() ;
    	 request.setAttribute("emps", emp.getEmpByNodept(x));
    	 getServletContext().getRequestDispatcher("/Depart.jsp").forward(request, response);
    	 
    		
    }

}
    		
    



