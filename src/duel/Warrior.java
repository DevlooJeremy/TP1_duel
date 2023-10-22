package duel;

import Exception.WarriorIllegalAptitudeException;
import Tools.Aptitudes;

public class Warrior extends Fighter{
	
	public static final int HEALTH_POINTS_THRESHOLD = 8;

	public Warrior(String name, Aptitudes aptitudes) {
		super(name, aptitudes);
		if (aptitudes.strenght < aptitudes.dexterity + 10) throw new WarriorIllegalAptitudeException();
		if (aptitudes.dexterity < aptitudes.intelligence + 10) throw new WarriorIllegalAptitudeException();
		if (aptitudes.intelligence < aptitudes.focus + 10) throw new WarriorIllegalAptitudeException();
		}
	
	@Override
	public void penalize(int penalityPointsNumber, int healthPoints) {
		if (super.getHP() <= HEALTH_POINTS_THRESHOLD) 
		{
			super.penalize(penalityPointsNumber, -healthPoints);
		}
		else 
		{
			super.penalize(penalityPointsNumber,healthPoints);
		}
	}
	
}
