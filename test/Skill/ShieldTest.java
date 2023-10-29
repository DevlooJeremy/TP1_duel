package Skill;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exception.ShieldIllegalProtectionException;
import FighterMock.FighterStub;
import SkillMock.SkillDummy;
import Tools.Aptitudes;
import bag.Bag;
import bagMock.BagDummy;
import duel.Fighter;

class ShieldTest {
	
	private static final int MINIMUM_PROTECTION = 20;
	private static final int MAXIMUM_PROTECTION = 50;
	private static final int ANY_PROTECTION = 20;
	
	private static final String ANY_NAME = "Jean";
	private static final int ANY_APTITUDE_POINTS = 20;

	@Test
	void shieldCanBeCreatedWithLegalProtection() {
		Shield shield = new Shield(ANY_PROTECTION);
	}
	
	@Test
	void givenAShieldWithProtectionLowerThenMinimum_whenCreated_anExceptionIsThrown() {
		assertThrows(ShieldIllegalProtectionException.class, ()->{
			Shield shield = new Shield(MINIMUM_PROTECTION -1);
		});
	}
	
	@Test
	void givenASHieldWithProtectionHigherThenMaximum_whenCreated_anExceptionIsThrown() {
		assertThrows(ShieldIllegalProtectionException.class, ()-> {
			Shield shield = new Shield(MAXIMUM_PROTECTION +1);
		});
	}
	
	@Test 
	void givenAShield_whenAskedPowerDamage_powerDamageIsReturned() {
		//Arrange
		Shield shield = new Shield(ANY_PROTECTION);
		Aptitudes apt = new Aptitudes(ANY_APTITUDE_POINTS,ANY_APTITUDE_POINTS,ANY_APTITUDE_POINTS,ANY_APTITUDE_POINTS);
		Bag bag = new BagDummy();
		Fighter fighter = new FighterStub(ANY_NAME,apt,bag);
		
		//Act
		int power = shield.getPower(fighter);
		int expectedPower = ANY_APTITUDE_POINTS * ANY_PROTECTION /20;
		
		//Assert
		assertEquals(expectedPower,power);
	}
	
	@Test
	void givenAShield_whenAskedIfOffensiveSkill_booleanIsReturned() {
		//Arrange
		Shield shield = new Shield(ANY_PROTECTION);
		
		//Act
		boolean isOffensiveSkill = shield.isOffensiveSkill();
		
		//Assert
		assertFalse(isOffensiveSkill);
	}
	
	@Test
	void givenAShield_whenAskedIfDefensiveSkill_booleanIsReturned() {
		//Arrange
		Shield shield = new Shield(ANY_PROTECTION);
		
		//Act
		boolean isDefensiveSkill = shield.isDefensiveSkill();
		
		//Assert
		assertTrue(isDefensiveSkill);
	}

}
