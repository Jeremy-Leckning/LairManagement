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
		/**
		 * Returns a string description of minion containing name and location description
		 * @return: String description of LairLocation
		 */
		return (name + ": " + description);
	}
	
	public void assignTeam(Team team) {
		/**
		 * Assigns a team to a location
		 * @param team: team to be assigned
		 * @return: None
		 */
		if (!isValidTeam(team)){
			throw new Error("Invalid Team");
		}
		minions = team;
	}
	
	public String getMinions() {
		/**
		 * Returns a string of the minions present in that location along with their description
		 * @return: string of minions + description
		 */
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
		/**
		 * Calculates the total monthly pay of all minions in that location
		 * @return: The total monthly pay for that location
		 */
		int total_pay = 0;
		for (int i = 0; i < minions.minionList().size(); i++) {
			total_pay += minions.minionList().get(i).monthlyPay();
		}
		return total_pay;
	}

	public boolean isValidTeam(Team team) {
		/**
		 * Checks whether the team of minions is valid as specified per assignment sheet
		 * @param team: team to be checked
		 * @return: True if valid, false otherwise
		 */
		if (team.minionList().size() < 1){
			return false;
		}
		
		int numSupport = 0;
		int numResearcher = 0;
		for (int i = 0; i < team.minionList().size(); i++) {
			if (team.minionList().get(i) instanceof Researcher) {
				numResearcher++;
			}
			else if (team.minionList().get(i) instanceof Support_staff) {
				numSupport++;
			}
		}
		if (numResearcher > numSupport){
			return false;
		}
		
		int num = 0;
		for (MinionSkill skill : MinionSkill.values()) { 
			if (neededSkill.get(skill) != null) {
			    num = neededSkill.get(skill);
			    if (team.numberSkill(skill) < num) {
			    	return false;
			    }
			}
		}
		return true;	
	}
}
