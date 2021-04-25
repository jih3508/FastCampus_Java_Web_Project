class Man{
	public Man() {
		System.out.println("Man");
	}
}

class User extends Man{
	public User() {
		System.out.println("User");
	}
}

public class UserTest {

	public static void main(String[] args) {
		Man man = new User();
	}

}
