package SkillMock;

import Skill.Skill;
import duel.Fighter;

public class DefensiveSkillMock implements Skill{
	
	public int damage;

	@Override
	public int getPower(Fighter fighter) {
		// TODO Auto-generated method stub
		return this.damage;
	}

	@Override
	public boolean isOffensiveSkill() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDefensiveSkill() {
		// TODO Auto-generated method stub
		return true;
	}

}
