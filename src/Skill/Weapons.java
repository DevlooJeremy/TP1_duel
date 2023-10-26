package Skill;

import duel.Fighter;

public abstract class Weapons implements Skill{
	
		public static final int MINIMUM_STAT = 20;
		public static final int MAXIMUM_STAT = 50;
	
		private boolean isSkillOffensive;
		private boolean isSkillDefensive;

		public Weapons(boolean isSkillOffensive, boolean isSkillDefensive) 
		{
			this.isSkillOffensive = isSkillOffensive;
			this.isSkillDefensive = isSkillDefensive;
		}
		
		public boolean isOffensiveSkill() 
		{
			return this.isSkillOffensive;
		}
		
		public boolean isDefensiveSkill()
		{
			return this.isSkillDefensive;
		}
}
