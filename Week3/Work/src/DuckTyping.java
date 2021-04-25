
public class DuckTyping implements Duck{

	@Override
	public void walking() {
		System.out.println("Çªµåµæ");
	}

	@Override
	public void flying() {
		System.out.println("µÚ¶× µÚ¶×");
	}
}

class ´ß implements Duck{

	@Override
	public void quack() {
		System.out.println("²¿³¢¿À!");
	}

	@Override
	public void walking() {
		System.out.println("È£´Ù´ß!");
	}

	@Override
	public void flying() {
		System.out.println("µÚ¶× µÚ¶×");
	}
}
