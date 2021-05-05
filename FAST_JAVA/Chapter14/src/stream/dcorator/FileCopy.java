package stream.dcorator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		
		long milliseconds = 0;
		
		try(FileInputStream fis = new FileInputStream("a.zip");
			FileOutputStream fos = new FileOutputStream("copy.zip");
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos)){
			
			milliseconds = System.currentTimeMillis();
			
			int i;
			while((i = fis.read()) != -1) {
				fos.write(i);
			}
			
			milliseconds = System.currentTimeMillis() - milliseconds;
		}catch(IOException e) {
				System.out.println(e);
		}
		System.out.println("½Ã°£: " + milliseconds);
		
		//Socket socket = new Socket();
		
		//InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			
		
	}
				
}


