import java.util.ArrayList;

/**
 * @author Jeremy
 *
 */
public class Team {
	private ArrayList<Minion> minions = new ArrayList<Minion>(); 
	
	public Team() {
	}
	
	public void addMinion(Minion newMinion) {
		minions.add(newMinion);
	}
	
	public void removeMinion(Minion minion) {
		minions.remove(minion);
	}
	
	public ArrayList<Minion> minionList() {
		return minions;
	}
	
	public int numberSkill(MinionSkill skill) {
		int count = 0;
		for (int i = 0; i < minions.size(); i++) {
			if (minions.get(i).hasSkill(skill)){
				count++;
			}
		}
		return count;
	}
}
