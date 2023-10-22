package duel;

import Exception.WizardIllegalAptitudeException;
import Tools.Aptitudes;

public class Wizard extends Fighter{

	public Wizard(String name, Aptitudes aptitudes) {
		super(name, aptitudes);
		if (aptitudes.focus < aptitudes.strenght + 15 || aptitudes.focus < aptitudes.dexterity + 15) throw new WizardIllegalAptitudeException();
		if (aptitudes.intelligence < aptitudes.strenght + 15 || aptitudes.intelligence < aptitudes.dexterity + 15) throw new WizardIllegalAptitudeException();
	}
	
	@Override
	public void penalize(int penalityPointsNumber, int healthPoints) {
		super.penalize(penalityPointsNumber, healthPoints/2);
	}

}
