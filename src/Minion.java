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
		minionId = newMinionId;
	}
	
	public Minion(String newMinionId, String newGivenName, String newFamilyName){
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
