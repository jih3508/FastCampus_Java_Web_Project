package loopexample;

import java.util.Scanner;

public class WhileExample2 {

	/*
	 * while���� do-while�� ��
	 * �Է� �޴� ������ ��� ���� �ݴϴ�.
	 * �Էµ� ������ 0�̸� �ݺ����� ���� ���ɴϴ�.
	 */
	public static void main(String[] args) {
		
		int input;
		int sum = 0;
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextInt();
		
		while (input != 0) {
			sum += input;
			input = scanner.nextInt();
		}
		
		System.out.println(sum);
	}

}
