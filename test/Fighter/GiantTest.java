package Fighter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exception.GiantIllegalAptitudeException;
import Tools.Aptitudes;
import bag.Bag;
import bagMock.BagDummy;
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
	
	private static final int ANY_DAMAGE = 50;
	private static final int ANY_DAMAGE_TO_LOWER_TO_HP_THRESHOLD = 112;
	private static final int ANY_NON_EFFECTIVE_DAMAGE = 10;
	private static final int ANY_EFFECTIVE_DAMAGE = 11;
	

	@Test
	void givenAGiantCreatedWithIllegalStrenght_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_ILLEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
		Bag bag = new BagDummy();
		
		assertThrows(GiantIllegalAptitudeException.class, ()-> {
			Giant giant = new Giant(FighterTest.ANY_NAME,apt,bag);
		});
	}
	
	@Test
	void givenAGiantCreatedWithIllegalDexterity_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_ILLEGAL_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
		Bag bag = new BagDummy();
		
		assertThrows(GiantIllegalAptitudeException.class, ()-> {
			Giant giant = new Giant(FighterTest.ANY_NAME,apt,bag);
		});
	}
	
	@Test
	void givenAGiantCreatedWithIllegalFocus_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_ILLEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
		Bag bag = new BagDummy();
		
		assertThrows(GiantIllegalAptitudeException.class, ()-> {
			Giant giant = new Giant(FighterTest.ANY_NAME,apt,bag);
		});
	}
	
	@Test
	void givenAGiantCreatedWithIllegalIntelligence_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_LEGAL_FOCUS,ANY_ILLEGAL_INTELLIGENCE);
		Bag bag = new BagDummy();
		
		assertThrows(GiantIllegalAptitudeException.class, ()-> {
			Giant giant = new Giant(FighterTest.ANY_NAME,apt,bag);
		});
	}
	
	@Test
	void givenAGiantCreatedWithLegalAptitudes_whenCreated_noExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
		Bag bag = new BagDummy();
			Giant giant = new Giant(FighterTest.ANY_NAME,apt,bag);
	}
	
	@Test
	void givenAGiantWhoLostAFight_whenPenalized_heLosesHP() {
		//Arrange
				Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
				Bag bag = new BagDummy();
				Giant giant = new Giant(FighterTest.ANY_NAME,apt,bag);
				
				
				//Act
				giant.penalize(FighterTest.LOSER_PENALITY,ANY_DAMAGE);
				int expectedHP = FighterTest.BASE_FIGHTER_HP - (ANY_LEGAL_STRENGHT + ANY_LEGAL_DEXTERITY + ANY_LEGAL_FOCUS +ANY_LEGAL_INTELLIGENCE + ANY_DAMAGE);
				
				//Assert
				assertEquals(expectedHP,giant.getHP());
	}
	
	@Test
	void givenAGiantWhoLostAFight_whenPenalizedFinalAttackWithMoreThenDamageCap_heDies() {
		//Arrange
				Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
				Bag bag = new BagDummy();
				Giant giant = new Giant(FighterTest.ANY_NAME,apt,bag);
				
				giant.penalize(FighterTest.LOSER_PENALITY, ANY_DAMAGE_TO_LOWER_TO_HP_THRESHOLD);
				//Act
				giant.penalize(FighterTest.LOSER_PENALITY, ANY_EFFECTIVE_DAMAGE);
				int expectedHP = 0;
				
				//Assert
				assertEquals(expectedHP,giant.getHP());
	}
	
	@Test
	void givenAGiantWhoLostAFight_whenPenalizedFinalAttackWithLessThenDamageCap_heDoesNotTakeDamage() {
		//Arrange
				Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
				Bag bag = new BagDummy();
				Giant giant = new Giant(FighterTest.ANY_NAME,apt,bag);
				
				giant.penalize(FighterTest.LOSER_PENALITY, ANY_DAMAGE_TO_LOWER_TO_HP_THRESHOLD);
				//Act
				giant.penalize(FighterTest.LOSER_PENALITY, ANY_NON_EFFECTIVE_DAMAGE);
				int expectedHP = FighterTest.BASE_FIGHTER_HP - (ANY_LEGAL_STRENGHT + ANY_LEGAL_DEXTERITY + ANY_LEGAL_FOCUS + ANY_LEGAL_INTELLIGENCE + ANY_DAMAGE_TO_LOWER_TO_HP_THRESHOLD);
				
				//Assert
				assertEquals(expectedHP,giant.getHP());
	}

}
