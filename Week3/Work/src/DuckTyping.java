
public class DuckTyping implements Duck{

	@Override
	public void walking() {
		System.out.println("Ǫ���");
	}

	@Override
	public void flying() {
		System.out.println("�ڶ� �ڶ�");
	}
}

class �� implements Duck{

	@Override
	public void quack() {
		System.out.println("������!");
	}

	@Override
	public void walking() {
		System.out.println("ȣ�ٴ�!");
	}

	@Override
	public void flying() {
		System.out.println("�ڶ� �ڶ�");
	}
}
