package advancedSchoolSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner hold = new Scanner(System.in);

	public static void main(String[] args) throws Throwable {
		Stack<String> historyStack = new Stack<String>();
		School newSchool = new School();
		MoreQuestion ask = new MoreQuestion();
		int mainMenuCount = 0;
		int setupCount = 0;
		int schoolNameCount = 0;
		int enterSubjectCount = 0;
		int enterStudentCount = 0;
		int enterGradesCount = 0;
		int printCount = 0;
		int searchCount = 0;
		int appStatisticsCount = 0;
		int highestGradeCount = 0;
		int deleteStudentCount = 0;
		int enterMailCount = 0;
		int history = 0;
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
						System.out.println("Enter School Name:");
						String schoolName = hold.next();
						newSchool.name = schoolName;
					}
					// Add Subjects
					else if (option.equals("2")) {
						enterSubjectCount = enterSubjectCount + 1;

						while (true) { // Third While
							System.out.println("Enter Subject Name:");
							String subjectName = hold.next();
							boolean subjectExists = false;
							for (int i = 0; i < newSchool.subjectList.size(); i++) {
								if (subjectName.equalsIgnoreCase(newSchool.subjectList.get(i))) {
									System.out.println("This Subject is added");
									subjectExists = true;
								}

							}
							if (subjectExists == false) {
								newSchool.subjectList.add(subjectName);
								//////// Update studentList with Subject ////////////////////////////////
								for (int i = 0; i < newSchool.studentList.size(); i++) {
									Subject newSubject = new Subject();
									newSubject.name = subjectName;
									newSchool.studentList.get(i).studentSubjectList.add(newSubject);
								}
								///////////////////////////////////////////////////////////////////////
								System.out.println("Do you want to add more subject?");
								String subSelect = hold.next();
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

				while (true) { // Second While
					System.out.println("Enter Student Name:");
					String studentName = hold.next();
					boolean studentExists = false;
					for (int i = 0; i < newSchool.studentList.size(); i++) {
						if (studentName.equalsIgnoreCase(newSchool.studentList.get(i).name)) {
							System.out.println("This Student is added");
							studentExists = true;
						}

					}
					if (studentExists == false) {
						Student newStudent = new Student();
						newStudent.name = studentName;
						newSchool.studentList.add(newStudent);
						// Stack History
						historyStack.push(studentName);
						System.out.println("Do you want to add more student?");
						String subSelect = hold.next();
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
				for (int i = 0; i < newSchool.studentList.size(); i++) {
					for (int j = 0; j < newSchool.subjectList.size(); j++) {
						Subject newSubject = new Subject();
						newSubject.name = newSchool.subjectList.get(j);
						newSchool.studentList.get(i).studentSubjectList.add(newSubject);
					}
				}
			}

			// Add Marks
			else if (select.equals("3")) {
				enterGradesCount = enterGradesCount + 1;
				boolean loop = true;
				while (loop) {

					if (newSchool.studentList.size() == 0) {
						System.out.println("There is no student!");
						break;
					} else if (newSchool.subjectList.size() == 0) {
						System.out.println("There is no subject!");
						break;
					}
					// Print Students Names
					for (int i = 0; i < newSchool.studentList.size(); i++) {
						System.out.println("[" + (i + 1) + "] " + newSchool.studentList.get(i).name);
					}
					System.out.println("Enter Number of Student:");
					int studentNum;
					if (hold.hasNextInt()) {
						studentNum = hold.nextInt();
						if (studentNum < 1 || studentNum > newSchool.studentList.size()) {
							System.out.println("This number is not included in the student list");
						} else {
							boolean loop2 = true;
							while (loop2) {
								// Print Subjects
								for (int i = 0; i < newSchool.subjectList.size(); i++) {
									System.out.println("[" + (i + 1) + "] " + newSchool.subjectList.get(i));
								}
								System.out.println("Enter Number of Subject");
								String subjectEntery = hold.next();
								try {
									Integer subjectNum = Integer.parseInt(subjectEntery);

									if (subjectNum < 1 || subjectNum > newSchool.subjectList.size()) {
										System.out.println("This number is not included in the subject list");
										break;
									} else {
										// Print Enter Marks
										if (subjectNum < newSchool.subjectList.size() || subjectNum > 0) {
											System.out.println("Enter Marks:");
											String markEntery = hold.next();
											try {
												double studMark = Double.parseDouble(markEntery);
												if (studMark < 0 || studMark > 100) {
													System.out.println("You can not add " + studMark);
													break;
												} else {
													newSchool.studentList.get(studentNum - 1).studentSubjectList
															.get(subjectNum - 1).studentMark.mark = studMark;
													while (true) {
														System.out.println(
																"Do you want to add marks for other subjects?");
														String subSelect = hold.next();
														if (subSelect.equals("Y") || subSelect.equals("y")
																|| subSelect.equals("Yes") || subSelect.equals("yes")) {
															break;
														} else if (subSelect.equals("N") || subSelect.equals("n")
																|| subSelect.equals("No") || subSelect.equals("no")) {
															loop2 = false;
															while (true) {
																System.out.println(
																		"Do you want to enter marks for another student?");
																String subSelect1 = hold.next();
																if (subSelect1.equals("Y") || subSelect1.equals("y")
																		|| subSelect1.equals("Yes")
																		|| subSelect1.equals("yes")) {
																	break;
																} else if (subSelect1.equals("N")
																		|| subSelect1.equals("n")
																		|| subSelect1.equals("No")
																		|| subSelect1.equals("no")) {
																	loop = false;
																	break;
																} else {
																	System.out.println("Invalid Input");
																}
															}
															break;
														} else {
															System.out.println("Invalid Input");
														}
													}
												}
											} catch (NumberFormatException ex) {
												System.out.println("Invalid Input");
											}
										} else {
											System.out.println("Not Found!");
										}
									}
								} catch (NumberFormatException ex) {
									System.out.println("Invalid Input");
								}
							}
						}
					} else {
						System.out.println("Invalid Input");
						break;
					}
				}
			}

			// Enter Email
			else if (select.equals("4")) {
				enterMailCount = enterMailCount + 1;
				while (true) {
					if (newSchool.studentList.size() == 0) {
						System.out.println("There is no student!");
						break;
					} else {
						for (int i = 0; i < newSchool.studentList.size(); i++) {
							System.out.println("[" + (i + 1) + "] " + newSchool.studentList.get(i).name);
						}
						System.out.println("Enter Number of Student");
						String studentEntery = hold.next();
						try {
							Integer studentNum = Integer.parseInt(studentEntery);
							if (studentNum < 1 || studentNum > newSchool.studentList.size()) {
								System.out.println("This number is not included in the student list");
							} else {
								System.out.println("Enter Email");
								String email = hold.next();
								newSchool.studentList.get(studentNum - 1).emailList.add(email);
								break;
							}
						} catch (NumberFormatException ex) {
							System.out.println("Invalid Input");
						}
					}
				}
			}

			// Print Transcript
			else if (select.equals("5")) {
				printCount = printCount + 1;
				boolean loop = true;
				while (loop) {
					if (newSchool.studentList.size() == 0) {
						System.out.println("There is no student");
					} else if (newSchool.subjectList.size() == 0) {
						System.out.println("There is no subject");
					} else {
						System.out.println("[1] Show Transcript");
						System.out.println("[2] Download Transcript");
						System.out.println("[3] Download Transcript in New Folder");
						System.out.println("[4] Go Back");
						String choose = hold.next();
						try {
							int choose1 = Integer.parseInt(choose);
							if (choose1 == 1) {
								System.out.println(
										"===================================================================================================================================");
								System.out.printf("%20s %20s %30s %20s %20s\n", "School Name", "Student Name",
										"Student Email", "Subject", "Mark");
								System.out.println(
										"===================================================================================================================================");
								for (int i = 0; i < newSchool.studentList.size(); i++) {
									for (int j = 0; j < newSchool.subjectList.size(); j++) {
										System.out.printf("%20s %20s %30s %20s %20s\n", newSchool.name,
												newSchool.studentList.get(i).name,
												newSchool.studentList.get(i).emailList, newSchool.subjectList.get(j),
												newSchool.studentList.get(i).studentSubjectList
														.get(j).studentMark.mark);
									}
									System.out.println(
											"-----------------------------------------------------------------------------------------------------------------------------------");
								}
							}
							/* ++++++++++++++++++++++++++++++++++++++++++ */
							else if (choose1 == 2) {
								try {
									FileWriter writer = new FileWriter("schoolSystem.txt", true);
									writer.write(
											"===================================================================================================================================\n");
									writer.write(String.format("%20s %20s %30s %20s %20s\n", "School Name",
											"Student Name", "Student Email", "Subject", "Mark"));
									writer.write(
											"===================================================================================================================================\n");
									for (int i = 0; i < newSchool.studentList.size(); i++) {
										for (int j = 0; j < newSchool.subjectList.size(); j++) {
											writer.write(String.format("%20s %20s %30s %20s %20s\n", newSchool.name,
													newSchool.studentList.get(i).name,
													newSchool.studentList.get(i).emailList,
													newSchool.subjectList.get(j),
													newSchool.studentList.get(i).studentSubjectList
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
							/* ++++++++++++++++++++++++++++++++++++++++++ */
							else if (choose1 == 3) {
								File folder = new File("C:\\Users\\Lenovo\\Documents\\Transcript");
								if (!folder.exists()) {
									folder.mkdir();
								}

								File file = new File("C:\\Users\\Lenovo\\Documents\\Transcript\\schoolSystem.txt");
								try {
									FileWriter writer = new FileWriter(file, true);
									writer.write(
											"===================================================================================================================================\n");
									writer.write(String.format("%20s %20s %30s %20s %20s\n", "School Name",
											"Student Name", "Student Email", "Subject", "Mark"));
									writer.write(
											"===================================================================================================================================\n");
									for (int i = 0; i < newSchool.studentList.size(); i++) {
										for (int j = 0; j < newSchool.subjectList.size(); j++) {
											writer.write(String.format("%20s %20s %30s %20s %20s\n", newSchool.name,
													newSchool.studentList.get(i).name,
													newSchool.studentList.get(i).emailList,
													newSchool.subjectList.get(j),
													newSchool.studentList.get(i).studentSubjectList
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
////     
			// Search student
			else if (select.equals("6")) {
				searchCount = searchCount + 1;
				int sum = 0;
				boolean loop = true;
				while (loop) {
					System.out.println(
							"-----------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Enter the name:");
					String searchedName = hold.next();
					for (int i = 0; i < newSchool.studentList.size(); i++) {
						if (newSchool.studentList.get(i).name.equalsIgnoreCase(searchedName)) {
							System.out.println("School Name: " + newSchool.name);
							System.out.println("Student Name: " + newSchool.studentList.get(i).name);
							System.out.println("Student MAil: " + newSchool.studentList.get(i).emailList);
							for (int j = 0; j < newSchool.subjectList.size(); j++) {
								System.out.println(newSchool.subjectList.get(j) + " mark is: "
										+ newSchool.studentList.get(i).studentSubjectList.get(j).studentMark.mark);
							}
							sum = sum + 1;
						}
					}
					if (sum == 0) {
						System.out.println("Not Found!");
					}
					System.out.println(
							"-----------------------------------------------------------------------------------------------------------------------------------");

					loop = ask.showQuestion("Do you want to search for other students?");
				}
			}

			// App Statistics
			else if (select.equals("7")) {
				appStatisticsCount = appStatisticsCount + 1;
				System.out.println("       [1] Setup School Details ➤ ︎" + setupCount);
				System.out.println("            [1] Enter School Name ➤ " + schoolNameCount);
				System.out.println("            [2] Enter Subject ➤ " + enterSubjectCount);
				System.out.println("       [2] Enter Student Name ➤ " + enterStudentCount);
				System.out.println("       [3] Enter Grades ➤ " + enterGradesCount);
				System.out.println("       [4] Enter Student Mail ➤ " + enterMailCount);
				System.out.println("       [5] Print All / Transcript ➤ " + printCount);
				System.out.println("       [6] Search Students ➤ " + searchCount);
				System.out.println("       [7] App Statistics ➤ " + appStatisticsCount);
				System.out.println("       [8] Highest Grade for Student ➤ " + highestGradeCount);
				System.out.println("       [9] Delete Student ➤ " + deleteStudentCount);
				System.out.println("       [10] History of students ➤ " + history);
			}

			// Highest Grade
			else if (select.equals("8")) {
				highestGradeCount = highestGradeCount + 1;
				double hieghest = 0;
				int sum = 0;
				String hieghestSubject = " ";
				System.out.println("Enter the name:     ");
				String studentName = hold.next();
				boolean loop = true;
				while (loop) {
					for (int i = 0; i < newSchool.studentList.size(); i++) {
						if (newSchool.studentList.get(i).name.equalsIgnoreCase(studentName)) {
							for (int j = 0; j < newSchool.subjectList.size(); j++) {
								if (newSchool.studentList.get(i).studentSubjectList
										.get(j).studentMark.mark >= hieghest) {
									hieghest = newSchool.studentList.get(i).studentSubjectList.get(j).studentMark.mark;
									hieghestSubject = newSchool.studentList.get(i).studentSubjectList.get(j).name;
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

			// Delete Student
			else if (select.equals("9")) {
				deleteStudentCount = deleteStudentCount + 1;
				boolean loop = true;
				while (loop) {
					for (int i = 0; i < newSchool.studentList.size(); i++) {
						System.out.println("[" + (i + 1) + "] " + newSchool.studentList.get(i).name);
					}
					if (newSchool.studentList.size() == 0) {
						System.out.println("There is no students!");
						loop = false;
					} else {
						System.out.println("Enter Student Number:");
						String studentEntery = hold.next();
						try {
							Integer studentNum = Integer.parseInt(studentEntery);
							if (studentNum < 1 || studentNum > newSchool.studentList.size()) {
								System.out.println("This number is not included in the student list");
							} else {
								newSchool.studentList.remove(studentNum - 1);
								System.out.println("Do you want to delete other students?");
								String subSelect1 = hold.next();
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
			// History
			else if (select.equals("10")) {
				history = history + 1;
				if (historyStack.size() != 0) {
					for (int i = 0; i < historyStack.size(); i++) {
						System.out.println(historyStack.pop());
					}
				} else {
					System.out.println("There is no student");
				}
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