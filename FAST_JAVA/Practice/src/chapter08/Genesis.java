package chapter08;

public class Genesis extends Car{
	
	@Override
	public void TurnOn() {
		System.out.println("Genesis 시동을 켭니다.");
	}

	@Override
	public void Drive() {
		System.out.println("Genesis 달립니다.");
	}

	@Override
	public void Break() {
		System.out.println("Genesis 멈춥니다.");
	}

	@Override
	public void TurnOff() {
		System.out.println("Genesis 시동을 끕니다.");
	}

}
