import java.util.HashMap;

/**
 * @author Jeremy
 *
 */


public class LairLocation {
	private String name;
	private String description;
	private Team minions;
	// Used HashMap as it is the most efficient and order of elements does not matter here.
	private HashMap<MinionSkill, Integer> neededSkill = new HashMap<MinionSkill, Integer>();
	
	public LairLocation(String newName, String newDescription, HashMap<MinionSkill, Integer>hash_map) {
		name = newName;
		description = newDescription;
		neededSkill.putAll(hash_map);
	}
	
	public String description() {
		return (name + ": " + description);
	}
	
	public void assignTeam(Team team) {
		minions = team;
	}
	
	public String getMinions() {
		String minionString = "";
		for (int i = 0; i < minions.minionList().size(); i++) {
			if (i < minions.minionList().size()-1){
			minionString += minions.minionList().get(i).description() + "\n";
			}
			else {
				minionString += minions.minionList().get(i).description();
			}
		}
		return minionString;
	}
	
	public int payRoll() {
		int total_pay = 0;
		for (int i = 0; i < minions.minionList().size(); i++) {
			total_pay += minions.minionList().get(i).monthlyPay();
		}
		return total_pay;
	}

}
