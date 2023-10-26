package Skill;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exception.SwordIllegalImpactException;
import FighterMock.FighterStub;
import SkillMock.SkillDummy;
import Tools.Aptitudes;
import bag.Bag;
import bagMock.BagDummy;
import duel.Fighter;

class SwordTest {
	private static final int MINIMUM_IMPACT = 20;
	private static final int MAXIMUM_IMPACT = 50;
	private static final int ANY_IMPACT = 20;
	
	private static final String ANY_NAME = "Jean";
	private static final int ANY_APTITUDE_POINTS = 20;

	@Test
	void swordCanBeCreated() {
		Sword sword = new Sword(ANY_IMPACT);
	}
	
	@Test
	void givenASwordWithLowerThenMinimumImpact_whenCreated_anExceptionIsThrown() {
		assertThrows(SwordIllegalImpactException.class, ()-> {
			Sword sword = new Sword(MINIMUM_IMPACT -1);
		});
	}
	
	@Test
	void givenASwordWithHigherThenMaximumImpact_whenCreated_anExceptionIsThrown() {
		assertThrows(SwordIllegalImpactException.class, ()-> {
			Sword sword = new Sword(MAXIMUM_IMPACT +1);
		});
	}
	
	@Test
	void givenASword_whenAskedPowerDamage_powerDamageIsReturned() {
		//Arrange
		Sword sword = new Sword(ANY_IMPACT);
		Aptitudes apt = new Aptitudes(ANY_APTITUDE_POINTS,ANY_APTITUDE_POINTS,ANY_APTITUDE_POINTS,ANY_APTITUDE_POINTS);
		Bag bag = new BagDummy(new SkillDummy(), new SkillDummy());
		Fighter fighter = new FighterStub(ANY_NAME,apt,bag);
		
		//Act
		int powerDamage = sword.getPower(fighter);
		int expectedPower = ANY_IMPACT * ANY_APTITUDE_POINTS/20;
		
		//Assert
		assertEquals(expectedPower,powerDamage);
	}
	
	@Test
	void givenASword_whenAskedIfOffensiveSkill_booleanIsReturned() {
		//Arrange
		Sword sword = new Sword(ANY_IMPACT);
		
		//Act
		boolean isOffensiveSkill = sword.isOffensiveSkill();
		
		//Assert
		assertTrue(isOffensiveSkill);
	}
	
	@Test
	void givenASword_whenAskedIfDefensiveSkill_booleanIsReturned() {
		//Arrange
		Sword sword = new Sword(ANY_IMPACT);
		
		//Act
		boolean isDefensiveSkill = sword.isDefensiveSkill();
		
		//Assert
		assertTrue(isDefensiveSkill);
	}

}
