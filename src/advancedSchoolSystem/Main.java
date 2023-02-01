package advancedSchoolSystem;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner hold = new Scanner(System.in);
	static School newSchool = new School();
	static Stack<String> historyStack = new Stack<String>();
	static MoreQuestion ask = new MoreQuestion();
	
	static int mainMenuCount = 0;
	static int setupCount = 0;
	static int schoolNameCount = 0;
	static int enterSubjectCount = 0;
	static int enterStudentCount = 0;
	static int enterGradesCount = 0;
	static int printCount = 0;
	static int searchCount = 0;
	static int appStatisticsCount = 0;
	static int highestGradeCount = 0;
	static int deleteStudentCount = 0;
	static int enterMailCount = 0;
	static int history = 0;

	public static void main(String[] args) throws Throwable {
		
		
		newSchool.name = "Not Entered";

		while (true) { // First While
			mainMenuCount = mainMenuCount + 1;
			Menu mainMenu = new Menu();
			mainMenu.showMenu();
			String select = hold.next();

			// Store School Name
			if (select.equals("1")) {
				setupCount = setupCount + 1;
				while (true) { // Second While
					mainMenu.showSubMenu();
					String option = hold.next();

					if (option.equals("1")) {
						schoolNameCount = schoolNameCount + 1;
						School.nameSchool();
					}
					// Add Subjects
					else if (option.equals("2")) {
						enterSubjectCount = enterSubjectCount + 1;
						Subject.addSubject();
						
					} else if (option.equals("3")) {
						// Main Menu
						break;
					} else {
						System.out.println("Invalid Input");
						break;
					}
				}
			}

			// Add Students
			else if (select.equals("2")) {
				enterStudentCount = enterStudentCount + 1;
				Student.addStudent();
			}

			// Add Marks
			else if (select.equals("3")) {
				enterGradesCount = enterGradesCount + 1;
				Mark.addMark();
			}

			// Enter Email
			else if (select.equals("4")) {
				enterMailCount = enterMailCount + 1;
				Mail.addMail();
			}

			// Print Transcript
			else if (select.equals("5")) {
				printCount = printCount + 1;
				Printing.printTranscript();
			}   
			
			// Search student 
			else if (select.equals("6")) {
				searchCount = searchCount + 1;
				Printing.searchStudent();
			}

			// App Statistics
			else if (select.equals("7")) {
				appStatisticsCount = appStatisticsCount + 1;
				Printing.AppStatistics();
			}

			// Highest Grade
			else if (select.equals("8")) {
				highestGradeCount = highestGradeCount + 1;
				Printing.showHighest();
			}

			// Delete Student
			else if (select.equals("9")) {
				deleteStudentCount = deleteStudentCount + 1;
				Printing.deleteStudent();;
			}
			// History
			else if (select.equals("10")) {
				history = history + 1;
				Printing.showHistory();
			}

			// Exite
			else if (select.equals("11")) {
				System.out.println("GOOD BYE");
				break;
			}

			else {
				System.out.println("Invalid Input");
			}
		}

		Fainalize fainalize1 = new Fainalize();
		fainalize1.finalize();
	}
}