package duel;

import Exception.GiantIllegalAptitudeException;
import Tools.Aptitudes;

public class Giant extends Fighter{
	
	public static final int MINIMUM_DAMAGE_TO_FINISH_GIANT = 11;

	public Giant(String name, Aptitudes aptitudes) {
		super(name, aptitudes);
		if (aptitudes.strenght < 20) throw new GiantIllegalAptitudeException(); 
		if (aptitudes.dexterity < 20) throw new GiantIllegalAptitudeException(); 
		if (aptitudes.focus < 20) throw new GiantIllegalAptitudeException(); 
		if (aptitudes.intelligence < 20) throw new GiantIllegalAptitudeException(); 
		
	}
	
	@Override
	public void penalize(int penalityPointsNumber, int healthPoints) {
		if (this.getHP() <= healthPoints) 
		{
			if (healthPoints < MINIMUM_DAMAGE_TO_FINISH_GIANT)
			{
				super.penalize(-1, 0);
			}
			else
			{
				super.penalize(-1, healthPoints);
			}
		}
		else 
		{
			super.penalize(-1, healthPoints);
		}
	}

}
