package SkillMock;

import Skill.Skill;
import duel.Fighter;

public class SkillDummy implements Skill{

	@Override
	public int getPower(Fighter fighter) {
		return 0;
	}

	@Override
	public boolean isOffensiveSkill() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDefensiveSkill() {
		// TODO Auto-generated method stub
		return false;
	}

}
