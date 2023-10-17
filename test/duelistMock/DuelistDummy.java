package duelistMock;

import Skill.Skill;
import duel.Duelist;

public class DuelistDummy implements Duelist{

	@Override
	public boolean isAlive() {
		return true;
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int counterAttack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reward(int rewardPointsNumber, Skill prizeForWinner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void penalize(int penalityPointsNumber, int healthPoints) {
		// TODO Auto-generated method stub
		
	}

}
