package Skill;
import duel.Fighter;

public interface Skill {

	public int getPower(Fighter fighter);
	public boolean isOffensiveSkill();
	public boolean isDefensiveSkill();
}
