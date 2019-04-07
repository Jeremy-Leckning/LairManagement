/**
 * @author Jeremy
 *
 */

public class Support_staff extends Minion {

	public Support_staff(String newMinionId, String newGivenName, String newFamilyName) {
		super(newMinionId, newGivenName, newFamilyName);
	}

	public Support_staff(String newMinionId) {
		super(newMinionId);
	}
	
	int monthlyPay() {
		return 3000 + SkillsCollection.size() * 500;
	}

}
