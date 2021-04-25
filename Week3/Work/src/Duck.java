
public interface Duck {
	final String quack = "Да Да!";
	public default void quack() {
		System.out.println(quack);
	}
	public void walking();
	public void flying();
}
