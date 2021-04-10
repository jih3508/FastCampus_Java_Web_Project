package Chapter4;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("홀수 입력하세요");
		int n = scanner.nextInt();
		int k;
		
		for(int i = 0; i<=n+1; i++) {
			if (i < n/2 + 1) {
				for (k = 0; k< n/2-i; k++){
						System.out.print(' ');
				}
				for (k =0; k < i*2+1; k++) {
					System.out.print('*');
				}
			}
			else {
				for (k = 0; k< i-n/2; k++){
					System.out.print(' ');
			}
			for (k = 0; k < (n-i)*2-1; k++) {
				System.out.print('*');
			}
			}
		System.out.println();
		}
		
	}

}
