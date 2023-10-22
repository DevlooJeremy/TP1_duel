package Fighter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exception.GiantIllegalAptitudeException;
import Tools.Aptitudes;
import duel.Giant;
import duel.Warrior;

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
	
	@Test
	void givenAGiantWhoLostAFight_whenPenalized_heLosesHP() {
		//Arrange
				Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
				Giant giant = new Giant(FighterTest.ANY_NAME,apt);
				
				
				//Act
				giant.penalize(-1, 50);
				int expectedHP = 200 - (ANY_LEGAL_STRENGHT + ANY_LEGAL_DEXTERITY + ANY_LEGAL_FOCUS +ANY_LEGAL_INTELLIGENCE + 50);
				
				//Assert
				assertEquals(expectedHP,giant.getHP());
	}
	
	@Test
	void givenAGiantWhoLostAFight_whenPenalizedFinalAttackWithMoreThenDamageCap_heDies() {
		//Arrange
				Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
				Giant giant = new Giant(FighterTest.ANY_NAME,apt);
				
				giant.penalize(-1, 112);
				//Act
				giant.penalize(-1, 11);
				int expectedHP = 0;
				
				//Assert
				assertEquals(expectedHP,giant.getHP());
	}
	
	@Test
	void givenAGiantWhoLostAFight_whenPenalizedFinalAttackWithLessThenDamageCap_heDoesNotTakeDamage() {
		//Arrange
				Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
				Giant giant = new Giant(FighterTest.ANY_NAME,apt);
				
				giant.penalize(-1, 112);
				//Act
				giant.penalize(-1, 10);
				int expectedHP = 200 - (ANY_LEGAL_STRENGHT + ANY_LEGAL_DEXTERITY + ANY_LEGAL_FOCUS + ANY_LEGAL_INTELLIGENCE + 112);
				
				//Assert
				assertEquals(expectedHP,giant.getHP());
	}

}
