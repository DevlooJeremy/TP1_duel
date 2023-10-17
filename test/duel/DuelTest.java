package duel;
import Skill.Skill;
import SkillMock.SkillDummy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exception.DeadDuelistCanNotDuelException;
import duelistMock.DuelistSpy;
import duelistMock.DeadDuelistMock;
import duelistMock.DuelistDummy;
import duelistMock.SurrenderDuelistMock;

class DuelTest {
	
	private static final int POINTS_FOR_WINNER = 1;
	private static final int POINTS_FOR_LOSER = -1;
	private static final int COUNTER_ATTACKER_SURRENDER_POINTS = 0;

	@Test
	void givenADuelWithTwoFighters_ifAttackerIsNotAlive_duelWillNotStart() {
		//Arrange
		DeadDuelistMock attacker = new DeadDuelistMock();
		Duelist counterAttacker = new DuelistDummy();
		//Act
		assertThrows(DeadDuelistCanNotDuelException.class, ()-> {
			Duel duel = new Duel(attacker,counterAttacker);
		});
		//Assert
	}
	
	@Test
	void givenADuelWithTwoFighters_ifCounterAttackerIsNotAlive_duelWillNotStart() {
		//Arrange
		Duelist attacker = new DuelistDummy();
		Duelist counterAttacker = new DeadDuelistMock();
		//Act
		assertThrows(DeadDuelistCanNotDuelException.class, ()-> {
			Duel duel = new Duel(attacker,counterAttacker);
		});
		//Assert
	}
	
	@Test
	void givenADuelWithTwoFighters_ifBothDuelistAreNotAlive_duelWillNotStart() {
		//Arrange
		Duelist attacker = new DeadDuelistMock();
		Duelist counterAttacker = new DeadDuelistMock();
		//Act
		assertThrows(DeadDuelistCanNotDuelException.class, ()-> {
			Duel duel = new Duel(attacker,counterAttacker);
		});
		//Assert
	}
	
	@Test
	void givenADuelWithTwoFighters_whenFightStart_AttackMethodAndCounterAttackMethodIsCalled() {
		//Arrange
		DuelistSpy attacker = new DuelistSpy();
		DuelistSpy counterAttacker = new DuelistSpy();
		Skill skill = new SkillDummy();
		Duel duel = new Duel(attacker, counterAttacker);
		//Act
		duel.fight(skill);
		//Assert
		assertTrue(attacker.attackHasBeenCalled);
		assertTrue(counterAttacker.counterAttackHasBeenCalled);
	}
	
	@Test
	void givenADuelWithStrongerAttacker_whenFight_attackerWinAndCounterAttackerLose() {
		//Arrange
		DuelistSpy attacker = new DuelistSpy();
		DuelistSpy counterAttacker = new DuelistSpy();
		Skill skill = new SkillDummy();
		attacker.power = 1;
		counterAttacker.power = 0;
		Duel duel = new Duel(attacker, counterAttacker);
		
		//Act
		duel.fight(skill);
		
		//Assert
		assertTrue(attacker.rewardHasBeenCalled);
		assertTrue(counterAttacker.penalizeHasBeenCalled);
	}
	
	@Test
	void givenADuelWithStrongerCounterAttacker_whenFight_counterAttackerWinAndAttackerLose() {
		//Arrange
		DuelistSpy attacker = new DuelistSpy();
		DuelistSpy counterAttacker = new DuelistSpy();
		Skill skill = new SkillDummy();
		attacker.power = 0;
		counterAttacker.power = 1;
		Duel duel = new Duel(attacker, counterAttacker);
		
		//Act
		duel.fight(skill);
		
		//Assert
		assertTrue(attacker.penalizeHasBeenCalled);
		assertTrue(counterAttacker.rewardHasBeenCalled);
	}
	
	@Test
	void givenADuelWithEvenFighters_whenFight_counterAttackerWinAndAttackerLose() {
		//Arrange
		DuelistSpy attacker = new DuelistSpy();
		DuelistSpy counterAttacker = new DuelistSpy();
		Skill skill = new SkillDummy();
		attacker.power = 0;
		counterAttacker.power = 0;
		Duel duel = new Duel(attacker, counterAttacker);
		
		//Act
		duel.fight(skill);
		
		//Assert
		assertTrue(attacker.penalizeHasBeenCalled);
		assertTrue(counterAttacker.rewardHasBeenCalled);
	}
	
	@Test
	void givenADuelWithWinningAttacker_whenFightEnds_attackerGetsRewarded() {
		//Arrange
		DuelistSpy attacker = new DuelistSpy();
		DuelistSpy counterAttacker = new DuelistSpy();
		attacker.power = 5;
		counterAttacker.power = 0;
		Duel duel = new Duel(attacker,counterAttacker);
		Skill skill = new SkillDummy();
		
		//Act
		duel.fight(skill);
		
		//Assert
		assertEquals(skill,attacker.skill);
		assertEquals(1,attacker.points);
		
	}
	
	@Test
	void givenADuelWithWinningAttacker_whenFightEnds_counterAttackerGetsPenalized() {
		//Arrange
		DuelistSpy attacker = new DuelistSpy();
		DuelistSpy counterAttacker = new DuelistSpy();
		attacker.power = 5;
		counterAttacker.power = 0;
		Duel duel = new Duel(attacker,counterAttacker);
		Skill skill = new SkillDummy();
		
		//Act
		duel.fight(skill);
		int expectedDamage = attacker.power - counterAttacker.power;
		//Assert
		assertEquals(expectedDamage,counterAttacker.hp);
		assertEquals(-1,counterAttacker.points);
		
	}
	
	@Test
	void givenADuelWithTwoFighters_whenAttackerSurrenders_thenCounterAttackerIsRewarded() {
		//Arrange
		Duelist attacker = new SurrenderDuelistMock();
		DuelistSpy counterAttacker = new DuelistSpy();
		Duel duel = new Duel(attacker,counterAttacker);
		Skill skill = new SkillDummy();
		
		//Act
		duel.fight(skill);
		
		//Assert
		assertEquals(skill,counterAttacker.skill);
		assertEquals(1,counterAttacker.points);
	}
	
	@Test
	void givenADuelWithTwoFighters_whenCounterAttackerSurrenders_thenAttackerIsRewarded() {
		//Arrange
		DuelistSpy attacker = new DuelistSpy();
		Duelist counterAttacker = new SurrenderDuelistMock();
		Duel duel = new Duel(attacker,counterAttacker);
		Skill skill = new SkillDummy();
		
		//Act
		duel.fight(skill);
		
		//Assert
		assertEquals(COUNTER_ATTACKER_SURRENDER_POINTS,attacker.points);
		assertEquals(skill,attacker.skill);
	}
}
