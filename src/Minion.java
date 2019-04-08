/**
 * @author Jeremy
 *
 */
import java.util.*;

public abstract class Minion {
	/**
	 * Abstract Minion class parent of Researcher and Support_staff classes
	 */
	protected String minionId;
	protected String givenName;
	protected String familyName;
	protected Collection<MinionSkill> SkillsCollection = new HashSet<MinionSkill>();

	public Minion(String newMinionId){
		/**
		 * Minion constructor
		 * @param newMinionId: The id of the minion which will be initialised
		 * The ID is checked according to the following criterias; must have 7 characters, the first character a letter and the others digits.
		 * E.g A123456
		 * @return: None
		 */
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
		/**
		 * Minion constructor
		 * @param newMinionId: The id of the minion which will be initialised
		 * The ID is checked according to the following criterias; must have 7 characters, the first character a letter and the others digits.
		 * E.g A123456
		 * @param newGivenName: The GivenName of the minion to be initialised
		 * @param newFamilyName: The FamilyName of the minion to be initialised
		 * @return: None
		 */
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
		/**
		 * Mutator to set the private attribute givenName a new value
		 * @param newGivenName: The new value of the private attribute givenName
		 * @return None
		 */
		givenName = newGivenName;
	}
	
	public void setFamilyName(String newFamilyName) {
		/**
		 * Mutator to set the private attribute familyName a new value
		 * @param newFamilyName: The new value of the private attribute FammilyName
		 * @return None
		 */
		familyName = newFamilyName;
	}
	
	public String description() {
		/**
		 * Returns a string description of minion containing ID, givenName and FamilyName
		 * @return: String description of minion
		 */
		return(minionId + " " + givenName + " " + familyName);
	}
	
	public void addSkill(MinionSkill skill) {
		/**
		 * Adds an object MinionSkill to the HashSet SkillsCollection
		 * @param skill: Skill to be added to collection
		 * @return: None
		 */
		SkillsCollection.add(skill);
	}
	
	public boolean hasSkill(MinionSkill skill) {
		/**
		 * Checks whether a skill is present in the HashSet SkillsCollection
		 * @param skill: Skill to be checked
		 * @return: True if skill present, false otherwise
		 */
		return SkillsCollection.contains(skill);
	}
	
	abstract int monthlyPay();
	/**
	 * abstract method which is defined in the child classes
	 */
}
