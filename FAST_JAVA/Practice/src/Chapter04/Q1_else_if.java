package Chapter04;

import java.util.Scanner;

public class Q1_else_if {
	
	/*
	 * �����ڿ� �� ���� ������ ������ �� ��Ģ������ ���� �Ǵ� ���α׷��� ����� ������
	 * if-else if-else, switch-case �� ��� ��� ������ ���ϴ�.
	 */

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("ù ���� ������ �Է��ϼ���");
		int num1 = scanner.nextInt();
		System.out.println("�� ��° ������ �Է��ϼ���");
		int num2 = scanner.nextInt();
		System.out.println("�����ڸ� �Է��ϼ���");
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
			System.out.println("�߸� �Է��߽��ϴ�.");
		}	
	}
}
