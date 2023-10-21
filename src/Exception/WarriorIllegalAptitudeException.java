package Exception;

public class WarriorIllegalAptitudeException extends RuntimeException{
	private static final String ERROR_MESSAGE = "Une des aptitudes du guerriers ne respecte pas les contraintes";
	
	public WarriorIllegalAptitudeException() {
		super(ERROR_MESSAGE);
	}

}
