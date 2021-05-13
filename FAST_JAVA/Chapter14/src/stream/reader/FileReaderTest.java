package stream.reader;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("reader.txt");
		FileInputStream fis = new FileInputStream("reader.txt");
		fis.read();
		int i;
		while((i = fr.read()) != -1) {
			System.out.print((char) i);
		}
		System.out.println();
		while((i = fis.read()) != -1) {
			System.out.print((char) i);
		}
		fis.close();
	}

}
