package chapter08;

public abstract class Car {
	
	public abstract void TurnOn();
	public abstract void Drive();
	public abstract void Break();
	public abstract void TurnOff();
	
	final public void run() {
		TurnOn();
		Drive();
		Break();
		TurnOff();
	}
}
