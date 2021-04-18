
public class Book {

	private static Book book = null;
	int id;
	String name;
	
	private Book() {
		
	}
	
	public static Book newInstance(int id, String name) {
		if (book == null) {
			book = new Book();
		}
		book.id = id;
		book.name = name;
		
		return book;
	}
}
