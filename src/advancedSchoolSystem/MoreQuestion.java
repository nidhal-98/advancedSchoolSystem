package advancedSchoolSystem;

public class MoreQuestion {
	boolean showQuestion(String txt) {
		boolean loop = true;
		while (true) {
			System.out.println(txt);
			String subSelect1 = Main.hold.next();
			if (subSelect1.equalsIgnoreCase("Y") || subSelect1.equalsIgnoreCase("Yes")) {
				loop = true;
				break;
			} else if (subSelect1.equalsIgnoreCase("N") || subSelect1.equalsIgnoreCase("No")) {
				loop = false;
				break;
			} else {
				System.out.println("Invalid Input");
			}
		}
		return loop;
	}
}
