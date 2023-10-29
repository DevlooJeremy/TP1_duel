package Fighter;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import Exception.WarriorIllegalAptitudeException;
import FighterMock.FighterStub;
import Skill.Skill;
import SkillMock.SkillDummy;
import Tools.Aptitudes;
import bag.Bag;
import bagMock.BagDummy;
import duel.Warrior;

class WarriorTest {
	
	private static final int ANY_LEGAL_STRENGHT = 31;
	private static final int ANY_LEGAL_DEXTERITY = 21;
	private static final int ANY_LEGAL_INTELLIGENCE = 11;
	private static final int ANY_FOCUS = 1;
	
	private static final int ANY_ILLEGAL_STRENGHT = 30;
	private static final int ANY_ILLEGAL_DEXTERITY = 20;
	private static final int ANY_ILLEGAL_INTELLIGENCE = 10;
	
	private static final int ANY_DAMAGE = 50;
	private static final int ANY_DAMAGE_TO_LOWER_UNDER_THRESHOLD_HP = 130;

	@Test
	void givenAWarriorCreatedWithIllegalStrenght_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_ILLEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_FOCUS,ANY_LEGAL_INTELLIGENCE);
		Bag bag = new BagDummy();
		
		assertThrows(WarriorIllegalAptitudeException.class, ()-> {
			Warrior warrior = new Warrior(FighterTest.ANY_NAME,apt,bag);
			
		});
	}
	
	@Test
	void givenAWarriorCreatedWithIllegalDexterity_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_ILLEGAL_DEXTERITY,ANY_FOCUS,ANY_LEGAL_INTELLIGENCE);
		Bag bag = new BagDummy();
		
		assertThrows(WarriorIllegalAptitudeException.class, ()-> {
			Warrior warrior = new Warrior(FighterTest.ANY_NAME,apt,bag);
			
		});
	}
	
	@Test
	void givenAWarriorCreatedWithIllegalIntelligence_whenCreated_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_FOCUS,ANY_ILLEGAL_INTELLIGENCE);
		Bag bag = new BagDummy();
		
		assertThrows(WarriorIllegalAptitudeException.class, ()-> {
			Warrior warrior = new Warrior(FighterTest.ANY_NAME,apt,bag);
			
		});
	}
	
	@Test
	void givenAWarriorCreatedWithLegalAptitudes_whenCreated_noExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_FOCUS,ANY_LEGAL_INTELLIGENCE);
		Bag bag = new BagDummy();
			Warrior warrior = new Warrior(FighterTest.ANY_NAME,apt,bag);
	}
	
	@Test
	void givenAWarriorWhoLostAFight_whenPenalized_heLosesHP() {
		//Arrange
				Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_FOCUS,ANY_LEGAL_INTELLIGENCE);
				Bag bag = new BagDummy();
				Warrior warrior = new Warrior(FighterTest.ANY_NAME,apt,bag);
				
				
				//Act
				warrior.penalize(FighterTest.LOSER_PENALITY, ANY_DAMAGE);
				int expectedHP = FighterTest.BASE_FIGHTER_HP - (ANY_LEGAL_STRENGHT + ANY_LEGAL_DEXTERITY + ANY_FOCUS +ANY_LEGAL_INTELLIGENCE + ANY_DAMAGE);
				
				//Assert
				assertEquals(expectedHP,warrior.getHP());
	}
	@Test
	void givenAWarriorWithBelowHPThreshold_whenPenalized_heGainsHPInstead() {
		//Arrange
				Aptitudes apt = new Aptitudes(ANY_LEGAL_STRENGHT,ANY_LEGAL_DEXTERITY,ANY_FOCUS,ANY_LEGAL_INTELLIGENCE);
				Bag bag = new BagDummy();
				Warrior warrior = new Warrior(FighterTest.ANY_NAME,apt,bag);
				
				warrior.penalize(FighterTest.LOSER_PENALITY, ANY_DAMAGE_TO_LOWER_UNDER_THRESHOLD_HP);
				//Act
				warrior.penalize(FighterTest.LOSER_PENALITY, ANY_DAMAGE);
				int expectedHP = FighterTest.BASE_FIGHTER_HP - (ANY_LEGAL_STRENGHT + ANY_LEGAL_DEXTERITY + ANY_FOCUS +ANY_LEGAL_INTELLIGENCE + ANY_DAMAGE_TO_LOWER_UNDER_THRESHOLD_HP - ANY_DAMAGE);
				
				//Assert
				assertEquals(expectedHP,warrior.getHP());
		
		//Act
		
		//Assert
	}

}
