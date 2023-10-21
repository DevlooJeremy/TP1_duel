package Fighter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exception.GiantIllegalAptitudeException;
import Tools.Aptitudes;
import duel.Giant;

class GiantTest {
	private static final int ANY_LEGAL_STRENGHT = 21;
	private static final int ANY_LEGAL_DEXTERITY = 21;
	private static final int ANY_LEGAL_FOCUS = 21;
	private static final int ANY_LEGAL_INTELLIGENCE = 21;
	
	private static final int ANY_ILLEGAL_STRENGHT = 19;
	private static final int ANY_ILLEGAL_DEXTERITY = 19;
	private static final int ANY_ILLEGAL_FOCUS = 19;
	private static final int ANY_ILLEGAL_INTELLIGENCE = 19;
	

	@Test
	void givenAGiantCreatedWithIllegalStrenght_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_ILLEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
		
		assertThrows(GiantIllegalAptitudeException.class, ()-> {
			Giant giant = new Giant(FighterTest.ANY_NAME,apt);
		});
	}
	
	@Test
	void givenAGiantCreatedWithIllegalDexterity_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_ILLEGAL_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
		
		assertThrows(GiantIllegalAptitudeException.class, ()-> {
			Giant giant = new Giant(FighterTest.ANY_NAME,apt);
		});
	}
	
	@Test
	void givenAGiantCreatedWithIllegalFocus_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_ILLEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
		
		assertThrows(GiantIllegalAptitudeException.class, ()-> {
			Giant giant = new Giant(FighterTest.ANY_NAME,apt);
		});
	}
	
	@Test
	void givenAGiantCreatedWithIllegalIntelligence_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_LEGAL_FOCUS,ANY_ILLEGAL_INTELLIGENCE);
		
		assertThrows(GiantIllegalAptitudeException.class, ()-> {
			Giant giant = new Giant(FighterTest.ANY_NAME,apt);
		});
	}
	
	@Test
	void givenAGiantCreatedWithLegalAptitudes_whenCreated_noExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
			Giant giant = new Giant(FighterTest.ANY_NAME,apt);
	}

}
