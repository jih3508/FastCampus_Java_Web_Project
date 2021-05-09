import java.net.URLEncoder;

public class UnsupportedEncodingException {

	public static void main(String[] args) {
		
		try{
			String url = URLEncoder.encode("https://www.ffffastcampus.co.kr/", "UTF-8");
			System.out.println(url);
		} catch(java.io.UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
