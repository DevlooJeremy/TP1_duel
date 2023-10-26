package Exception;

public class ShieldIllegalProtectionException extends RuntimeException{
	
	private static final String ERROR_MESSAGE = "La protection du bouclier doit être entre 20 et 50";
	
	public ShieldIllegalProtectionException() {
		super(ERROR_MESSAGE);
	}

}
