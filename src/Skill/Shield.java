package Skill;

import Exception.ShieldIllegalProtectionException;
import duel.Fighter;

public class Shield extends Weapons{
	
	private static final boolean IS_SKILL_OFFENSIVE = false;
	private static final boolean IS_SKILL_DEFENSIVE = true;
	
	private int protection;

	public Shield(int protection) 
	{
		super(IS_SKILL_OFFENSIVE,IS_SKILL_DEFENSIVE);
		if (protection < MINIMUM_STAT) throw new ShieldIllegalProtectionException();
		if (protection > MAXIMUM_STAT) throw new ShieldIllegalProtectionException();
		this.protection = protection;
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		return (this.protection * fighter.getDexterity())/20;
	}

}
