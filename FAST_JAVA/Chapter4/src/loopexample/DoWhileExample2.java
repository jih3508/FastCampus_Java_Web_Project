package loopexample;

import java.util.Scanner;

public class DoWhileExample2 {
	
	/*
	 * while���� do-while�� ��
	 * �Է� �޴� ������ ��� ���� �ݴϴ�.
	 * �Էµ� ������ 0�̸� �ݺ����� ���� ���ɴϴ�.
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
