package Skill;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exception.SpellIllegalProwessException;
import FighterMock.FighterStub;
import SkillMock.SkillDummy;
import Tools.Aptitudes;
import bag.Bag;
import bagMock.BagDummy;
import duel.Fighter;

class SpellTest {
	
	private static final int MINIMUM_PROWESS = 20;
	private static final int MAXIMUM_PROWESS = 50;
	private static final int ANY_PROWESS = 20;
	
	private static final String ANY_NAME = "Jean";
	private static final int ANY_APTITUDE_POINTS = 20;

	@Test
	void spellCanBeCreated() {
		Spell spell = new Spell(ANY_PROWESS);
	}
	
	@Test
	void givenASpellWithLowerThenMinimumProwess_whenCreated_anExceptionIsThrown() {
		assertThrows(SpellIllegalProwessException.class, ()-> {
			Spell spell = new Spell(MINIMUM_PROWESS -1);
		});
	}
	
	@Test
	void givenASpellWithHigherThenMaximumProwess_whenCreated_anExceptionIsThrown() {
		assertThrows(SpellIllegalProwessException.class, ()-> {
			Spell spell = new Spell(MAXIMUM_PROWESS +1);
		});
	}
	
	@Test
	void givenASpell_whenAskedIfOffensiveSkill_booleanIsReturned() {
		//Arrange
		Spell spell = new Spell(ANY_PROWESS);
		
		//Act
		boolean isOffensiveSkill = spell.isOffensiveSkill();
		
		//Assert
		assertTrue(isOffensiveSkill);
	}
	
	@Test
	void givenASpell_whenAskedPowerDamage_powerDamageIsReturned() {
		//Arrange
		Spell spell = new Spell(ANY_PROWESS);
		Aptitudes apt = new Aptitudes(ANY_APTITUDE_POINTS,ANY_APTITUDE_POINTS,ANY_APTITUDE_POINTS,ANY_APTITUDE_POINTS);
		Bag bag = new BagDummy(new SkillDummy(), new SkillDummy());
		Fighter fighter = new FighterStub(ANY_NAME,apt,bag);
		
		//Act
		int powerDamage = spell.getPower(fighter);
		int expectedPower = ANY_PROWESS*ANY_APTITUDE_POINTS/20;
		
		//Assert
		assertEquals(expectedPower,powerDamage);
	}
	
	@Test
	void givenASpell_whenAskedIfDefensiveSkill_booleanIsReturned() {
		//Arrange
		Spell spell = new Spell(ANY_PROWESS);
		
		//Act
		boolean isDefensiveSkill = spell.isDefensiveSkill();
		
		//Assert
		assertTrue(isDefensiveSkill);
	}

}
