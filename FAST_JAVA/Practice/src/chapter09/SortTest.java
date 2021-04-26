package chapter09;

import java.io.IOException;

public class SortTest {

	public static void main(String[] args) throws IOException {
		
		Sort sort;
		System.out.println("���Ĺ���� �����ϼ���.");
		System.out.println("B : BubbleSort");
		System.out.println("H : HeapSort");
		System.out.println("Q : QuickSort");
		
		int n = System.in.read();
		
		if(n == 'B') {
			sort = new BubbleSort();
		}
		else if(n == 'H') {
			sort = new HeapSort();
		}
		else if(n == 'Q') {
			sort = new QuickSort();
		}
		else {
			System.out.println("�߸��Է��߽��ϴ�.");
			return;
		}
		
		int[] arr = {1,4,5,6};
		sort.ascending(arr);
		sort.descending(arr);
		sort.description();
	}
}
