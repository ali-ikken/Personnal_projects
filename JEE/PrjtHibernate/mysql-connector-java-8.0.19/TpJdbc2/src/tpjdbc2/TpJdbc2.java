
package tpjdbc2;
import java.sql.* ;
public class TpJdbc2 {
         static Connection cn ; 
         static  Statement st ; 
         static ResultSet rs ; 
    
    public static void main(String[] args) {
       
        try {
            Class.forName("com.mysql.jdbc.Driver") ; 
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/centre"  , "root" , "") ;
            st = cn.createStatement();
            
      //Q1. Ecrire un programme Java permettant de créer ces tables.  :
      
            st.executeUpdate("CREATE TABLE equipe ( id_eq varchar(10)"
                   +" primary key check(id_eq like 'loria%') ,nom_eq varchar(10),"
                   + " id_chef varchar(10))"); 
            st.executeUpdate("CREATE TABLE personne ( id_per varchar(10) "
                    + "primary key  ,"
                    + "nom_per varchar(10), prenom varchar(10) ," 
                    + "grade varchar(15) , id_eq varchar(10)  , "
                    + "FOREIGN KEY (id_eq) references equipe (id_eq))"); 
             st.executeUpdate("CREATE TABLE publication ( id_pub varchar(10) "
                    + "primary key  ,"
                    + "titre varchar(10), type varchar(10) )");
              st.executeUpdate("CREATE TABLE auteur ( id_au varchar(10) "
                    + "primary key  ,"
                    + "id_pub varchar(10), FOREIGN KEY (id_pub) references publication (id_pub))" ) ; 
              st.executeUpdate("ALTER TABLE personne " +
            "ADD CONSTRAINT gradecheck CHECK (grade =  'mc' or 'prof' or 'cr' or 'dr')") ;
                st.executeUpdate("ALTER TABLE publication " +
            "modify titre varchar(10) not null") ; 
                
    //Q2. Ecrire un programme Java permettant d’insérer des données dans ces tables
    
     for(int i=0 ;i<5 ; i++ ){
      st.executeUpdate("insert into equipe (id_eq, nom_eq,id_chef)"
              + "values ('lorial"+i+"', 'equipe"+i+"' ,'chef"+i+"')") ;
     } 
     for(int i=0 ;i<5 ; i++ ){
      st.executeUpdate("insert into personne (id_per, nom_per,prenom,grade, id_eq)"
              + "values ("+i+", 'personne"+i+"' ,'prenom"+i+"' , 'grade "+i+"' , 'lorial"+i+"')") ;
     }  
     for(int i=0 ;i<5 ; i++ ){
      st.executeUpdate("insert into publication (id_pub, titre,type)"
              + "values ('id"+i+"', 'titre"+i+"' ,'type"+i+"')") ;
     }
     for(int i=0 ;i<5 ; i++ ){
      st.executeUpdate("insert into auteur (id_au, id_pub)"
              + "values ('auteur"+i+"','id"+i+"')") ;
     } 
    
    //Q3. Ecrire un programme Java permettant d’afficher les infos concernant les équipes 
    
            rs = st.executeQuery("Select * from equipe ") ; 
            while(rs.next()){
                System.out.println("id_eq : " +rs.getString(1));
                System.out.println("name_eq : " + rs.getString(2));
                System.out.println("chef_eq : " + rs.getString(3)); 
                System.out.println("--------------------------");
            } 
        } catch (Exception e) {
            System.out.println("error :  " +e.getMessage());
        }
        
    }
    
}
