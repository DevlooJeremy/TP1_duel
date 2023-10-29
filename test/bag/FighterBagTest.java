package bag;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Skill.Skill;
import SkillMock.DefensiveSkillMock;
import SkillMock.OffensiveSkillMock;
import SkillMock.SkillDummy;

class FighterBagTest {

	@Test
	void givenAFighterBagWithOffensiveSkills_whenAskedOffensiveSkill_returnsFirstMatchingSkill() {
		//Arrange
		Skill offensiveSkill1 = new OffensiveSkillMock();
		Skill offensiveSkill2 = new OffensiveSkillMock();
		FighterBag bag = new FighterBag(offensiveSkill1,offensiveSkill2);
		
		//Act
		Skill skill = bag.getAttackingSkill();
		
		//Assert
		assertEquals(offensiveSkill1,skill);
	}
	
	@Test
	void givenAFighterBagWithSkills_whenAskedCounterAttackingSkill_aSkillIsReturned() {
		//Arrange
		Skill skill1 = new SkillDummy();
		Skill skill2 = new SkillDummy();
		FighterBag bag = new FighterBag(skill1,skill2);
		
		
		//Act
		Skill skill = bag.getCounterAttackingSkill();
		
		//Assert
		assertEquals(skill,skill1);
	}
	
	@Test 
	void givenAFighterBagWithNoOffensiveSkill_whenAskedOffensiveSkill_nothingIsReturned() {
		//Arrange
		Skill skill1 = new SkillDummy();
		Skill skill2 = new SkillDummy();
		FighterBag bag = new FighterBag(skill1,skill2);
		
		//Act
		Skill skill = bag.getAttackingSkill();
		
		//Assert
		assertEquals(null,skill);
	}

}
