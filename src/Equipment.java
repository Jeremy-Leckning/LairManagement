

public class Equipment extends Item {

	/**
	 * @param newName
	 * @param newDescription
	 * @param skillList
	 */
	public Equipment(String newName, String newDescription) {
		super(newName, newDescription);
	}
	
	public Equipment(String newName, String newDescription, MinionSkill skill) {
		super(newName, newDescription);
		requiredSkill.add(skill);
	}
	
	public void move(Equipment equipment, LairLocation oldLocation, LairLocation newLocation) {
		
	}
	
	public void disable() {
	}
}
