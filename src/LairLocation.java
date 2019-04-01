/**
 * @author Jeremy
 *
 */
import java.util.ArrayList;

public class LairLocation {
	private String name;
	private String description;
	private ArrayList<Minion> minions = new ArrayList<Minion>(); 
	
	public LairLocation(String newName, String newDescription) {
		name = newName;
		description = newDescription;
	}
	
	public String description() {
		return (name + ": " + description);
	}
	
	public void assignMinion(Minion minion) {
		minions.add(minion);
	}
	
	public String getMinions() {
		String minionString = "";
		for (int i = 0; i < minions.size(); i++) {
			if (i < minions.size()-1){
			minionString += minions.get(i).description() + "\n";
			}
			else {
				minionString += minions.get(i).description();
			}
		}
		return minionString;
	}
	
	public int payRoll() {
		int total_pay = 0;
		for (int i = 0; i < minions.size(); i++) {
			total_pay += minions.get(i).monthlyPay();
		}
		return total_pay;
	}

}
