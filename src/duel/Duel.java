package duel;

import Exception.DeadDuelistCanNotDuelException;
import Skill.Skill;

public class Duel {
	
	private static final int WINNER_POINTS = 1;
	private static final int LOSER_POINTS = -1;
	
	private Duelist attacker;
	private Duelist counterAttacker;

	public Duel(Duelist attacker, Duelist counterAttacker) {
		if (!attacker.isAlive() || !counterAttacker.isAlive()) throw new DeadDuelistCanNotDuelException();
		this.attacker = attacker;
		this.counterAttacker = counterAttacker;
	}
	
	public void fight(Skill prizeForWinner) {
		int attackPower =  this.attacker.attack();
		int counterAttackPower = this.counterAttacker.counterAttack();
		if (attackPower > counterAttackPower) {
			this.attacker.reward(WINNER_POINTS, prizeForWinner);
			this.counterAttacker.penalize(LOSER_POINTS, attackPower - counterAttackPower);
		} else if (attackPower < counterAttackPower) {
			this.attacker.penalize(LOSER_POINTS, counterAttackPower - attackPower);
			this.counterAttacker.reward(WINNER_POINTS, prizeForWinner);
		} else {
			this.attacker.penalize(LOSER_POINTS, counterAttackPower - attackPower);
			this.counterAttacker.reward(WINNER_POINTS, prizeForWinner);
		}
	}
}
