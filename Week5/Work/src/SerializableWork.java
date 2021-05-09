import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class SerializableWork {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Member member = new Member();
		member.setName("kim");
		member.setAge(20);
		
		//Serialize
		byte[] serializedMember;
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
			try(ObjectOutputStream oos = new ObjectOutputStream(baos)){
				oos.writeObject(member);
				
				serializedMember = baos.toByteArray();
			}
		}
		
		String base64Member = Base64.getEncoder().encodeToString(serializedMember);
		System.out.println(base64Member);
		
		// Deserialize
		byte[] deserializedMember = Base64.getDecoder().decode(base64Member);
		try(ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)){
			try(ObjectInputStream ois = new ObjectInputStream(bais)){
				Object objectMember = ois.readObject();
				Member deserializedmember = (Member) objectMember;
				System.out.println(deserializedmember);
			}
		}
		
	}
	static class Member implements Serializable{
		String name;
		int age;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		@Override
		public String toString() {
			return "Member{" +
					"name='" + name + '\'' +
					", age=" + age +
					'}';
		}
	}
}


