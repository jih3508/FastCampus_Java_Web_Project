
abstract class Coffe {
	
	public abstract void boilWarter();
	public abstract void brew();
	public abstract void pourlnCup();
	
	final public void create() {
		boilWarter();
		brew();
		pourlnCup();
	}
}


public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
