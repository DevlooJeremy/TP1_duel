package Fighter;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import Exception.WizardIllegalAptitudeException;
import Tools.Aptitudes;
import duel.Warrior;
import duel.Wizard;

class WizardTest {

	private static final int ANY_STRENGHT = 15;
	private static final int ANY_DEXTERITY = 14;
	private static final int ANY_LEGAL_INTELLIGENCE = 30;
	private static final int ANY_LEGAL_FOCUS = 30;
	
	private static final int ANY_ILLEGAL_FOCUS = 29;
	private static final int ANY_ILLEGAL_INTELLIGENCE = 29;
	
	@Test
	void givenAWizardCreatedWithIllegalFocus_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_ILLEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
		
		assertThrows(WizardIllegalAptitudeException.class, ()-> {
			Wizard warrior = new Wizard(FighterTest.ANY_NAME,apt);
			
		});
	}
	
	@Test
	void givenAWizardCreatedWithIllegalIntelligence_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_LEGAL_FOCUS,ANY_ILLEGAL_INTELLIGENCE);
		
		assertThrows(WizardIllegalAptitudeException.class, ()-> {
			Wizard warrior = new Wizard(FighterTest.ANY_NAME,apt);
			
		});
	}

	@Test
	void givenAWizardCreatedWithLegalAptitude_whenCreated_noExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
			Wizard warrior = new Wizard(FighterTest.ANY_NAME,apt);
	}
	
	@Test
	void givenAWizardWhoLostAFight_whenPenalized_heLosesHalfDamageHasHP() {
		//Arrange
				Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
				Wizard wizard = new Wizard(FighterTest.ANY_NAME,apt);
				
				
				//Act
				wizard.penalize(-1, 50);
				int expectedHP = 200 - (ANY_STRENGHT + ANY_DEXTERITY + ANY_LEGAL_FOCUS +ANY_LEGAL_INTELLIGENCE + 50/2);
				
				//Assert
				assertEquals(expectedHP,wizard.getHP());
	}
}
