package Metier;

public class UserExistant extends Exception {
	private static final long serialVersionUID = 1L;

	public UserExistant(String msg) {
		super(msg);
	}
}
