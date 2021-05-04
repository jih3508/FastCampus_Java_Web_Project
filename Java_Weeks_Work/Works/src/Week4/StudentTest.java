package Week4;

import java.util.HashSet;
import java.util.Set;

/**
 s1, s2는 각각 학번과 이름이 같으므로 equals에 의해서 true로 판정되어 같은 학생이라고 처리하고 싶다.
 또한 중복 저장을 허용하지 않은 HashSet에 s1, s2 2개를 add 하더라도 HashSet 에는 1개만 저장되도록 하고 싶다.
 
 이 두개의 요건을 만족하면 마지막  두 줄의 false, false 출력이 true, ture로 바껴 출력된다.
 
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
