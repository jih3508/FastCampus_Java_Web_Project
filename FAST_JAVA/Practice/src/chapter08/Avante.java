package chapter08;

public class Avante extends Car{

	@Override
	public void TurnOn() {
		System.out.println("Avante �õ��� �մϴ�.");
	}

	@Override
	public void Drive() {
		System.out.println("Avante �޸��ϴ�.");
	}

	@Override
	public void Break() {
		System.out.println("Avante ����ϴ�.");
	}

	@Override
	public void TurnOff() {
		System.out.println("Avante �õ��� ���ϴ�.");
	}
}
