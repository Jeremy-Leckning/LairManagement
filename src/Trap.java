

public class Trap extends Item {
	
	private boolean status;
	
	public Trap(String newName, String newDescription, MinionSkill[] skillList) {
		super(newName, newDescription, skillList);
		if (skillList.length < 2 ) {
			throw new Error("Traps require at least 2 skills to be used");
		}
		status = true; // By convention trap is always enabled
	}
	
	public void disable() {
		status = false;
	}
	
	public void enable() {
		status = true;
	}
	
	public String description() {
		String tempDescription = description;
		if (status == false) {
			tempDescription = description + "(disabled)";
		}
		return " " + name + ": " + tempDescription;
	}
}
