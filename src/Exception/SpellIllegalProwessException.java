package Exception;

public class SpellIllegalProwessException extends RuntimeException{
	
	private static final String ERROR_MESSAGE = "La puissance magique d'un sortilège doit être entre 20 et 50";
	
	public SpellIllegalProwessException() {
		super(ERROR_MESSAGE);
	}

}
