package SkillMock;

import Skill.Skill;
import duel.Fighter;

public class SkillStub implements Skill{
	
	public int power;
	
	public SkillStub(int power) {
		this.power= power;
	}

	@Override
	public int getPower(Fighter fighter) {
		// TODO Auto-generated method stub
		return this.power;
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
