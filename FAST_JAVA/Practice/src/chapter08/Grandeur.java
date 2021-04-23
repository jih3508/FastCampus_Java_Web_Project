package chapter08;

public class Grandeur extends Car{

	@Override
	public void TurnOn() {
		System.out.println("Grandeur 시동을 켭니다.");
	}

	@Override
	public void Drive() {
		System.out.println("Grandeur 달립니다.");
	}

	@Override
	public void Break() {
		System.out.println("Grandeur 멈춥니다.");
	}

	@Override
	public void TurnOff() {
		System.out.println("Grandeur 시동을 끕니다.");
	}
}
