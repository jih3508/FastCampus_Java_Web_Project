package reference;

public class StudentTest {

	public static void main(String[] args) {
		
		Student studentLee = new Student(100, "Lee");
		studentLee.setKoreaSubject("����", 100);
		studentLee.setMathSubject("����", 95);
		
		
		Student studentKim = new Student(100, "Kim");
		studentKim.setKoreaSubject("����", 100);
		studentKim.setMathSubject("����", 95);
		
		studentLee.showStudentScore();
		studentKim.showStudentScore();
				
	}

}
