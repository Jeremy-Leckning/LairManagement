/**
 * @author Jeremy
 *
 */

public class Researcher extends Minion {

	public Researcher(String newMinionId, String newGivenName, String newFamilyName) {
		super(newMinionId, newGivenName, newFamilyName);
	}

	public Researcher(String newMinionId) {
		super(newMinionId);
	}
	
	public int monthlyPay() {
		/**
		 * Calculates the monthly pay of the minion
		 * @return: Monthly Pay
		 */
		if (SkillsCollection.size() >= 3){
			return 10000;
		}
		else {
			return 5000;
		}
	}

}
