package chapter08;

public class Genesis extends Car{
	
	@Override
	public void TurnOn() {
		System.out.println("Genesis �õ��� �մϴ�.");
	}

	@Override
	public void Drive() {
		System.out.println("Genesis �޸��ϴ�.");
	}

	@Override
	public void Break() {
		System.out.println("Genesis ����ϴ�.");
	}

	@Override
	public void TurnOff() {
		System.out.println("Genesis �õ��� ���ϴ�.");
	}

}
