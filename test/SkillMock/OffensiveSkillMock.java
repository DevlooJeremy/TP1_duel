package SkillMock;

import Skill.Skill;
import duel.Fighter;

public class OffensiveSkillMock implements Skill{

	@Override
	public int getPower(Fighter fighter) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isOffensiveSkill() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isDefensiveSkill() {
		// TODO Auto-generated method stub
		return false;
	}

}
