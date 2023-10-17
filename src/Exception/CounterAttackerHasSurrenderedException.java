package Exception;

public class CounterAttackerHasSurrenderedException extends RuntimeException{
	private final static String ERROR_MESSAGE = "Le contre-attaquant a capitulé";
	public CounterAttackerHasSurrenderedException() {
		super(ERROR_MESSAGE);
	}
}
