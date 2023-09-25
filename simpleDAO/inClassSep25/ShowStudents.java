package inClassSep25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ShowStudents {

	public static void main(String[] args) throws IOException {
		ArrayList<Student> students = new ArrayList<Student>();
		int count;
		
		count=getStudents(students);
		showStudents(students);
		

	}
	
	public static int getStudents(ArrayList<Student> students) throws IOException {
		int recordCnt=0;
		String buffer;
		String[] fields;
		Student student;
		FileReader inFile = new FileReader("students.txt");
		BufferedReader in = new BufferedReader(inFile);
		
		buffer=in.readLine();
		while(buffer!=null) {
			fields=buffer.split(",");
			student = new Student();
			student.setStudentID(fields[0]);
			student.setLastName(fields[1]);
			student.setFirstName(fields[2]);
			student.setEmail(fields[3]);
			students.add(student);
			recordCnt++;
			buffer=in.readLine();
		}
		in.close();
		inFile.close();
		
		return recordCnt;
	}
	
	public static void showStudents(ArrayList<Student> students) {
		int index;
		Student student;

		System.out.printf("| %-3s | %-35s |\n","ID", "Email Address");
		System.out.printf("---------------------------------------------\n");
		for(index=0;index<students.size();index++) {
			student = students.get(index);
			System.out.printf("| %-3s | %-35s |\n",student.getStudentID(), student.getEmail());
		}
	}

}
