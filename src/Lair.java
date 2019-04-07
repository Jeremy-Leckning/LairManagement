/**
 * @author Jeremy
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Lair {
	private LairLocation[] LairLocations;
	
	public void printStatus() {
		System.out.println("Welcome to the Supervillain's Lair Management System.");
		System.out.println("");
		createLocation();
		createMinions();
		displayLocation();
		System.out.println("Good-Bye. Thank you for using the Supervillain's Lair Management System.");
	}
	
	public void createLocation() {
		LairLocations = new LairLocation[4];
		LairLocations[0] = new LairLocation("Lava pits", "Full of lava.");
		LairLocations[1] = new LairLocation("SuperComputer Rooms", "Full of superComputers.");
		LairLocations[2] = new LairLocation("Dark Room", "Full with evil minions.");
		LairLocations[3] = new LairLocation("Boardroom", "Where we plot world domination.");
	}
	
	public void displayLocation() {
		for (int i = 0; i < LairLocations.length; i++) {
			System.out.println(LairLocations[i].description());
			System.out.println("Assigned Minions:");
			System.out.println(LairLocations[i].getMinions());
			System.out.println("Total payroll: $" + LairLocations[i].payRoll() + "\n");
		}
	}
	
	public void createMinions() {
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
	
//		// $3500
		minion4.addSkill(MinionSkill.ESPIONAGE);
		
		Team team1 = new Team();
		Team team2 = new Team();
		Team team3 = new Team();
		Team team4 = new Team();
		
		team1.addMinion(minion1);
		team1.addMinion(minion3);
		team2.addMinion(minion1);
		team3.addMinion(minion2);
		team3.addMinion(minion4);
		team4.addMinion(minion3);
		team4.addMinion(minion4);
		
		LairLocations[0].assignTeam(team1);
		LairLocations[1].assignTeam(team2);
		LairLocations[2].assignTeam(team3);
		LairLocations[3].assignTeam(team4);
	}
	
	
	private String readString(String prompt) {
		System.out.print(prompt);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try {
			s = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
		}
	}
