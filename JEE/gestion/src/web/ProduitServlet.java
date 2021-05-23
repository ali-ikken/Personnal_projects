package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Metier.Produits;

@WebServlet("/ProduitServlet")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	  ArrayList<Produits> ps = new ArrayList<Produits>();
   	  Produits p = new Produits() ; 
	  p.setNom(request.getParameter("nom"));
	  p.setDesc(request.getParameter("desc"));
	  p.setEtat(request.getParameter("etat"));
	  p.setPrix(Long.parseLong(request.getParameter("prix")));
	  request.setAttribute("listP", Produits.getProduits());
	  getServletContext().getRequestDispatcher("/Produit.jsp").forward(request, response);
	}

}
