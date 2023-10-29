package Fighter;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exception.AptitudesPointsUsedAbove100;
import Exception.AptitudesPointsUsedBelow0;
import Exception.AttackerHasSurrenderedException;
import Exception.CounterAttackerHasSurrenderedException;
import Exception.DeadDuelistCanNotDuelException;
import Exception.NegativeHPException;
import FighterMock.FighterStub;
import Skill.Skill;
import SkillMock.DefensiveSkillMock;
import SkillMock.SkillDummy;
import SkillMock.SkillStub;
import Tools.Aptitudes;
import bag.Bag;
import bagMock.AttackSkillBagMock;
import bagMock.BagDummy;
import bagMock.BagStub;
import bagMock.CounterAttackSkillBagMock;
import bagMock.NullSkillBag;
import duel.Fighter;

class FighterTest {
	private static final int ANY_INTELLIGENCE = 20; 
	private static final int ANY_DEXTERITY = 20;
	private static final int ANY_STRENGHT = 20;
	private static final int ANY_FOCUS = 20;
	private static final int TOO_HIGH_STRENGHT = 100;
	private static final int ANY_DAMAGE_DEALT = 100;
	private static final int ANY_SKILL_POWER = 20;
	
	public static final String ANY_NAME = "Jean";
	public static final int BASE_FIGHTER_HP = 200;
	public static final int WINNER_REWARD = 1;
	public static final int LOSER_PENALITY = 1;

	@Test
	void givenAFighter_whenCreatedWithMoreThenAHundredPoints_thenExceptionIsCalled() {
		Aptitudes apt = new Aptitudes(TOO_HIGH_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		Bag bag = new BagDummy();
		
		assertThrows(AptitudesPointsUsedAbove100.class,()-> {
			Fighter fighter = new FighterStub(ANY_NAME,apt,bag);
		});
	}
	
	@Test
	void givenAFighter_whenCreated_fighterShouldSetAllHisAttributes() {
		//Arrange
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		Bag bag = new BagDummy();
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
		Bag bag = new BagDummy();
		FighterStub fighter = new FighterStub(ANY_NAME,apt,bag);
		
		
		//Act
		fighter.penalize(LOSER_PENALITY, ANY_DAMAGE_DEALT);
		int expectedHP = BASE_FIGHTER_HP - (ANY_STRENGHT + ANY_DEXTERITY + ANY_FOCUS +ANY_INTELLIGENCE + ANY_DAMAGE_DEALT);
		
		//Assert
		assertEquals(expectedHP,fighter.getHP());
	}
	
	@Test
	void givenAFighterWithNoAttackingSkill_whenHeAttacks_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		Bag bag = new NullSkillBag();
		FighterStub fighter = new FighterStub(ANY_NAME,apt,bag);
		
		assertThrows(AttackerHasSurrenderedException.class,()-> {
			fighter.attack();
		});
		
	}
	
	@Test
	void givenAFighterWithNoSkill_whenHeCounterAttacks_anExceptionIsThrown() {
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		Bag bag = new NullSkillBag();
		FighterStub fighter = new FighterStub(ANY_NAME,apt,bag);
		
		assertThrows(CounterAttackerHasSurrenderedException.class,()-> {
			fighter.counterAttack();
		});
		
	}
	
	@Test
	void givenAFighterWithAnAttackingSkill_whenHeAttacks_attackPowerIsReturned() {
		//Arrange
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		SkillStub skill = new SkillStub(ANY_SKILL_POWER);
		Bag bag = new AttackSkillBagMock(skill);
		FighterStub fighter = new FighterStub(ANY_NAME,apt,bag);
		
		//Act
		int damageDealt = fighter.attack();
		int expectedDamage = ANY_SKILL_POWER;
		
		//Assert
		assertEquals(expectedDamage,damageDealt);
	}
	
	@Test
	void givenAFighterWithACounterAttackingSkill_whenHeCounterAttacks_counterAttackPowerIsReturned() {
		//Arrange
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		SkillStub skill = new SkillStub(ANY_SKILL_POWER);
		Bag bag = new CounterAttackSkillBagMock(skill);
		FighterStub fighter = new FighterStub(ANY_NAME,apt,bag);
		
		//Act
		int damageDealt = fighter.counterAttack();
		int expectedDamage = ANY_SKILL_POWER;
		
		//Assert
		assertEquals(expectedDamage,damageDealt);
	}
	
	@Test
	void givenAFighterWhoJustWonADuel_whenRewarded_allFighterAptitudesAreIncreased() {
		//Arrange
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		Bag bag = new BagDummy();
		Skill skill = new SkillDummy();
		FighterStub fighter = new FighterStub(ANY_NAME,apt,bag);
		
		//Act
		fighter.reward(WINNER_REWARD, skill);
		
		//Assert
		assertEquals(ANY_STRENGHT + 1, fighter.getStrenght());
		assertEquals(ANY_DEXTERITY + 1, fighter.getDexterity());
		assertEquals(ANY_FOCUS + 1, fighter.getFocus());
		assertEquals(ANY_INTELLIGENCE + 1, fighter.getIntelligence());
	}
	
	@Test
	void givenAFighterWhoJustWonADuel_whenRewarded_skillRewardIsAddedToInventory() {
		//Arrange
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		Skill skill = new SkillDummy();
		BagStub bag = new BagStub();
		FighterStub fighter = new FighterStub(ANY_NAME,apt,bag);
		
		//Act
		fighter.reward(WINNER_REWARD,skill);
		
		//Assert
		assertTrue(bag.isSkillInInvetory(skill));
	}
	
	@Test
	void givenAFighterWhoJustLostADuel_whenPenalized_allFighterAptitudesAreDecreased() {
		//Arrange
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		Bag bag = new BagDummy();
		FighterStub fighter = new FighterStub(ANY_NAME,apt,bag);
		
		//Act
		fighter.penalize(LOSER_PENALITY, ANY_DAMAGE_DEALT);
		
		//Assert
		assertEquals(ANY_STRENGHT -1, fighter.getStrenght());
		assertEquals(ANY_DEXTERITY -1, fighter.getDexterity());
		assertEquals(ANY_FOCUS -1, fighter.getFocus());
		assertEquals(ANY_INTELLIGENCE -1, fighter.getIntelligence());
	}
	
	@Test
	void givenAFighterWhoJustLostADuel_whenPenalized_fighterLosesHp() {
		//Arrange
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		Bag bag = new BagDummy();
		FighterStub fighter = new FighterStub(ANY_NAME,apt,bag);
		
		//Act
		fighter.penalize(LOSER_PENALITY, ANY_DAMAGE_DEALT);
		int expectedHP = BASE_FIGHTER_HP - (ANY_STRENGHT + ANY_DEXTERITY + ANY_FOCUS + ANY_INTELLIGENCE + ANY_DAMAGE_DEALT);
		
		//Assert
		assertEquals(expectedHP,fighter.getHP());
	}
	
	@Test
	void givenAFighterWhoIsDead_whenAskedIfHeIsAlive_aBooleanIsReturned() {
		//Arrange
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		Bag bag = new BagDummy();
		FighterStub fighter = new FighterStub(ANY_NAME,apt,bag);
		fighter.penalize(LOSER_PENALITY, fighter.getHP());
		
		//Act
		boolean isAlive = fighter.isAlive();
		
		//Assert
		assertFalse(isAlive);
	}
	
	@Test
	void givenAFighterWhoIsAlive_whenAskedIfHeIsAlive_aBooleanIsReturned() {
		//Arrange
		Aptitudes apt = new Aptitudes(ANY_STRENGHT,ANY_DEXTERITY,ANY_FOCUS,ANY_INTELLIGENCE);
		Bag bag = new BagDummy();
		FighterStub fighter = new FighterStub(ANY_NAME,apt,bag);
		fighter.penalize(LOSER_PENALITY, ANY_DAMAGE_DEALT);
		
		//Act
		boolean isAlive = fighter.isAlive();
		
		//Assert
		assertTrue(isAlive);
	}

}
