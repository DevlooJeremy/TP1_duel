package Fighter;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import Exception.WizardIllegalAptitudeException;
import Skill.Skill;
import SkillMock.SkillDummy;
import Tools.Aptitudes;
import bag.Bag;
import bagMock.BagDummy;
import duel.Warrior;
import duel.Wizard;

class WizardTest {

	private static final int ANY_STRENGHT = 15;
	private static final int ANY_DEXTERITY = 14;
	private static final int ANY_LEGAL_INTELLIGENCE = 30;
	private static final int ANY_LEGAL_FOCUS = 30;
	
	private static final int ANY_ILLEGAL_FOCUS = 29;
	private static final int ANY_ILLEGAL_INTELLIGENCE = 29;
	
	private static final int ANY_DAMAGE = 50;
	
	@Test
	void givenAWizardCreatedWithIllegalFocus_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_ILLEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
		Skill firstSkill = new SkillDummy();
		Skill secondSkill = new SkillDummy();
		Bag bag = new BagDummy(firstSkill,secondSkill);
		
		assertThrows(WizardIllegalAptitudeException.class, ()-> {
			Wizard warrior = new Wizard(FighterTest.ANY_NAME,apt,bag);
			
		});
	}
	
	@Test
	void givenAWizardCreatedWithIllegalIntelligence_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_LEGAL_FOCUS,ANY_ILLEGAL_INTELLIGENCE);
		Skill firstSkill = new SkillDummy();
		Skill secondSkill = new SkillDummy();
		Bag bag = new BagDummy(firstSkill,secondSkill);
		
		assertThrows(WizardIllegalAptitudeException.class, ()-> {
			Wizard warrior = new Wizard(FighterTest.ANY_NAME,apt,bag);
			
		});
	}

	@Test
	void givenAWizardCreatedWithLegalAptitude_whenCreated_noExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
		Skill firstSkill = new SkillDummy();
		Skill secondSkill = new SkillDummy();
		Bag bag = new BagDummy(firstSkill,secondSkill);
			Wizard warrior = new Wizard(FighterTest.ANY_NAME,apt,bag);
	}
	
	@Test
	void givenAWizardWhoLostAFight_whenPenalized_heLosesHalfDamageHasHP() {
		//Arrange
				Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_LEGAL_FOCUS,ANY_LEGAL_INTELLIGENCE);
				Skill firstSkill = new SkillDummy();
				Skill secondSkill = new SkillDummy();
				Bag bag = new BagDummy(firstSkill,secondSkill);
				Wizard wizard = new Wizard(FighterTest.ANY_NAME,apt,bag);
				
				
				//Act
				wizard.penalize(FighterTest.LOSER_PENALITY, ANY_DAMAGE);
				int expectedHP = FighterTest.BASE_FIGHTER_HP - (ANY_STRENGHT + ANY_DEXTERITY + ANY_LEGAL_FOCUS +ANY_LEGAL_INTELLIGENCE + ANY_DAMAGE/2);
				
				//Assert
				assertEquals(expectedHP,wizard.getHP());
	}
}
