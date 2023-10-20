package DTO;

import Exception.AptitudesPointsUsedBelow0;

public class Aptitudes {
	public final int strenght;
	public final int focus;
	public final int intelligence;
	public final int dexterity;
	
	public Aptitudes(int str, int dex, int focus, int intel) {
		if (str < 0) throw new AptitudesPointsUsedBelow0();
		if (dex < 0) throw new AptitudesPointsUsedBelow0();
		if (focus < 0) throw new AptitudesPointsUsedBelow0();
		if (intel < 0) throw new AptitudesPointsUsedBelow0();
		this.strenght = str;
		this.dexterity = dex;
		this.focus = focus;
		this.intelligence = intel;
	}
}
