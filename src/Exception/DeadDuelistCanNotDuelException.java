package Exception;

public class DeadDuelistCanNotDuelException extends RuntimeException{
	
	private static final String ERROR_MESSAGE = "Un duel ne peut pas se lancer si les deux duelistes ne sont pas en vies";
	
	public DeadDuelistCanNotDuelException() {
		super(ERROR_MESSAGE);
	}
}
