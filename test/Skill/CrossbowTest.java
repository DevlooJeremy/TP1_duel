package Skill;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exception.CrossbowIllegalAccuracyException;
import FighterMock.FighterStub;
import SkillMock.SkillDummy;
import Tools.Aptitudes;
import bag.Bag;
import bag.FighterBag;
import bagMock.BagDummy;
import duel.Fighter;

class CrossbowTest {
	
	private static final int MINIMUM_ACCURACY = 20;
	private static final int MAXIMUM_ACCURACY = 50;
	private static final int ANY_ACCURACY = 20;
	
	private static final String ANY_NAME = "Jean";
	private static final int ANY_APTITUDE_POINTS = 20;

	@Test
	void aCrossbowWithLegalAccuracyCanBeCreated() {
		Crossbow crossbow = new Crossbow(ANY_ACCURACY);
	}
	
	@Test
	void givenACrossbowWithAccuracyLowerThenMinimum_whenCreated_anExceptionIsThrown() {
		assertThrows(CrossbowIllegalAccuracyException.class, ()-> {
			Crossbow crossbow = new Crossbow(MINIMUM_ACCURACY -1);
		});
	}

	@Test
	void givenACrossbowWithAccuracyHigherThenMaximum_whenCreated_anExceptionIsThrown() {
		assertThrows(CrossbowIllegalAccuracyException.class, ()-> {
			Crossbow crossbow = new Crossbow(MAXIMUM_ACCURACY + 1);
		});
	}
	
	@Test
	void givenACrossbow_whenAskedPowerDamage_powerDamageIsReturned() {
		//Arrange
		Crossbow crossbow = new Crossbow(ANY_ACCURACY);
		Aptitudes apt = new Aptitudes(ANY_APTITUDE_POINTS,ANY_APTITUDE_POINTS,ANY_APTITUDE_POINTS,ANY_APTITUDE_POINTS);
		Bag bag = new BagDummy(new SkillDummy(), new SkillDummy());
		Fighter fighter = new FighterStub(ANY_NAME,apt,bag);
		
		//Act
		int power = crossbow.getPower(fighter);
		int expectedPower = ANY_ACCURACY * 20 /20;
		
		//Assert
		assertEquals(expectedPower,power);
	}
	
	@Test
	void givenACrossbow_whenAskedIfOffensiveSkill_thenBooleanIsReturned() {
		//Arrange
		Crossbow crossbow = new Crossbow(ANY_ACCURACY);
		
		//Act
		boolean isOffensiveSkill = crossbow.isOffensiveSkill();
		
		//Assert
		assertTrue(isOffensiveSkill);
	}
	
	@Test
	void givenACrossbow_whenAskedIfDefensiveSkill_thenBooleanIsReturned() {
		//Arrange
		Crossbow crossbow = new Crossbow(ANY_ACCURACY);
		
		//Act
		boolean isDefensiveSkill = crossbow.isDefensiveSkill();
		
		//Assert
		assertFalse(isDefensiveSkill);
	}

}
