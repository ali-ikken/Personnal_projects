package Metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Emp {

	private String nom ; 
	private String fonction ; 
	private double sal ;
	private static ArrayList<Emp> emps = new ArrayList<Emp>() ;
	public Emp() {
		emps.add(this) ;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public static ArrayList<Emp> getEmps() {
		return emps;
	}
	public static void setEmps(ArrayList<Emp> emps) {
		Emp.emps = emps;
	}
	public ArrayList<Emp> getEmpByNodept(int dept) {
		
  		try {
    		Class.forName ("com.mysql.jdbc.Driver");
    		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","");
			PreparedStatement ps = connection.prepareStatement(" SELECT ename ,Job , sal FROM emp where deptno = ? ;");
    		ps.setInt(1, dept);
    		 
            ResultSet rs = ps. executeQuery();  		
    		while ( rs.next ()) {
    		
    			Emp emp = new Emp() ;
			emp.setNom(rs.getString("ename")) ;
    		emp.setFonction(rs.getString("job"));
    		emp.setSal(rs.getDouble("sal"));
    		emps.add(emp) ; 
    		} 
    		connection.close();
    	
    		}
    		catch (ClassNotFoundException e) {e.getMessage();}
    		catch ( SQLException e) {e.printStackTrace();} 
  		return emps ; 
	   
	} 
	
	
}
