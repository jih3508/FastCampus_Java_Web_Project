package work;

public class pratics {

	public static void main(String[] args) {
		for (int x = 0; x < 100; x++) {
			if(x % 2 == 0) continue;
			x+= x;
			
			if(x > 60) {
				System.out.println("´ä : " + x);
				break;
			}
		}
	}
}