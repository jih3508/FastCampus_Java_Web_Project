
public class Person {
	int age;
	String name;
	boolean isMarried;
	int numberOfChildren;
	
	public void printMyChildrun() {
		if (isMarried) {
			System.out.println("���� ��ȥ�̰� �ڳ�� " + numberOfChildren +"�� �Դϴ�.");
		}
		else {
			System.out.println("���� ��ȥ �Դϴ�.");
		}
	}
	
}
