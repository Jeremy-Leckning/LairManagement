/**
 * @author Jeremy
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Lair {
	private LairLocation[] LairLocations;
	private Team[] teams;
	protected ArrayList<Minion> minions = new ArrayList<Minion>();

	
	public void printStatus() {
		/**
		 * Prints the main window and create the instance locations and minions
		 * @return None
		 */
		System.out.println("Welcome to the Supervillain's Lair Management System.");
		System.out.println("");
		createLocation();
		createMinions();
		createItems();
		displayLocation();
		changeMinion(minions.get(0), MinionSkill.SCUBA, teams);
//		System.out.println("--------------------------------------------------");
//		displayLocation();
//		System.out.println("--------------------------------------------------");
		System.out.println("Good-Bye. Thank you for using the Supervillain's Lair Management System.");
	}
	
	public void createLocation() {
		HashMap<MinionSkill, Integer> hash_map_team = new HashMap<MinionSkill, Integer>();
		hash_map_team.put(MinionSkill.SCUBA, 2);
		hash_map_team.put(MinionSkill.ESPIONAGE, 1);
		
		LairLocations = new LairLocation[4];
		LairLocations[0] = new LairLocation("Lava pits", "Full of lava.", hash_map_team);
		LairLocations[1] = new LairLocation("SuperComputer Rooms", "Full of superComputers.", hash_map_team);
		LairLocations[2] = new LairLocation("Dark Room", "Full with evil minions.", hash_map_team);
		LairLocations[3] = new LairLocation("Boardroom", "Where we plot world domination.", hash_map_team);
	}
	
	public void displayLocation() {
		/**
		 * Displays Location descriptions along with the assigned minions
		 * @return: None
		 */
		for (int i = 0; i < LairLocations.length; i++) {
			System.out.println(LairLocations[i].description());
			System.out.println("Assigned Minions:");
			System.out.println(LairLocations[i].getMinions());
			System.out.println("Total payroll: $" + LairLocations[i].payRoll() + "\n");
		}
	}
	
	public void createMinions() {
		/**
		 * Creates team of minions with their skills and assigns them to locations
		 * @return: None
		 */
		
//		Researcher minion1 = new Researcher(readString("ID: "));
//		minion1.setGivenName(readString("givenName: "));
//		minion1.setFamilyName(readString("FamilyName: "));
//		System.out.println("");
//		Researcher minion2 = new Researcher(readString("ID: "), readString("givenName: "), readString("FamilyName: "));
//		System.out.println("");
//		Support_staff minion3 = new Support_staff(readString("ID: "), readString("givenName: "), readString("FamilyName: "));
//		System.out.println("");
//		Support_staff minion4 = new Support_staff(readString("ID: "), readString("givenName: "), readString("FamilyName: "));
//		System.out.println("");
		
		Minion minion1 = new Researcher("A123456");
		minion1.setGivenName("Mini");
		minion1.setFamilyName("Me");
		Minion minion2 = new Researcher("B789456", "Donna", "Matrix");
		Minion minion3 = new Support_staff("C789123", "Pyne", "Okleen");
		Minion minion4 = new Support_staff("D874563", "Domestos", "McBleach");
		
		minions.add(minion1);
		minions.add(minion2);
		minions.add(minion3);
		minions.add(minion4);
		
		
		// $10000
		minion1.addSkill(MinionSkill.PSYCHOLOGY);	
		minion1.addSkill(MinionSkill.ESPIONAGE);
		minion1.addSkill(MinionSkill.SCUBA);
		
		// $5000
		minion2.addSkill(MinionSkill.CRYPTOGRAPHY);
		minion2.addSkill(MinionSkill.PSYCHIATRY);
		
//		// $5000
		minion3.addSkill(MinionSkill.PSYCHOLOGY);	
		minion3.addSkill(MinionSkill.ESPIONAGE);
		minion3.addSkill(MinionSkill.ROCKETRY);
		minion3.addSkill(MinionSkill.PSYCHIATRY);
		minion3.addSkill(MinionSkill.SCUBA);
	
//		// $4000
		minion4.addSkill(MinionSkill.ESPIONAGE);
		minion4.addSkill(MinionSkill.SCUBA);
		
		teams = new Team[4];
		teams[0] = new Team();
		teams[1] = new Team();
		teams[2] = new Team();
		teams[3] = new Team();
		
		teams[0].addMinion(minion1);
		teams[0].addMinion(minion3);
		teams[1].addMinion(minion3);
		teams[1].addMinion(minion4);
		teams[2].addMinion(minion4);
		teams[2].addMinion(minion2);
		teams[2].addMinion(minion3);
		teams[3].addMinion(minion3);
		teams[3].addMinion(minion4);
		
		LairLocations[0].assignTeam(teams[0]);
		LairLocations[1].assignTeam(teams[1]);
		LairLocations[2].assignTeam(teams[2]);
		LairLocations[3].assignTeam(teams[3]);
		

	}
	
	public void createItems() {
		Warehouse warehouse = new Warehouse();
		
		MinionSkill[] skills1 = {MinionSkill.SCUBA, MinionSkill.ESPIONAGE};
		Trap trap1 = new Trap("Shark Tank", "Full of sharks", skills1);
		warehouse.addItem(trap1);
		trap1.disable();
		trap1.enable();
		
		MinionSkill[] skills2 = {MinionSkill.SCUBA, MinionSkill.ESPIONAGE};
		Trap trap2 = new Trap("Laser", "It burns", skills2);
		warehouse.addItem(trap2);
		
		Equipment equipment1 = new Equipment("Mind control ray", "Controls the mind of anyone", MinionSkill.PSYCHOLOGY);
		warehouse.addItem(equipment1);
		
		Equipment equipment2 = new Equipment("Torch", "Enables us to see in the dark", MinionSkill.CRYPTOGRAPHY);
		warehouse.addItem(equipment2);
		
		warehouse.moveItem(trap1, LairLocations[0]);
		warehouse.moveItem(trap2, LairLocations[0]);
		warehouse.moveItem(equipment1, LairLocations[3]);
		warehouse.moveItem(equipment2, LairLocations[2]);
//		LairLocations[3].moveLocation(equipment1, LairLocations[2]); // Testing moving equipment from one location to another
//		LairLocations[0].moveLocation(trap1, LairLocations[1]); // Should throw an error because can't move trap from one location to another
	}
	
	public void changeMinion(Minion minion, MinionSkill skill, Team[] teams) {
		minion.removeSkill(skill);
		for (int i = 0; i < teams.length; i++) {
			if (teams[i].minionList().contains(minion)){
				for (int j=0; j < LairLocations.length; j++) {
					if (LairLocations[j].getTeam() == teams[i]) {
						if (!LairLocations[j].isValidTeam(teams[i])) {
							LairLocations[j].clearTeam();
						}	
					}
				}
			}
		}
	}
	
//	private String readString(String prompt) {
//		/**
//		 * Input Read string
//		 */
//		System.out.print(prompt);
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		String s = null;
//		try {
//			s = in.readLine();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return s;
//		}
	}
