package Metier;

import java.util.ArrayList;

public class Produits {
   private String nom ; 
   private String desc ; 
   private String etat ; 
   private long prix ;
   private static ArrayList<Produits> produits = new ArrayList<Produits>() ; 
public Produits() {
	produits.add(this) ; 
}

public static ArrayList<Produits> getProduits() {
	return produits;
}
 public static void AddProduit(Produits p ) {
	 produits.add(p) ;
 }
public static void setProduits(ArrayList<Produits> produits) {
	Produits.produits = produits;
}

public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
public double getPrix() {
	return prix;
}
public void setPrix(long prix) {
	this.prix = prix;
} 
   
}
