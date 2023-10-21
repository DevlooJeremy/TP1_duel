package Exception;

public class WizardIllegalAptitudeException extends RuntimeException{
	private static final String ERROR_MESSAGE = "Une des aptitudes du sorcier ne respecte pas les contraintes";
	
	public WizardIllegalAptitudeException() {
		super(ERROR_MESSAGE);
	}
}
