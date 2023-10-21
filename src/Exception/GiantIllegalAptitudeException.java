package Exception;

public class GiantIllegalAptitudeException extends RuntimeException{
	
	private static final String ERROR_MESSAGE = "Une des aptitudes du géant ne respecte pas les contraintes";
	
	public GiantIllegalAptitudeException() {
		super(ERROR_MESSAGE);
	}
}
