package Fighter;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exception.AptitudesPointsUsedAbove100;
import Exception.AptitudesPointsUsedBelow0;
import Exception.NegativeHPException;
import FighterMock.FighterStub;
import Skill.Skill;
import SkillMock.SkillDummy;
import Tools.Aptitudes;
import bag.Bag;
import bagMock.BagDummy;
import duel.Fighter;

class FighterTest {
	private static final int ANY_INTELLIGENCE = 20; 
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_STRENGHT = 20;
	private static final int ANY_FOCUS = 20;
	private static final int TOO_HIGH_STRENGHT = 100;
	private static final int ANY_DAMAGE_DEALT = 100;
	
	public static final String ANY_NAME = "Jean";
	public static final int BASE_FIGHTER_HP = 200;
	public static final int LOSER_PENALITY = -1;

	@Test
	void givenAFighter_whenCreatedWithMoreThenAHundredPoints_thenExceptionIsCalled() {
		Aptitudes apt = new Aptitudes(TOO_HIGH_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		Skill firstSkill = new SkillDummy();
		Skill secondSkill = new SkillDummy();
		Bag bag = new BagDummy(firstSkill,secondSkill);
		
		assertThrows(AptitudesPointsUsedAbove100.class,()-> {
			Fighter fighter = new FighterStub(ANY_NAME,apt,bag);
		});
	}
	
	@Test
	void givenAFighter_whenCreated_fighterShouldSetAllHisAttributes() {
		//Arrange
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		Skill firstSkill = new SkillDummy();
		Skill secondSkill = new SkillDummy();
		Bag bag = new BagDummy(firstSkill,secondSkill);
		//Act
		FighterStub fighter = new FighterStub(ANY_NAME,apt,bag);
		int expectedHP = BASE_FIGHTER_HP - (ANY_STRENGHT + ANY_DEXTERITY + ANY_FOCUS +ANY_INTELLIGENCE);
		//Assert
		assertEquals(expectedHP,fighter.getHP());
		assertEquals(ANY_NAME,fighter.getName());
		assertEquals(ANY_STRENGHT,fighter.getStrenght());
		assertEquals(ANY_DEXTERITY,fighter.getDexterity());
		assertEquals(ANY_FOCUS,fighter.getFocus());
		assertEquals(ANY_INTELLIGENCE,fighter.getIntelligence());
	}
	
	@Test 
	void givenAFighterWhoLostAFight_whenPenalized_heLosesTheGoodAmountOfHP() {
		//Arrange
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		Skill firstSkill = new SkillDummy();
		Skill secondSkill = new SkillDummy();
		Bag bag = new BagDummy(firstSkill,secondSkill);
		FighterStub fighter = new FighterStub(ANY_NAME,apt,bag);
		
		
		//Act
		fighter.penalize(LOSER_PENALITY, ANY_DAMAGE_DEALT);
		int expectedHP = BASE_FIGHTER_HP - (ANY_STRENGHT + ANY_DEXTERITY + ANY_FOCUS +ANY_INTELLIGENCE + ANY_DAMAGE_DEALT);
		
		//Assert
		assertEquals(expectedHP,fighter.getHP());
	}
	
	

}
