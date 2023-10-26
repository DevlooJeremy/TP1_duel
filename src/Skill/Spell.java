package Skill;

import Exception.SpellIllegalProwessException;
import duel.Fighter;

public class Spell extends Weapons{
	
	private static final boolean IS_SKILL_OFFENSIVE = true;
	private static final boolean IS_SKILL_DEFENSIVE = true;
	
	public int prowess;

	public Spell(int prowess) 
	{
		super(IS_SKILL_OFFENSIVE,IS_SKILL_DEFENSIVE);
		if (prowess < MINIMUM_STAT) throw new SpellIllegalProwessException();
		if (prowess > MAXIMUM_STAT) throw new SpellIllegalProwessException();
		this.prowess = prowess;
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		return (this.prowess * fighter.getIntelligence())/20;
	}

}
