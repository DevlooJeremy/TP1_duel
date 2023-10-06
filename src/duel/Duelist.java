package duel;

import Skill.Skill;

public interface Duelist {
	
	/**
	 * Méthode spécifiant si un duelliste est vivant.
	 * @return booléen indiquant si le duelliste est vivant
	 */
	public boolean isAlive();

	/**
	 * Méthode appelée lors du duel afin de déployer une puissance d'attaque.
	 * @return un entier représentant la puissance de l'attaque
	 */
	public int attack();
	
	/**
	 * Méthode appelée lors du duel afin de déployer une puissance de contre-attaque.
	 * @return un entier représentant la puissance de la contre-attaque
	 */
	public int counterAttack();

	/**
	 * Méthode appelée sur le duelliste gagnant afin de lui donner une récompense.
	 * @param rewardPointsNumber : le nombre de points ajoutés en récompense
	 * @param prizeForWinner : la capacité (Skill) reçue en récompense
	 */
	public void reward(int rewardPointsNumber, Skill prizeForWinner);

	/**
	 * Méthode appelée sur le duelliste perdant afin de lui donner une pénalité.
	 * @param penalityPointsNumber : le nombre de points déduits à titre de pénalité
	 * @param healthPoints : le nombre de points de vie perdus par le duelliste
	 */
	public void penalize(int penalityPointsNumber, int healthPoints);
}
