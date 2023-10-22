package Exception;

public class NegativeHPException extends RuntimeException{
	private static final String ERROR_MESSAGE = "Les points de vie d'un combattant ne peuvent pas être en dessous de 0";

	public NegativeHPException() {
		super(ERROR_MESSAGE);
	}
}
