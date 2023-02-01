package advancedSchoolSystem;

import java.util.ArrayList;

public class School {
	public String name;
	ArrayList<String> subjectList = new ArrayList<String>();
	ArrayList<Student> studentList = new ArrayList<Student>();
	
	public static void nameSchool () {
		System.out.println("Enter School Name:");
		String schoolName = Main.hold.next();
		Main.newSchool.name = schoolName;
	}
}
