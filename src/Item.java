import java.util.ArrayList;

public abstract class Item {
	protected String description;
	protected String name;
	protected ArrayList<MinionSkill> requiredSkill = new ArrayList<MinionSkill>();
	
	public Item(String newName, String newDescription) {
		name = newName;
		description = newDescription;
	}
	
	public Item(String newName,String newDescription, MinionSkill[] skillList){
		name = newName;
		description = newDescription;
		for (int i = 0; i < skillList.length; i++) {
			requiredSkill.add(skillList[i]);
		}
	}
	
	public String description() {
		return (" " + name + ": " + description);
	}
	
	public void addSkill(MinionSkill newSkill) {
		requiredSkill.add(newSkill);
	}
	
	public ArrayList<MinionSkill> getSkills() {
		return requiredSkill;
	}

	protected abstract void disable();
}
