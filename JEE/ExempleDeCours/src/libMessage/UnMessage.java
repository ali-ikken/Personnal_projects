
package libMessage;
import java.io .*; import java.text.*; import java.util.*;
public class UnMessage implements Serializable {
private static SimpleDateFormat formatter =
new SimpleDateFormat ("E d MMM yyyy , H:m:s", Locale.FRANCE);
private Date date = new Date (); private String email ; private String texte ;
public UnMessage () { date.setTime ( System.currentTimeMillis ()); }
public String getDate () { return formatter.format ( date ); }
public void setEmail ( String email ) { this . email = email ; }
public String getEmail () { return email ; }
public void setTexte ( String texte ) { this.texte = texte ; }
public String getTexte () { return texte ; }
}
