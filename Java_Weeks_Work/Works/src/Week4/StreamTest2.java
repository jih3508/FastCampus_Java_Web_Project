package Week4;

import java.util.Arrays;
import java.util.List;

public class StreamTest2 {

	class Member{
		private String name;
		private int penaltyCount;
		private String nickName;
		
		public Member(String name, int penalyCount, String nickName) {
			this.name = name;
			this.penaltyCount = penalyCount;
			this.nickName = nickName;
		}
		
		public int getPenaltyCount() {
			return penaltyCount;
		}
	}
	public static void main(String[] args) {
		StreamTest2 outterClass = new StreamTest2();
		List<StreamTest2.Member> members = Arrays.asList(
				outterClass.new Member("�⿵��", 2, "��Ʈ�ɽ�"),
				outterClass.new Member("��ö��", 5, "�Ҳɵ帳"),
				outterClass.new Member("����", 0, "�ڶ󳪶�Ӹ���"),
				outterClass.new Member("�̸���", 6, "�ӽ�129")
		);
		
		int sum = members.stream().map(s->s.getPenaltyCount()).reduce(0,(a, b) -> a+b);
		System.out.println("�⿵�̳� �г�Ƽ�� ���� : " + sum);
	}

}
