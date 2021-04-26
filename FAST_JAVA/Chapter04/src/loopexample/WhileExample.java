package loopexample;

public class WhileExample {

	public static void main(String[] args) {
		
		int num = 1;
		int sum = 0;
		
		while (num <= 10) {
			sum += num;
			num++; //11에 빠져 나온다. 
		}
		
		System.out.println(sum);
		System.out.println(num);
	}

}
