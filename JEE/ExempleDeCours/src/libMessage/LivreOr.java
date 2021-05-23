package libMessage ;
import java . util .*; import java .io .*;
public class LivreOr implements Serializable {
private ArrayList < UnMessage> messages ;
private String nomFichier ;
public LivreOr () { }
public String getFichier () { return this . nomFichier ; }
public void setFichier ( String fichier ) throws FileNotFoundException , IOException ,
ClassNotFoundException {
this . nomFichier = fichier ; FileInputStream fis ; ObjectInputStream ois = null ;
try { fis = new FileInputStream ( nomFichier ); ois = new ObjectInputStream ( fis);
messages = ( ArrayList <UnMessage> ) ois.readObject (); ois.close(); }
catch ( Exception e) { messages = new ArrayList <UnMessage> (); }
}
public ArrayList<UnMessage> getMessages () { return messages ;}
public void setMessages (ArrayList<UnMessage> messages){this.messages=messages;}
public void addMessage ( UnMessage msg ) { messages .add (msg ); }
public void enregistrer () throws FileNotFoundException , IOException {
FileOutputStream fos = new FileOutputStream ( nomFichier );
ObjectOutputStream oos = new ObjectOutputStream ( fos);
oos . writeObject ( messages ); oos.close(); }
}
