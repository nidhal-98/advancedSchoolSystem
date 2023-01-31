package advancedSchoolSystem;

public class Menu {
	void showMenu() {
		System.out.println(" -----------");
		System.out.println("| Main Menu |");
		System.out.println(" -----------");
		System.out.println("[1] Setup School Details");
		System.out.println("[2] Enter Student Name");
		System.out.println("[3] Enter Grades");
		System.out.println("[4] Enter Student Mail");
		System.out.println("[5] Print All / Transcript");
		System.out.println("[6] Search Students");
		System.out.println("[7] App Statistics");
		System.out.println("[8] Highest Grade for Student");
		System.out.println("[9] Delete Student");
		System.out.println("[10] History of students");
		System.out.println("[11] Exit");
	}

	void showSubMenu() {
		System.out.println(" ---------- ");
		System.out.println("| Sub Menu |");
		System.out.println(" ---------- ");
		System.out.println("[1] Enter School Name");
		System.out.println("[2] Enter Subject");
		System.out.println("[3] Go Back");
	}
}
