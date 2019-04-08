import java.util.ArrayList;

/**
 * @author Jeremy
 *
 */
public class Team {
	/**
	 * Team class which contains a collection of Minion objects
	 */
	private ArrayList<Minion> minions = new ArrayList<Minion>(); 
	
	public Team() {
	}
	
	public void addMinion(Minion newMinion) {
		/**
		 * Adds a minion to the collection
		 * @param newMinion: minion to be added
		 * @return: None
		 */
		minions.add(newMinion);
	}
	
	public void removeMinion(Minion minion) {
		/**
		 * Removes a minion from the collection
		 * @param minion: minion to be removed
		 * @return: None
		 */
		minions.remove(minion);
	}
	
	public ArrayList<Minion> minionList() {
		/**
		 * Returns the list of minions in the team
		 * @return: List of minions
		 */
		return minions;
	}
	
	public int numberSkill(MinionSkill skill) {
		/**
		 * Returns the number of minions having a particular skill in the team
		 * @param skill: skill that is being checked for
		 * @return: count of minions having the skill
		 */
		int count = 0;
		for (int i = 0; i < minions.size(); i++) {
			if (minions.get(i).hasSkill(skill)){
				count++;
			}
		}
		return count;
	}
}
