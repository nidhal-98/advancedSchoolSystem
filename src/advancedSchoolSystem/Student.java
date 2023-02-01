package advancedSchoolSystem;

import java.util.ArrayList;
import java.util.HashSet;

public class Student {
	public String name;
	ArrayList<Subject> studentSubjectList = new ArrayList<Subject>();
	HashSet<String> emailList = new HashSet<String>();
	
	public static void addStudent() {
		
		while (true) { // Second While
			System.out.println("Enter Student Name:");
			String studentName = Main.hold.next();
			boolean studentExists = false;
			for (int i = 0; i < Main.newSchool.studentList.size(); i++) {
				if (studentName.equalsIgnoreCase(Main.newSchool.studentList.get(i).name)) {
					System.out.println("This Student is added");
					studentExists = true;
				}
			}
			if (studentExists == false) {
				Student newStudent = new Student();
				newStudent.name = studentName;
				Main.newSchool.studentList.add(newStudent);
				// Stack History
				Main.historyStack.push(studentName);
				System.out.println("Do you want to add more student?");
				String subSelect = Main.hold.next();
				if (subSelect.equals("Y") || subSelect.equals("y") || subSelect.equals("Yes")
						|| subSelect.equals("yes")) {
				} else if (subSelect.equals("N") || subSelect.equals("n") || subSelect.equals("No")
						|| subSelect.equals("no")) {
					break;
				} else {
					System.out.println("Invalid Input");
					break;
				}
			}
		}
		//////// Update studentList with Subject ////////////////////////////////
		for (int i = 0; i < Main.newSchool.studentList.size(); i++) {
			for (int j = 0; j < Main.newSchool.subjectList.size(); j++) {
				Subject newSubject = new Subject();
				newSubject.name = Main.newSchool.subjectList.get(j);
				Main.newSchool.studentList.get(i).studentSubjectList.add(newSubject);
			}
		}
	}
}
