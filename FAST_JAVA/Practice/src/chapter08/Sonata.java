package chapter08;

public class Sonata extends Car{
	
	@Override
	public void TurnOn() {
		System.out.println("Sonata �õ��� �մϴ�.");
	}

	@Override
	public void Drive() {
		System.out.println("Sonata �޸��ϴ�.");
	}

	@Override
	public void Break() {
		System.out.println("Sonata ����ϴ�.");
	}

	@Override
	public void TurnOff() {
		System.out.println("Sonata �õ��� ���ϴ�.");
	}
}
