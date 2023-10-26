package Exception;

public class SwordIllegalImpactException extends RuntimeException{
	
	private static final String ERROR_MESSAGE = "La puissance d'impact de l'épée doit être entre 20 et 50";
	
	public SwordIllegalImpactException() {
		super(ERROR_MESSAGE);
	}

}
