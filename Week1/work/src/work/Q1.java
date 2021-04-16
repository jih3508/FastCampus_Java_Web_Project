package work;

public class Q1 {
	
	public static void main(String[] args) {
		
		for(int i = 0; i< 100; i++) {
			if (i % 2 == 0) continue;
			
			if (i == 77) break;
			
			System.out.println(i);
			
		}
	}
}
