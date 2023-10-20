package Exception;

public class AptitudesPointsUsedAbove100 extends RuntimeException{
	private static final String ERROR_MESSAGE = "Le total des points d'aptitudes ne peut pas dépasser 100";
	
	public AptitudesPointsUsedAbove100() {
		super(ERROR_MESSAGE);
	}
}
