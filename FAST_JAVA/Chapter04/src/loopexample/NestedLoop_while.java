package loopexample;

public class NestedLoop_while {

	public static void main(String[] args) {
		
		// 2 ¡¿ 3
		int dan = 2;
		int count = 1;
		
		while( dan <= 9) {
			count = 1;
			while(count <= 9) {
				System.out.println( dan + "¡¿" + count + "=" + dan * count);
				count++;
			}
			dan++;
			System.out.println();
		}
	}

}
