package bag;

import java.util.ArrayList;
import java.util.List;

import Skill.Skill;

public class FighterBag implements Bag{
	
	private List<Skill> inventory;
	
	public FighterBag(Skill firstSkill, Skill secondSkill) {
		this.inventory = new ArrayList<Skill>();
		this.inventory.add(firstSkill);
		this.inventory.add(secondSkill);
	}

	@Override
	public void addSkill(Skill skill) {
		this.inventory.add(skill);
		
	}

	@Override
	public void withdrawSkill(Skill skill) {
		this.inventory.remove(skill);
	}

}
