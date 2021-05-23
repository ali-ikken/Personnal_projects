package Dao;
import java.sql.*;
public class Connexion {
	private static Connection cn ;

	 static {
	 try {
		  Class.forName("com.mysql.jdbc.Driver"); 
		  cn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bdnews" , "root" ,"") ;
		  System.out.println("seccussful connection !");
	} catch (Exception e) {
		System.out.println("eroor : " +e.getMessage());
	} }
	 public static Connection getConnection() {
		 return cn ;
	 }
 
}
