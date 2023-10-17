package duelistMock;

import Skill.Skill;
import duel.Duelist;

public class DeadDuelistMock implements Duelist{
	
	@Override
	public boolean isAlive() {
		return false;
	}

	@Override
	public int attack() {
		return 0;
	}

	@Override
	public int counterAttack() {
		return 0;
	}

	@Override
	public void reward(int rewardPointsNumber, Skill prizeForWinner) {
		
	}

	@Override
	public void penalize(int penalityPointsNumber, int healthPoints) {
		
	}

	
}
