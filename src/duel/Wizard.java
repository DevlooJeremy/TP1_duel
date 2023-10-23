package duel;

import Exception.WizardIllegalAptitudeException;
import Tools.Aptitudes;
import bag.Bag;

public class Wizard extends Fighter{

	public Wizard(String name, Aptitudes aptitudes, Bag bag) {
		super(name, aptitudes,bag);
		if (aptitudes.focus < aptitudes.strenght + 15 || aptitudes.focus < aptitudes.dexterity + 15) throw new WizardIllegalAptitudeException();
		if (aptitudes.intelligence < aptitudes.strenght + 15 || aptitudes.intelligence < aptitudes.dexterity + 15) throw new WizardIllegalAptitudeException();
	}
	
	@Override
	public void penalize(int penalityPointsNumber, int healthPoints) {
		super.penalize(penalityPointsNumber, healthPoints/2);
	}

}
