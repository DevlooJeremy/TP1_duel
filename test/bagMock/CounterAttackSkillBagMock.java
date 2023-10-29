package bagMock;

import Skill.Skill;
import bag.Bag;

public class CounterAttackSkillBagMock implements Bag{
	
	public Skill skill;
	
	public CounterAttackSkillBagMock(Skill skill) {
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
		return null;
	}

	@Override
	public Skill getCounterAttackingSkill() {
		// TODO Auto-generated method stub
		return this.skill;
	}

}
