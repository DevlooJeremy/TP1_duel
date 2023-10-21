package Fighter;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import Exception.WarriorIllegalAptitudeException;
import Tools.Aptitudes;
import duel.Warrior;

class WarriorTest {
	
	private static final int ANY_LEGAL_STRENGHT = 31;
	private static final int ANY_LEGAL_DEXTERITY = 21;
	private static final int ANY_LEGAL_INTELLIGENCE = 11;
	private static final int ANY_FOCUS = 1;
	
	private static final int ANY_ILLEGAL_STRENGHT = 30;
	private static final int ANY_ILLEGAL_DEXTERITY = 20;
	private static final int ANY_ILLEGAL_INTELLIGENCE = 10;

	@Test
	void givenAWarriorCreatedWithIllegalStrenght_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_ILLEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_FOCUS,ANY_LEGAL_INTELLIGENCE);
		
		assertThrows(WarriorIllegalAptitudeException.class, ()-> {
			Warrior warrior = new Warrior(FighterTest.ANY_NAME,apt);
			
		});
	}
	
	@Test
	void givenAWarriorCreatedWithIllegalDexterity_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_ILLEGAL_DEXTERITY,ANY_FOCUS,ANY_LEGAL_INTELLIGENCE);
		
		assertThrows(WarriorIllegalAptitudeException.class, ()-> {
			Warrior warrior = new Warrior(FighterTest.ANY_NAME,apt);
			
		});
	}
	
	@Test
	void givenAWarriorCreatedWithIllegalIntelligence_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_FOCUS,ANY_ILLEGAL_INTELLIGENCE);
		
		assertThrows(WarriorIllegalAptitudeException.class, ()-> {
			Warrior warrior = new Warrior(FighterTest.ANY_NAME,apt);
			
		});
	}
	
	@Test
	void givenAWarriorCreatedWithLegalAptitudes_whenCreated_noExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_FOCUS,ANY_LEGAL_INTELLIGENCE);
			Warrior warrior = new Warrior(FighterTest.ANY_NAME,apt);
	}

}
