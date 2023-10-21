package duel;

import Exception.WarriorIllegalAptitudeException;
import Tools.Aptitudes;

public class Warrior extends Fighter{

	public Warrior(String name, Aptitudes aptitudes) {
		super(name, aptitudes);
		if (aptitudes.strenght < aptitudes.dexterity + 10) throw new WarriorIllegalAptitudeException();
		if (aptitudes.dexterity < aptitudes.intelligence + 10) throw new WarriorIllegalAptitudeException();
		if (aptitudes.intelligence < aptitudes.focus + 10) throw new WarriorIllegalAptitudeException();
		}

}
