package Week4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q3 {

	public static HashSet<Integer> variable = new HashSet<Integer>();
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 7, 8, 9, 2, 3, 6, 7, 10);
		
		for (Integer num : numbers) {
			deduplication(num);
		}
		
		variable.stream().sorted();
		
		System.out.println(variable);
		
	}
	
	private static void deduplication(Integer number) {
		variable.add(number);
	}

}
