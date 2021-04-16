package staticex;

public class Student {
	
	public int studentID;
	public String studentName;
	public String address;
	private static int serialNum = 1000;
	
	public Student(String name) {
		studentName = name;
		studentID = serialNum;
		serialNum++;
	}
	
	public Student(int id, String name) {
		studentID = id;
		studentName = name;
		address = "주소 없음";
		studentID = serialNum;
		serialNum++;
	}
	
	public void showStudentInfo() {
		System.out.println(studentName + ", " + address);
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public int getStudentID() {
		return studentID;
	}

	public static int getSerialNum() {
		int i = 0;
		//studentName = "Lee"; //stactic 함수안에 인스턴수 변수 사용할 수 없음
		
		return serialNum;
	}

	public static void setSerialNum(int serialNum) {
		Student.serialNum = serialNum;
	}
	
	

}
