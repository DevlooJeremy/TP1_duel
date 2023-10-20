package Exception;

public class AptitudesPointsUsedBelow0 extends RuntimeException{
	private static final String ERROR_MESSAGE = "Les points d'aptitudes attribués ne peuvent pas être en dessous de 0";
	
	public AptitudesPointsUsedBelow0() {
		super(ERROR_MESSAGE);
	}
}
