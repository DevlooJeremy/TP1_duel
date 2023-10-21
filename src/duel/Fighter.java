package duel;

import Exception.AptitudesPointsUsedAbove100;
import Exception.AptitudesPointsUsedBelow0;
import Skill.Skill;
import Tools.Aptitudes;

public abstract class Fighter implements Duelist{

	
	private String name;
	private int intelligence;
	private int dexterity;
	private int strenght;
	private int focus;
	private int hp;
	
	public Fighter(String name, Aptitudes aptitudes) {
		if (aptitudes.dexterity + aptitudes.strenght + aptitudes.intelligence + aptitudes.focus > 100) throw new AptitudesPointsUsedAbove100();
		this.name = name;
		this.intelligence = aptitudes.intelligence;
		this.dexterity = aptitudes.dexterity;
		this.strenght = aptitudes.strenght;
		this.focus = aptitudes.focus;
		this.hp = 200 - (aptitudes.dexterity + aptitudes.strenght + aptitudes.intelligence + aptitudes.focus);
	}
	
	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		
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
