package advancedSchoolSystem;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Printing {
	
///////////////////////////////// Transcript /////////////////////////////////
	public static void printTranscript() {
		
		boolean loop = true;
		while (loop) {
			if (Main.newSchool.studentList.size() == 0) {
				System.out.println("There is no student");
				loop = false;
			} else if (Main.newSchool.subjectList.size() == 0) {
				System.out.println("There is no subject");
				loop = false;
			} else {
				LocalDateTime now = LocalDateTime.now();
			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			    String formatDateTime = now.format(formatter);
				System.out.println("[1] Show Transcript");
				System.out.println("[2] Download Transcript");
				System.out.println("[3] Download Transcript in New Folder");
				System.out.println("[4] Serialize and Deserialize");
				System.out.println("[5] Go Back");
				String choose = Main.hold.next();
				try {
					int choose1 = Integer.parseInt(choose);
					///////////////////////////////// Show Transcript /////////////////////////////////
					if (choose1 == 1) {
						System.out.println(formatDateTime);
						System.out.println(
								"===================================================================================================================================");
						System.out.printf("%20s %20s %30s %20s %20s\n", "School Name", "Student Name",
								"Student Email", "Subject", "Mark");
						System.out.println(
								"===================================================================================================================================");
						for (int i = 0; i < Main.newSchool.studentList.size(); i++) {
							for (int j = 0; j < Main.newSchool.subjectList.size(); j++) {
								System.out.printf("%20s %20s %30s %20s %20s\n", Main.newSchool.name,
										Main.newSchool.studentList.get(i).name,
										Main.newSchool.studentList.get(i).emailList, Main.newSchool.subjectList.get(j),
										Main.newSchool.studentList.get(i).studentSubjectList
												.get(j).studentMark.mark);
							}
							System.out.println(
									"-----------------------------------------------------------------------------------------------------------------------------------");
						}
						
					}
					///////////////////////////////// Download Transcript in Project File /////////////////////////////////
					else if (choose1 == 2) {
						try {
							FileWriter writer = new FileWriter("schoolSystem.txt", true);
							writer.write(formatDateTime);
							writer.write(
									"\n===================================================================================================================================\n");
							writer.write(String.format("%20s %20s %30s %20s %20s\n", "School Name",
									"Student Name", "Student Email", "Subject", "Mark"));
							writer.write(
									"===================================================================================================================================\n");
							for (int i = 0; i < Main.newSchool.studentList.size(); i++) {
								for (int j = 0; j < Main.newSchool.subjectList.size(); j++) {
									writer.write(String.format("%20s %20s %30s %20s %20s\n", Main.newSchool.name,
											Main.newSchool.studentList.get(i).name,
											Main.newSchool.studentList.get(i).emailList,
											Main.newSchool.subjectList.get(j),
											Main.newSchool.studentList.get(i).studentSubjectList
													.get(j).studentMark.mark));
								}
								writer.write(
										"-----------------------------------------------------------------------------------------------------------------------------------\n");
							}
							writer.close();
							System.out.println("Successfully wrote to the file.");
						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					}
					///////////////////////////////// Download Transcript in New Folder /////////////////////////////////
					else if (choose1 == 3) {
						File folder = new File("C:\\Users\\Lenovo\\Documents\\Transcript");
						if (!folder.exists()) {
							folder.mkdir();
						}

						File file = new File("C:\\Users\\Lenovo\\Documents\\Transcript\\schoolSystem.txt");
						try {
							FileWriter writer = new FileWriter(file, true);
							writer.write(formatDateTime);
							writer.write(
									"\n===================================================================================================================================\n");
							writer.write(String.format("%20s %20s %30s %20s %20s\n", "School Name",
									"Student Name", "Student Email", "Subject", "Mark"));
							writer.write(
									"===================================================================================================================================\n");
							for (int i = 0; i < Main.newSchool.studentList.size(); i++) {
								for (int j = 0; j < Main.newSchool.subjectList.size(); j++) {
									writer.write(String.format("%20s %20s %30s %20s %20s\n", Main.newSchool.name,
											Main.newSchool.studentList.get(i).name,
											Main.newSchool.studentList.get(i).emailList,
											Main.newSchool.subjectList.get(j),
											Main.newSchool.studentList.get(i).studentSubjectList
													.get(j).studentMark.mark));
								}
								writer.write(
										"-----------------------------------------------------------------------------------------------------------------------------------\n");
							}
							writer.close();
							System.out.println("Successfully downloaded to the file.");
						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					} 
					else if(choose1 == 4) {
						Serialize.main();
					}
					else if(choose1 == 5) {
						loop = false;
					}
					else {
						System.out.println("Invalid Input!!");
						loop = false;;
					}
				} catch (Exception e) {
					System.out.println("Invalid Input!");
					loop = false;
				}
			}
		}
	}
	
///////////////////////////////// Search Student /////////////////////////////////
	public static void searchStudent() {
		int sum = 0;
		boolean loop = true;
		while (loop) {
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Enter the name:");
			String searchedName = Main.hold.next();
			for (int i = 0; i < Main.newSchool.studentList.size(); i++) {
				if (Main.newSchool.studentList.get(i).name.equalsIgnoreCase(searchedName)) {
					System.out.println("School Name: " + Main.newSchool.name);
					System.out.println("Student Name: " + Main.newSchool.studentList.get(i).name);
					System.out.println("Student MAil: " + Main.newSchool.studentList.get(i).emailList);
					for (int j = 0; j < Main.newSchool.subjectList.size(); j++) {
						System.out.println(Main.newSchool.subjectList.get(j) + " mark is: "
								+ Main.newSchool.studentList.get(i).studentSubjectList.get(j).studentMark.mark);
					}
					sum = sum + 1;
				}
			}
			if (sum == 0) {
				System.out.println("Not Found!");
			}
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------");

			loop = Main.ask.showQuestion("Do you want to search for other students?");
		}
	}
	
///////////////////////////////// App Statistics /////////////////////////////////
	public static void AppStatistics() {
		System.out.println("       [1] Setup School Details ➤ ︎" + Main.setupCount);
		System.out.println("            [1] Enter School Name ➤ " + Main.schoolNameCount);
		System.out.println("            [2] Enter Subject ➤ " + Main.enterSubjectCount);
		System.out.println("       [2] Enter Student Name ➤ " + Main.enterStudentCount);
		System.out.println("       [3] Enter Grades ➤ " + Main.enterGradesCount);
		System.out.println("       [4] Enter Student Mail ➤ " + Main.enterMailCount);
		System.out.println("       [5] Print All / Transcript ➤ " + Main.printCount);
		System.out.println("       [6] Search Students ➤ " + Main.searchCount);
		System.out.println("       [7] App Statistics ➤ " + Main.appStatisticsCount);
		System.out.println("       [8] Highest Grade for Student ➤ " + Main.highestGradeCount);
		System.out.println("       [9] Delete Student ➤ " + Main.deleteStudentCount);
		System.out.println("       [10] History of students ➤ " + Main.history);
	}

///////////////////////////////// Show Highest /////////////////////////////////
	public static void showHighest() {
		double hieghest = 0;
		int sum = 0;
		String hieghestSubject = " ";
		System.out.println("Enter the name:     ");
		String studentName = Main.hold.next();
		boolean loop = true;
		while (loop) {
			for (int i = 0; i < Main.newSchool.studentList.size(); i++) {
				if (Main.newSchool.studentList.get(i).name.equalsIgnoreCase(studentName)) {
					for (int j = 0; j < Main.newSchool.subjectList.size(); j++) {
						if (Main.newSchool.studentList.get(i).studentSubjectList
								.get(j).studentMark.mark >= hieghest) {
							hieghest = Main.newSchool.studentList.get(i).studentSubjectList.get(j).studentMark.mark;
							hieghestSubject = Main.newSchool.studentList.get(i).studentSubjectList.get(j).name;
						}
					}
					sum = sum + 1;
				}
			}
			if (sum == 0) {
				System.out.println("Not Found!");
				loop = false;
			} else {
				System.out.println("Subject Name: " + hieghestSubject);
				System.out.println("Marks: " + hieghest);
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------");
				loop = false;
			}
		}
	}

///////////////////////////////// Delete Student /////////////////////////////////
 	public static void deleteStudent() {
		
		boolean loop = true;
		while (loop) {
			for (int i = 0; i < Main.newSchool.studentList.size(); i++) {
				System.out.println("[" + (i + 1) + "] " + Main.newSchool.studentList.get(i).name);
			}
			if (Main.newSchool.studentList.size() == 0) {
				System.out.println("There is no students!");
				loop = false;
			} else {
				System.out.println("Enter Student Number:");
				String studentEntery = Main.hold.next();
				try {
					Integer studentNum = Integer.parseInt(studentEntery);
					if (studentNum < 1 || studentNum > Main.newSchool.studentList.size()) {
						System.out.println("This number is not included in the student list");
					} else {
						Main.newSchool.studentList.remove(studentNum - 1);
						System.out.println("Do you want to delete other students?");
						String subSelect1 = Main.hold.next();
						if (subSelect1.equals("Y") || subSelect1.equals("y") || subSelect1.equals("Yes")
								|| subSelect1.equals("yes")) {
						} else if (subSelect1.equals("N") || subSelect1.equals("n") || subSelect1.equals("No")
								|| subSelect1.equals("no")) {
							loop = false;
						} else {
							System.out.println("Invalid Input");
						}
					}
				} catch (NumberFormatException ex) {
					System.out.println("Invalid Input");
					loop = false;
				}
			}
		}
	}
	
///////////////////////////////// Show History Names /////////////////////////////////
	public static void showHistory() {
		int count = 0;
		if (Main.historyStack.size() != 0) {
			while(Main.historyStack.size()!= 0 && count < 5) {
				System.out.println(Main.historyStack.pop());
				count ++;
			}
		} else {
			System.out.println("There is no student added recently");
		}
	}

}