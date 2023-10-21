package duel;

import Exception.GiantIllegalAptitudeException;
import Tools.Aptitudes;

public class Giant extends Fighter{

	public Giant(String name, Aptitudes aptitudes) {
		super(name, aptitudes);
		if (aptitudes.strenght < 20) throw new GiantIllegalAptitudeException(); 
		if (aptitudes.dexterity < 20) throw new GiantIllegalAptitudeException(); 
		if (aptitudes.focus < 20) throw new GiantIllegalAptitudeException(); 
		if (aptitudes.intelligence < 20) throw new GiantIllegalAptitudeException(); 
		
	}

}
