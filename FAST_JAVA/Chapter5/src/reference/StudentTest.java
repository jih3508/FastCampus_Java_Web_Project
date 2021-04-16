package reference;

public class StudentTest {

	public static void main(String[] args) {
		
		Student studentLee = new Student(100, "Lee");
		studentLee.setKoreaSubject("국어", 100);
		studentLee.setMathSubject("수학", 95);
		
		
		Student studentKim = new Student(100, "Kim");
		studentKim.setKoreaSubject("국어", 100);
		studentKim.setMathSubject("수학", 95);
		
		studentLee.showStudentScore();
		studentKim.showStudentScore();
				
	}

}
