

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;
@WebServlet("/DataBaseServlet")
public class DataBaseServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
response.setContentType (" text/html"); PrintWriter out = response.getWriter ();
try {
Class.forName ("com.mysql.jdbc.Driver");
Connection ma_connexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","");
Statement mon_statement = (Statement) ma_connexion.createStatement ();
ResultSet mon_resultat = mon_statement.executeQuery (" SELECT ename ,Job , sal FROM emp");
while ( mon_resultat.next ()) {
out. print ("Nom : " + mon_resultat.getString (1));
out. print (" Fonction : " + mon_resultat.getString (2));
out. println (" Salaire : " + mon_resultat.getDouble(3));
out. println ("<br >");}
} catch (ClassNotFoundException e) {e.getMessage();}
catch ( SQLException e) {e.printStackTrace();} }
}
