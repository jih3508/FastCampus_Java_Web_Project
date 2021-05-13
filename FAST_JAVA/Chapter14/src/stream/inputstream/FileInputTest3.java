package stream.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputTest3 {

	public static void main(String[] args) {
		
		try (FileInputStream fis = new FileInputStream("input2.txt")){
			int i;
			byte[] bs = new byte[10];
			while((i = fis.read(bs)) != -1) {
				/*for(byte b : bs) { //비어 있는 배열 부분은 비어있는 만큼 전의 뒤부분을 출력한다.(가비지 배열)
					System.out.print((char)b);
				}*/
				
				for(int k=0; k<i; k++) {
					System.out.print((char)bs[k]);
				}
				System.out.println();
			}
		
		} catch(IOException e) {
			e.printStackTrace();
		}
		//System.out.println("end");
	}

}
