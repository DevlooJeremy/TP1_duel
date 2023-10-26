package Skill;

import Exception.CrossbowIllegalAccuracyException;
import duel.Fighter;

public class Crossbow extends Weapons{
	
	private static final boolean IS_SKILL_OFFENSIVE = true;
	private static final boolean IS_SKILL_DEFENSIVE = false;

	private int accuracy;
	
	public Crossbow(int accuracy) {
		super(IS_SKILL_OFFENSIVE,IS_SKILL_DEFENSIVE);
		if (accuracy < MINIMUM_STAT) throw new CrossbowIllegalAccuracyException();
		if (accuracy > MAXIMUM_STAT) throw new CrossbowIllegalAccuracyException();
		this.accuracy = accuracy;
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		
		return (this.accuracy*fighter.getFocus())/20;
	}

}
