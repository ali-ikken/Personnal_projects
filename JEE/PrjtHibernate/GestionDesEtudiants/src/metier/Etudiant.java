
package metier;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etudiant_table")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Etudiant")
    private Integer id ; 
    @Column(name = "nom_etudiant")
    private String nom ; 
    @Column(name = "prenom_etudiant")
    private String prenom ; 
    @Column(name = "etablissement_etudiant")
    private String etablissement ; 

    public Etudiant(String nom, String prenom, String etablissement) {
       
        this.nom = nom;
        this.prenom = prenom;
        this.etablissement = etablissement;
    }

    public Etudiant() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", etablissement=" + etablissement + '}';
    }
    
    
    
    
}
