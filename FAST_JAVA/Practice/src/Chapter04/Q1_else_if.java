package Chapter04;

import java.util.Scanner;

public class Q1_else_if {
	
	/*
	 * 연산자와 두 수를 변수로 선언한 후 사칙연산이 수행 되는 프로그램을 만들어 보세요
	 * if-else if-else, switch-case 두 방식 모두 구현해 봅니다.
	 */

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("첫 번쩨 정수를 입력하세요");
		int num1 = scanner.nextInt();
		System.out.println("두 번째 정수를 입력하세요");
		int num2 = scanner.nextInt();
		System.out.println("연산자를 입력하세요");
		char operator = scanner.next().charAt(0);
		
		if (operator == '+') {
			System.out.println(num1 + "+" + num2 + "=" + num1+num2);
		}
		else if(operator == '-') {
			System.out.println(num1 + "-" + num2 + "=" + (num1-num2));
		}
		else if(operator == '*') {
			System.out.println(num1 + "*" + num2 + "=" + num1*num2);
		}
		else if(operator == '/') {
			System.out.println(num1 + "/" + num2 + "=" + num1/num2);
		}
		else {
			System.out.println("잘못 입력했습니다.");
		}	
	}
}
