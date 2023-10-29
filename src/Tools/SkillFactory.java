package Tools;

import Skill.Crossbow;
import Skill.Shield;
import Skill.Skill;
import Skill.Spell;
import Skill.Sword;
import factoryEnum.SkillType;

public class SkillFactory {
	
	public SkillFactory() {
		
	}
	
	public Skill getOffensiveSkill(int power,SkillType type) {
		
		switch (type) {
		case Crossbow:
			return new Crossbow(power);
		case Sword:
			return new Sword(power);
		case Spell:
			return new Spell(power);
		}
		return null;
	}
	
	public Skill getDefensiveSkill(int power,SkillType type) {
		
		switch (type) {
		case Shield:
			return new Shield(power);
		case Sword:
			return new Sword(power);
		case Spell:
			return new Spell(power);
		}
		return null;
	}

}
