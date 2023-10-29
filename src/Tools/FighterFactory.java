package Tools;

import bag.Bag;
import duel.Fighter;
import duel.Giant;
import duel.Warrior;
import duel.Wizard;
import factoryEnum.FighterType;


public class FighterFactory {
	
	public FighterFactory() {
		
	}
	
	public Fighter giveMeFighter(FighterType type, String name, Aptitudes apt, Bag bag) {
		switch (type) {
		case Wizard:
			return new Wizard(name,apt,bag);
		case Warrior:
			return new Warrior(name,apt,bag);
		case Giant:
			return new Giant(name, apt,bag);
		}
		return null;
	}
}
