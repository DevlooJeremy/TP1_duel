package Exception;

public class AttackerHasSurrenderedException extends RuntimeException{
	private final static String ERROR_MESSAGE = "L'attaquant a capitulé";
	public AttackerHasSurrenderedException() {
		super(ERROR_MESSAGE);
	}
}
