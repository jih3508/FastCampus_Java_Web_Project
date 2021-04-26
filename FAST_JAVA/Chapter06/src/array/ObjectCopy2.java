package array;

public class ObjectCopy2 {

	public static void main(String[] args) {
		
		Book[] library = new Book[5];
		Book[] copylibrary = new Book[5];
		
		library[0] = new Book("태백산맥1", "조정해");
		library[1] = new Book("태백산맥2", "조정해");
		library[2] = new Book("태백산맥3", "조정해");
		library[3] = new Book("태백산맥4", "조정해");
		library[4] = new Book("태백산맥5", "조정해");
		
		System.arraycopy(library, 0, copylibrary, 0, 5);
		
		for (Book book : copylibrary) {
			book.showBookInfo();
		}
		
		library[0].setTitle("나목");
		library[0].setAuthor("박완서");
		
		for(Book book : library) {
			book.showBookInfo();
		}
		
		System.out.println("===========================");
		
		for(Book book : copylibrary) {
			book.showBookInfo();
		}
	}

}
