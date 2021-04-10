package loopexample;

import java.util.Scanner;

public class DoWhileExample2 {
	
	/*
	 * while문과 do-while문 비교
	 * 입력 받는 정수를 모두 더해 줍니다.
	 * 입력된 정수가 0이면 반복문을 빠져 나옵니다.
	 */

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		int input;
		int sum = 0;
		
		do {
			input = scanner.nextInt();
			sum += input;
		}while(input != 0);
		
		System.out.println(sum);
	}

}
