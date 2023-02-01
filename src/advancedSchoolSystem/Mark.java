package advancedSchoolSystem;

public class Mark {
	public double mark;
	public static void addMark() {
		boolean loop = true;
		while (loop) {

			if (Main.newSchool.studentList.size() == 0) {
				System.out.println("There is no student!");
				break;
			} else if (Main.newSchool.subjectList.size() == 0) {
				System.out.println("There is no subject!");
				break;
			}
			// Print Students Names
			for (int i = 0; i < Main.newSchool.studentList.size(); i++) {
				System.out.println("[" + (i + 1) + "] " + Main.newSchool.studentList.get(i).name);
			}
			System.out.println("Enter Number of Student:");
			int studentNum;
			if (Main.hold.hasNextInt()) {
				studentNum = Main.hold.nextInt();
				if (studentNum < 1 || studentNum > Main.newSchool.studentList.size()) {
					System.out.println("This number is not included in the student list");
				} else {
					boolean loop2 = true;
					while (loop2) {
						// Print Subjects
						for (int i = 0; i < Main.newSchool.subjectList.size(); i++) {
							System.out.println("[" + (i + 1) + "] " + Main.newSchool.subjectList.get(i));
						}
						System.out.println("Enter Number of Subject");
						String subjectEntery = Main.hold.next();
						try {
							Integer subjectNum = Integer.parseInt(subjectEntery);

							if (subjectNum < 1 || subjectNum > Main.newSchool.subjectList.size()) {
								System.out.println("This number is not included in the subject list");
								break;
							} else {
								// Print Enter Marks
								if (subjectNum < Main.newSchool.subjectList.size() || subjectNum > 0) {
									System.out.println("Enter Marks:");
									String markEntery = Main.hold.next();
									try {
										double studMark = Double.parseDouble(markEntery);
										if (studMark < 0 || studMark > 100) {
											System.out.println("You can not add " + studMark);
											break;
										} else {
											Main.newSchool.studentList.get(studentNum - 1).studentSubjectList
													.get(subjectNum - 1).studentMark.mark = studMark;
											while (true) {
												System.out.println(
														"Do you want to add marks for other subjects?");
												String subSelect = Main.hold.next();
												if (subSelect.equals("Y") || subSelect.equals("y")
														|| subSelect.equals("Yes") || subSelect.equals("yes")) {
													break;
												} else if (subSelect.equals("N") || subSelect.equals("n")
														|| subSelect.equals("No") || subSelect.equals("no")) {
													loop2 = false;
													while (true) {
														System.out.println(
																"Do you want to enter marks for another student?");
														String subSelect1 = Main.hold.next();
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
}
