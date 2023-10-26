package Skill;

import Exception.SwordIllegalImpactException;
import duel.Fighter;

public class Sword extends Weapons{
	
	private static final boolean IS_SKILL_OFFENSIVE = true;
	private static final boolean IS_SKILL_DEFENSIVE = true;

	private int impact;
	
	public Sword(int impact) {
		super(IS_SKILL_OFFENSIVE,IS_SKILL_DEFENSIVE);
		if (impact < MINIMUM_STAT) throw new SwordIllegalImpactException();
		if (impact > MAXIMUM_STAT) throw new SwordIllegalImpactException();
		this.impact = impact;
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		return (this.impact * fighter.getStrenght())/20;
	}

}
