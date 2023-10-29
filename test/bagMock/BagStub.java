package bagMock;

import java.util.ArrayList;
import java.util.List;

import Skill.Skill;
import bag.Bag;

public class BagStub implements Bag{
	
	public List<Skill> inventory;
	
	public BagStub() {
		this.inventory = new ArrayList<Skill>();
	}

	@Override
	public void addSkill(Skill skill) {
		this.inventory.add(skill);
		
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
	
	public boolean isSkillInInvetory(Skill skill) {
		return inventory.contains(skill);
	}

}
