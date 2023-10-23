package duel;

import Exception.AptitudesPointsUsedAbove100;
import Exception.AptitudesPointsUsedBelow0;
import Exception.NegativeHPException;
import Skill.Skill;
import SkillMock.SkillDummy;
import Tools.Aptitudes;
import bag.Bag;

public abstract class Fighter implements Duelist{

	
	private String name;
	private int intelligence;
	private int dexterity;
	private int strenght;
	private int focus;
	private int hp;
	private int points;
	private Bag skillBag;
	
	public Fighter(String name, Aptitudes aptitudes, Bag bag) {
		if (aptitudes.dexterity + aptitudes.strenght + aptitudes.intelligence + aptitudes.focus > 100) throw new AptitudesPointsUsedAbove100();
		this.name = name;
		this.intelligence = aptitudes.intelligence;
		this.dexterity = aptitudes.dexterity;
		this.strenght = aptitudes.strenght;
		this.focus = aptitudes.focus;
		this.hp = 200 - (aptitudes.dexterity + aptitudes.strenght + aptitudes.intelligence + aptitudes.focus);
		this.skillBag = bag;
	}
	
	@Override
	public boolean isAlive() {
		if (this.hp < 0) throw new NegativeHPException();
		return this.hp != 0;
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int counterAttack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reward(int rewardPointsNumber, Skill prizeForWinner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void penalize(int penalityPointsNumber, int healthPoints) {
		if (this.hp < healthPoints)
		{
			this.hp -= this.hp;
		}
		else 
		{
			this.hp -= healthPoints;			
		}
		
	}

	public String getName() {
		return this.name;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public int getIntelligence() {
		return this.intelligence;
	}
	
	public int getStrenght() {
		return this.strenght;
	}
	
	public int getDexterity() {
		return this.dexterity;
	}
	
	public int getFocus() {
		return this.focus;
	}
}
