
public class AuthException extends RuntimeException{
	public AuthException(String message) {
		super(message);
	}
	
}

//아이디, 비밀번호 빈칸인경우
class IDAndPasswordNullException extends AuthException{

	public IDAndPasswordNullException(String id, String password) {
		super("빈칸 입니다.");
		if (id == null || id.equals("")) {
			throw new AuthException("아이디 입력해주세요");
		}
		if (password == null || password.equals("")) {
			throw new AuthException("비밀번호 입력해주세요");
		}
		
	}	
}

//비밀번호 일치 하지 않는 경우
class NotPasswordException extends AuthException{

	public NotPasswordException(String password) {
		super("비밀번호가 일치하지 않습니다.");
		// TODO Auto-generated constructor stub
	}
	
}

//2차 보안이 틀린경우
class SecondAuthoException extends AuthException{

	public SecondAuthoException(String password) {
		super("잘못 되었습니다.");
		if (password == null || password.equals("")) {
			throw new AuthException("빈칸입니다. 다시 입력해주세요");
		}
		
		
		// TODO Auto-generated constructor stub
	}
}

class IdNotRegisteredException extends AuthException{

	public IdNotRegisteredException(String message) {
		super("등록한 아이디 없습니다.");
		// TODO Auto-generated constructor stub
	}
		
}

