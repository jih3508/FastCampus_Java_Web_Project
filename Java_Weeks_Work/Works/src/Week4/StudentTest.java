package Week4;

import java.util.HashSet;
import java.util.Set;

/**
 s1, s2�� ���� �й��� �̸��� �����Ƿ� equals�� ���ؼ� true�� �����Ǿ� ���� �л��̶�� ó���ϰ� �ʹ�.
 ���� �ߺ� ������ ������� ���� HashSet�� s1, s2 2���� add �ϴ��� HashSet ���� 1���� ����ǵ��� �ϰ� �ʹ�.
 
 �� �ΰ��� ����� �����ϸ� ������  �� ���� false, false ����� true, ture�� �ٲ� ��µȴ�.
 
 O
*/

class Student {
	int no;
	String name;
	public Student(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return no;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student) obj; 
			
			if(std.name == this.name && std.no == this.no) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
		return false;
		}
	}
	
	
}
public class StudentTest {

	public static void main(String[] args) {
		
		Student s1 = new Student(215233, "kim");
		Student s2 = new Student(215233, "kim");
		
		Set<Student> personSet = new HashSet<>();
		
		personSet.add(s1);
		personSet.add(s2);
		
		System.out.println(s1.equals(s2));
		System.out.println(personSet.size() == 1);
				
	}

}
