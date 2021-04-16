package chapter6;

import java.util.ArrayList;

public class Student {

	private int studentID;
	private String name;
	ArrayList<Book> bookList;
	
	public Student(int studentID, String name) {
		this.studentID = studentID;
		this.name = name;
		
		bookList = new ArrayList<Book>();
		
	}
	
	public void addBook(String title, String author) {
		bookList.add(new Book(title, author));
	}
	
	public void showStudentInfo() {
		System.out.print(name +" �л��� ���� å�� : ");
		for(Book book : bookList) {
			System.out.print(book.getTitle() + " ");
		}
		System.out.println("�Դϴ�.");
		
	}
}
