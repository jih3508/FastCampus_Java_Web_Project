
public class AuthException extends RuntimeException{
	public AuthException(String message) {
		super(message);
	}
	
}

//���̵�, ��й�ȣ ��ĭ�ΰ��
class IDAndPasswordNullException extends AuthException{

	public IDAndPasswordNullException(String id, String password) {
		super("��ĭ �Դϴ�.");
		if (id == null || id.equals("")) {
			throw new AuthException("���̵� �Է����ּ���");
		}
		if (password == null || password.equals("")) {
			throw new AuthException("��й�ȣ �Է����ּ���");
		}
		
	}	
}

//��й�ȣ ��ġ ���� �ʴ� ���
class NotPasswordException extends AuthException{

	public NotPasswordException(String password) {
		super("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		// TODO Auto-generated constructor stub
	}
	
}

//2�� ������ Ʋ�����
class SecondAuthoException extends AuthException{

	public SecondAuthoException(String password) {
		super("�߸� �Ǿ����ϴ�.");
		if (password == null || password.equals("")) {
			throw new AuthException("��ĭ�Դϴ�. �ٽ� �Է����ּ���");
		}
		
		
		// TODO Auto-generated constructor stub
	}
}

class IdNotRegisteredException extends AuthException{

	public IdNotRegisteredException(String message) {
		super("����� ���̵� �����ϴ�.");
		// TODO Auto-generated constructor stub
	}
		
}

