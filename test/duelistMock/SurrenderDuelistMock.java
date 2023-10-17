package duelistMock;

import Exception.AttackerHasSurrenderedException;
import Exception.CounterAttackerHasSurrenderedException;
import Skill.Skill;
import duel.Duelist;

public class SurrenderDuelistMock implements Duelist{

	@Override
	public boolean isAlive() {
		return true;
	}

	@Override
	public int attack() {
		throw new AttackerHasSurrenderedException();
	}

	@Override
	public int counterAttack() {
		throw new CounterAttackerHasSurrenderedException();
	}

	@Override
	public void reward(int rewardPointsNumber, Skill prizeForWinner) {
		
	}

	@Override
	public void penalize(int penalityPointsNumber, int healthPoints) {
		
	}

}
