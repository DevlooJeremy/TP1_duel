package bag;

import Skill.Skill;

public interface Bag {

	public void addSkill(Skill skill);
	
	public void withdrawSkill(Skill skill);
	
	public Skill getAttackingSkill();
	
	public Skill getCounterAttackingSkill();
}
