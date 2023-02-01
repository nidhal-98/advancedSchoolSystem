package advancedSchoolSystem;

public class Subject {
	public String name;
	Mark studentMark = new Mark();
	
	public static void addSubject(){
		while (true) { // Third While
			System.out.println("Enter Subject Name:");
			String subjectName = Main.hold.next();
			boolean subjectExists = false;
			for (int i = 0; i < Main.newSchool.subjectList.size(); i++) {
				if (subjectName.equalsIgnoreCase(Main.newSchool.subjectList.get(i))) {
					System.out.println("This Subject is added");
					subjectExists = true;
				}

			}
			if (subjectExists == false) {
				Main.newSchool.subjectList.add(subjectName);
				//////// Update studentList with Subject ////////////////////////////////
				for (int i = 0; i < Main.newSchool.studentList.size(); i++) {
					Subject newSubject = new Subject();
					newSubject.name = subjectName;
					Main.newSchool.studentList.get(i).studentSubjectList.add(newSubject);
				}
				///////////////////////////////////////////////////////////////////////
				System.out.println("Do you want to add more subject?");
				String subSelect = Main.hold.next();
				if (subSelect.equals("Y") || subSelect.equals("y") || subSelect.equals("Yes")
						|| subSelect.equals("yes")) {
				} else if (subSelect.equals("N") || subSelect.equals("n") || subSelect.equals("No")
						|| subSelect.equals("no")) {
					// Sub Menu
					break;
				} else {
					System.out.println("Invalid Input");
					// Sub Menu
					break;
				}
			}

		}

	}
}
