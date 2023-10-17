package duelistMock;

import Skill.Skill;
import duel.Duelist;

public class DuelistStub implements Duelist{
	public boolean isAlive;
	
	@Override
	public boolean isAlive() {
		return this.isAlive;
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
