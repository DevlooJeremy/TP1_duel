package bagMock;

import Skill.Skill;
import SkillMock.DefensiveSkillMock;
import SkillMock.OffensiveSkillMock;
import bag.Bag;

public class AttackSkillBagMock implements Bag{
	
	public Skill skill;
	
	public AttackSkillBagMock(Skill skill) {
		this.skill = skill;
	}

	@Override
	public void addSkill(Skill skill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawSkill(Skill skill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Skill getAttackingSkill() {
		// TODO Auto-generated method stub
		return this.skill;
	}

	@Override
	public Skill getCounterAttackingSkill() {
		// TODO Auto-generated method stub
		return null;
	}

}
