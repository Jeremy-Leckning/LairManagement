/**
 * @author Jeremy
 *
 */
import java.util.*;

public abstract class Minion {
	protected String minionId;
	protected String givenName;
	protected String familyName;
	protected Collection<MinionSkill> SkillsCollection = new HashSet<MinionSkill>();

	public Minion(String newMinionId){
		if (newMinionId.length() != 7) {
			throw new IllegalArgumentException("ID must contain 7 characters");
		}
		
		 if (!Character.isLetter(newMinionId.charAt(0)) )  {
			 throw new IllegalArgumentException("First Character must be a letter between A-Z");
		 }
		
		for (int i = 1; i < newMinionId.length(); i++) {
			if (!Character.isDigit(newMinionId.charAt(i))) {
				throw new IllegalArgumentException("Characters from index 1 to 6 must be integers");
			}
		}
		
		minionId = newMinionId;
	}
	
	public Minion(String newMinionId, String newGivenName, String newFamilyName){
		if (newMinionId.length() != 7) {
			throw new IllegalArgumentException("ID must contain 7 characters");
		}
		
		 if (!Character.isLetter(newMinionId.charAt(0)) )  {
			 throw new IllegalArgumentException("First Character must be a letter between A-Z");
		 }
		
		for (int i = 1; i < newMinionId.length(); i++) {
			if (!Character.isDigit(newMinionId.charAt(i))) {
				throw new IllegalArgumentException("Characters from index 1 to 6 must be integers");
			}
		}
		
		minionId = newMinionId;
		givenName = newGivenName;
		familyName = newFamilyName;
	}
	
	public void setGivenName(String newGivenName) {
		givenName = newGivenName;
	}
	
	public void setFamilyName(String newFamilyName) {
		familyName = newFamilyName;
	}
	
	public String description() {
		return(minionId + " " + givenName + " " + familyName);
	}
	
	public void addSkill(MinionSkill skill) {
		SkillsCollection.add(skill);
	}
	
	public boolean hasSkill(MinionSkill skill) {
		return SkillsCollection.contains(skill);
	}
	
	abstract int monthlyPay();
}
