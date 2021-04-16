package array;

public class BookArrayTest {

	public static void main(String[] args) {
		
		Book[] library = new Book[5];
		
		library[0] = new Book("태백산맥1", "조정해");
		library[1] = new Book("태백산맥2", "조정해");
		library[2] = new Book("태백산맥3", "조정해");
		library[3] = new Book("태백산맥4", "조정해");
		library[4] = new Book("태백산맥5", "조정해");
		
		for(int i = 0; i < library.length; i++) {
			System.out.println(library[i]);
		}
	}

}
