package web;

import com.opensymphony.xwork2.ActionSupport;

public class ProduitAction extends ActionSupport {
    private String name ;
    private int tele ;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTele() {
		return tele;
	}

	public void setTele(int tele) {
		this.tele = tele;
	}

	public String enregistrer() {
		return SUCCESS ;
	}
}
