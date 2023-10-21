package Tools;

import duel.Fighter;
import duel.Giant;
import duel.Warrior;
import duel.Wizard;

enum FighterType {
		Wizard,
		Warrior,
		Giant;
	}

public class FighterFactory {
	
	public FighterFactory() {
		
	}
	
	public Fighter giveMeFighter(FighterType type, String name, Aptitudes apt) {
		switch (type) {
		case Wizard:
			return new Wizard(name,apt);
		case Warrior:
			return new Warrior(name,apt);
		case Giant:
			return new Giant(name, apt);
		}
		return null;
	}
}
