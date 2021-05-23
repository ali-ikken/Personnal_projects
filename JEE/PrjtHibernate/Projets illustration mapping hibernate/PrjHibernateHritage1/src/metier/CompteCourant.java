package metier;

import java.io.Serializable;
import java.math.BigDecimal;

public class CompteCourant extends Compte implements Serializable {
	protected int decouvert;
	CompteCourant(){ super(); }
	public CompteCourant(String numero, BigDecimal solde, int decouvert) {
		super(numero, solde);
		this.decouvert = decouvert;
	}
	public CompteCourant(Compte compte,int decouvert) {
		super(compte.numero, compte.solde);
		this.decouvert = decouvert;  
	}
	public int getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(int decouvert) {
		this.decouvert = decouvert;
	}
	@Override
	public String toString() {
		return "CompteCourant [ id=" + id + ", numero=" + numero + ", solde=" + solde + 
				", decouvert=" + decouvert + "]";
	}
	
	
	
	
 
}

