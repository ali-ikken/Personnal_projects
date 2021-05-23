package metier;

import java.io.Serializable;
import java.math.BigDecimal;

public class CompteEpargne extends Compte implements Serializable {
	protected BigDecimal taux;
	CompteEpargne(){ super(); }
	public CompteEpargne(String numero, BigDecimal solde, BigDecimal taux) {
		super(numero, solde);
		this.taux = taux;
	}
	public CompteEpargne(Compte compte,BigDecimal taux) {
		super(compte.numero, compte.solde);
		this.taux = taux;  
	}
	public BigDecimal getTaux() {
		return taux;
	}
	public void setTaux(BigDecimal taux) {
		this.taux = taux;
	}
	@Override
	public String toString() {
		return "CompteEpargne [ id =" + id + ", numero=" + numero + ", solde=" + solde + "taux=" + taux + "]";
	}
	
	
}

