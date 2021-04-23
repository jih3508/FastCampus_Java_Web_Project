package chapter08;

public class Avante extends Car{

	@Override
	public void TurnOn() {
		System.out.println("Avante 시동을 켭니다.");
	}

	@Override
	public void Drive() {
		System.out.println("Avante 달립니다.");
	}

	@Override
	public void Break() {
		System.out.println("Avante 멈춥니다.");
	}

	@Override
	public void TurnOff() {
		System.out.println("Avante 시동을 끕니다.");
	}
}
