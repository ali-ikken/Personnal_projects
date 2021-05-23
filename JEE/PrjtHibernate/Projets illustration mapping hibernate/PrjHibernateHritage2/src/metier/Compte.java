package metier;

import java.io.Serializable;
import java.math.BigDecimal;

public class Compte   implements Serializable {
		protected int id;
		protected String numero;
		protected BigDecimal solde;
		Compte() { }
		
		public Compte(String numero, BigDecimal solde) {
			this.numero = numero;
			this.solde = solde;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
		public BigDecimal getSolde() {
			return solde;
		}
		public void setSolde(BigDecimal solde) {
			this.solde = solde;
		}

		@Override
		public String toString() {
			return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + "]";
		}
		
		
		

}
