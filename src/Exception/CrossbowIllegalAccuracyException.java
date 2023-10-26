package Exception;

public class CrossbowIllegalAccuracyException extends RuntimeException{
	
	private static final String ERROR_MESSAGE = "La précision de l'arbalètte doit être entre 20 et 50";
	
	public CrossbowIllegalAccuracyException() {
		super(ERROR_MESSAGE);
	}

}
