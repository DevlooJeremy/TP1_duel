package bagMock;

import Skill.Skill;
import bag.Bag;

public class NullSkillBag implements Bag{
	
	public NullSkillBag() {
		
	}

	@Override
	public void addSkill(Skill skill) {
		
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
		return null;
	}

}
