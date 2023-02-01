package advancedSchoolSystem;

import java.io.*;

class Serialize implements Serializable {

	public static void main() {

		try {
			FileOutputStream file = new FileOutputStream("schoolSystemSerialization.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);

			for (int i = 0; i < Main.newSchool.studentList.size(); i++) {
				for (int j = 0; j < Main.newSchool.subjectList.size(); j++) {
					out.writeObject(String.format("%20s %20s %30s %20s %20s\n", Main.newSchool.name,
							Main.newSchool.studentList.get(i).name, Main.newSchool.studentList.get(i).emailList,
							Main.newSchool.subjectList.get(j),
							Main.newSchool.studentList.get(i).studentSubjectList.get(j).studentMark.mark));
				}

			}
			out.close();
			file.close();
			System.out.println("serialized and saved");

		} catch (Exception e) {
			e.printStackTrace();

		}
		
		System.out.println("");
		System.out.println("After Serialization");

		try {

			FileInputStream file = new FileInputStream("schoolSystemSerialization.txt");
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			while (true) {
				try {
					String deserializedObject = (String) in.readObject();
					System.out.println(deserializedObject);
				} catch (EOFException e) {
					break;
				} catch (ClassNotFoundException e) {
					System.out.println("Class not found");
				}
			}

			in.close();
			file.close();

		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

	}

}
