package advancedSchoolSystem;

public class Mail {
	
	public static void addMail() {
		
		while (true) {
			if (Main.newSchool.studentList.size() == 0) {
				System.out.println("There is no student!");
				break;
			} else {
				for (int i = 0; i < Main.newSchool.studentList.size(); i++) {
					System.out.println("[" + (i + 1) + "] " + Main.newSchool.studentList.get(i).name);
				}
				System.out.println("Enter Number of Student");
				String studentEntery = Main.hold.next();
				try {
					Integer studentNum = Integer.parseInt(studentEntery);
					if (studentNum < 1 || studentNum > Main.newSchool.studentList.size()) {
						System.out.println("This number is not included in the student list");
					} else {
						System.out.println("Enter Email");
						String email = Main.hold.next();
						Main.newSchool.studentList.get(studentNum - 1).emailList.add(email);
						break;
					}
				} catch (NumberFormatException ex) {
					System.out.println("Invalid Input");
				}
			}
		}
	}
}