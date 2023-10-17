package duelistMock;

import Skill.Skill;
import duel.Duelist;

public class DuelistSpy  implements Duelist{
	
	public boolean attackHasBeenCalled = false;
	public boolean counterAttackHasBeenCalled = false;
	
	public boolean rewardHasBeenCalled = false;
	public boolean penalizeHasBeenCalled = false;
	
	public int power;
	
	public Skill skill = null;
	public int points;
	public int hp;

	@Override
	public boolean isAlive() {
		return true;
	}

	@Override
	public int attack() {
		this.attackHasBeenCalled = true;
		return this.power;
	}

	@Override
	public int counterAttack() {
		this.counterAttackHasBeenCalled = true;
		return this.power;
	}

	@Override
	public void reward(int rewardPointsNumber, Skill prizeForWinner) {
		this.rewardHasBeenCalled = true;
		this.points = rewardPointsNumber;
		this.skill = prizeForWinner;
	}

	@Override
	public void penalize(int penalityPointsNumber, int healthPoints) {
		this.penalizeHasBeenCalled = true;
		this.points = penalityPointsNumber;
		this.hp = healthPoints;
	}

}
