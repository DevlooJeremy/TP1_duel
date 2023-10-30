package simulator;

import java.util.List;

import Exception.AttackerHasSurrenderedException;
import Skill.Skill;
import Tools.Aptitudes;
import Tools.FighterFactory;
import Tools.SkillFactory;
import bag.Bag;
import bag.FighterBag;
import duel.Duel;
import duel.Fighter;
import duel.Giant;
import factoryEnum.FighterType;
import factoryEnum.SkillType;

public class Simulator {
	
	private static final int GIANT_APTITUDES = 25;
	
	private static final int WIZARD_STRENGHT = 15;
	private static final int WIZARD_DEXTERITY = 15;
	private static final int WIZARD_FOCUS = 30;
	private static final int WIZARD_INTELLIGENCE = 30;
	
	private static final int WARRIOR_STRENGHT = 31;
	private static final int WARRIOR_DEXTERITY = 21;
	private static final int WARRIOR_FOCUS = 1;
	private static final int WARRIOR_INTELLIGENCE = 11;
	
	private Fighter warrior;
	private Fighter wizard;
	private Fighter giant;

	public static void main(String[] args) {
		new Simulator();
	}

	
	public Simulator() {
		this.makeFighters();
		System.out.println("Avant le combat");
		this.displayFighters();
		this.duelFighters();
		System.out.println("Après le combat");
		this.displayFighters();
	}
	
	private void makeFighters() {
		FighterFactory fighterFactory = new FighterFactory();
		SkillFactory skillFactory = new SkillFactory();
		
		
		Skill giantCrossbow = skillFactory.getOffensiveSkill(20, SkillType.Crossbow);
		Skill giantSpell = skillFactory.getOffensiveSkill(20, SkillType.Spell);
		Bag giantBag = new FighterBag(giantCrossbow,giantSpell);
		Aptitudes giantApt = new Aptitudes(GIANT_APTITUDES,GIANT_APTITUDES,GIANT_APTITUDES,GIANT_APTITUDES);
		Fighter jean = fighterFactory.giveMeFighter(FighterType.Giant, "Jean", giantApt, giantBag);
		this.giant = jean;
		
		Skill wizardShield = skillFactory.getDefensiveSkill(20, SkillType.Shield);
		Skill wizardSpell = skillFactory.getOffensiveSkill(20, SkillType.Spell);
		Bag wizardBag = new FighterBag(wizardShield,wizardSpell);
		Aptitudes wizardApt = new Aptitudes(WIZARD_STRENGHT,WIZARD_DEXTERITY,WIZARD_FOCUS,WIZARD_INTELLIGENCE);
		Fighter claude = fighterFactory.giveMeFighter(FighterType.Wizard, "claude", wizardApt, wizardBag);
		this.wizard = claude;
		
		Skill warriorShield = skillFactory.getDefensiveSkill(20, SkillType.Shield);
		Skill warriorAegis = skillFactory.getDefensiveSkill(20, SkillType.Shield);
		Bag warriorBag = new FighterBag(wizardShield,wizardSpell);
		Aptitudes warriorApt = new Aptitudes(WARRIOR_STRENGHT,WARRIOR_DEXTERITY,WARRIOR_FOCUS,WARRIOR_INTELLIGENCE);
		Fighter viateur = fighterFactory.giveMeFighter(FighterType.Warrior, "viateur", warriorApt, warriorBag);
		this.warrior = viateur;
	}
	
	private void duelFighters() {
		Duel firstDuel = new Duel(this.giant,this.wizard);
		try {
			Duel secondDuel = new Duel(this.giant,this.warrior);
		} 
		catch (AttackerHasSurrenderedException ex) {
			
		}
	}
	
	private void displayFighters() {
		System.out.println(this.giant.toString());
		System.out.println(this.wizard.toString());
		System.out.println(this.warrior.toString());
		System.out.println();
	}
}
