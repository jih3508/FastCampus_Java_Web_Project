package chapter08;

public class Grandeur extends Car{

	@Override
	public void TurnOn() {
		System.out.println("Grandeur �õ��� �մϴ�.");
	}

	@Override
	public void Drive() {
		System.out.println("Grandeur �޸��ϴ�.");
	}

	@Override
	public void Break() {
		System.out.println("Grandeur ����ϴ�.");
	}

	@Override
	public void TurnOff() {
		System.out.println("Grandeur �õ��� ���ϴ�.");
	}
}
