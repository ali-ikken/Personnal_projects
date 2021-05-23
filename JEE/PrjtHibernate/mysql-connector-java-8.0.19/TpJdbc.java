
package tpbd1;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TpJdbc {

	static Statement st;
	static Connection cn;
	static ResultSet rs;
	
	
	
	public static void main(String[] args) {
	 
            
            try {
                         Class.forName("com.mysql.jdbc.Driver");
                         cn =DriverManager.getConnection("jdbc:mysql://localhost:3306/magasin","root","root");
                         System.out.print("well conct");
                    
                        st.executeUpdate("update client set prenom ='Fouzia' WHERE idCli='A23' ");
			st.executeUpdate("update client set prenom ='Zineb' WHERE idCli='C34' ");
			st.executeUpdate("update client set prenom ='Mohamed' WHERE idCli='A34' ");
			rs= st.executeQuery("SELECT nom, prenom FROM client WHERE ville='Casablanca'");	
			System.out.println("Les clients habitent a casablanca  : ");
			while(rs.next()) {
				System.out.println(rs.getString(1) + " "+rs.getString(2));
			}
			// Q2
			rs= st.executeQuery("SELECT nom, prix  FROM  produit WHERE marque='IBM'");	
			System.out.println("les produits de la marque IBM :");
			while(rs.next()) {
				System.out.println(rs.getString(1) + " de prix :"+rs.getInt(2));
			}
			//Q3
			rs= st.executeQuery("select nom from produit where idpro in (select idpr from vente where dat between '2015/02/01' and '2015/02/30')");	
			System.out.println("les produits vendu en fevrier :");
			while(rs.next()) {
				System.out.println(rs.getString(1) );
			}
			//--------------
			rs =st.executeQuery("select sum(qte) from vente where idpr in (select idpro from produit where marque='IBM');");
			System.out.println("le nbres de ventes de la marque ibm  :");
			while(rs.next()) {
				System.out.println(rs.getString(1) );
			}
			//--------------
			System.out.println("le nbres de vente a casablanca par client est :");
			rs =st.executeQuery("select sum(qte) from vente where idcli in (select idcli from client where ville='Casablanca');");
			while(rs.next()) {
				System.out.println(rs.getString(1) );
			}
			//--------
			st.close();
			cn.close();
			
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TpJdbc.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(TpJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            }}
